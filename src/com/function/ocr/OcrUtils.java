package com.function.ocr;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.commons.collections.CollectionUtils;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class OcrUtils {

    public static List<String> ocrImg(byte[] imgData) {
        return bdAccurateOcr(imgData);
    }

    private static List<String> bdGeneralOcr(byte[] imgData) {
        return bdBaseOcr(imgData, "general_location");
    }

    private static List<String> bdAccurateOcr(byte[] imgData) {
        return bdBaseOcr(imgData, "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate");
    }

    private static List<String> bdBaseOcr(byte[] imgData, String type) {
        String[] urlArr = new String[]{"http://ai.baidu.com/tech/ocr/general", "http://ai.baidu.com/index/seccode?action=show"};
        StringBuilder cookie = new StringBuilder();
        for (String url : urlArr) {
            HttpResponse cookieResp = WebUtils.get(url);
            List<String> ckList = cookieResp.headerList("Set-Cookie");
            for (String s : ckList) {
                cookie.append(s.replaceAll("expires[\\S\\s]+", ""));
            }
        }
        HashMap<String, String> header = new HashMap<>();
        header.put("Referer", "http://ai.baidu.com/tech/ocr/general");
        header.put("Cookie", cookie.toString());
        String data = "type=" + URLUtil.encodeQuery(type) + "&detect_direction=false&image_url&image=" + URLUtil.encodeQuery("data:image/jpeg;base64," + Base64.encode(imgData)) + "&language_type=CHN_ENG";
        HttpResponse response = WebUtils.postRaw("http://ai.baidu.com/aidemo", data, 0, header);
        return extractBdResult(WebUtils.getSafeHtml(response));
    }

    public static List<String> sogouMobileOcr(byte[] imgData) {
        String boundary = "------WebKitFormBoundary8orYTmcj8BHvQpVU";
        String url = "http://ocr.shouji.sogou.com/v2/ocr/json";
        String header = boundary + "\r\nContent-Disposition: form-data; name=\"pic\"; filename=\"pic.jpg\"\r\nContent-Type: image/jpeg\r\n\r\n";
        String footer = "\r\n" + boundary + "--\r\n";
        byte[] postData = mergeByte(header.getBytes(CharsetUtil.CHARSET_ISO_8859_1), imgData, footer.getBytes(CharsetUtil.CHARSET_ISO_8859_1));
        return extractSogouResult(postMultiData(url, postData, boundary.substring(2)));
    }

    public static List<String> sogouWebOcr(byte[] imgData) {
        String url = "https://deepi.sogou.com/api/sogouService";
        String referer = "https://deepi.sogou.com/?from=picsearch&tdsourcetag=s_pctim_aiomsg";
        String imageData = Base64.encode(imgData);
        long t = System.currentTimeMillis();
        String sign = SecureUtil.md5("sogou_ocr_just_for_deepibasicOpenOcr" + t + imageData.substring(0, Math.min(1024, imageData.length())) + "4b66a37108dab018ace616c4ae07e644");
        Map<String, Object> data = new HashMap<>();
        data.put("image", imageData);
        data.put("lang", "zh-Chs");
        data.put("pid", "sogou_ocr_just_for_deepi");
        data.put("salt", t);
        data.put("service", "basicOpenOcr");
        data.put("sign", sign);
        HttpRequest request = HttpUtil.createPost(url).timeout(15000);
        request.form(data);
        request.header("Referer", referer);
        HttpResponse response = request.execute();
        return extractSogouResult(WebUtils.getSafeHtml(response));
    }

    private static List<String> extractSogouResult(String html) {
        if (StrUtil.isBlank(html)) {
            return null;
        }
        JSONObject jsonObject = JSONUtil.parseObj(html);
        if (jsonObject.getInt("success", 0) != 1) {
            return null;
        }
        JSONArray jsonArray = jsonObject.getJSONArray("result");
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jObj = jsonArray.getJSONObject(i);
            resultList.add(jObj.getStr("content").trim());
        }
        return resultList;
    }

    private static List<String> extractBdResult(String html) {
        if (StrUtil.isBlank(html)) {
            return null;
        }
        JSONObject jsonObject = JSONUtil.parseObj(html);
        if (jsonObject.getInt("errno", 0) != 0) {
            return null;
        }
        JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("words_result");
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jObj = jsonArray.getJSONObject(i);
            resultList.add(jObj.getStr("words").trim());
        }
        return resultList;
    }

    static byte[] mergeByte(byte[]... bytes) {
        int length = 0;
        for (byte[] b : bytes) {
            length += b.length;
        }
        byte[] resultBytes = new byte[length];
        int offset = 0;
        for (byte[] arr : bytes) {
            System.arraycopy(arr, 0, resultBytes, offset, arr.length);
            offset += arr.length;
        }
        return resultBytes;
    }

    static String postMultiData(String url, byte[] data, String boundary) {
        return postMultiData(url, data, boundary, "", "");
    }

    private static String postMultiData(String url, byte[] data, String boundary, String cookie, String referer) {
        try {
            HttpRequest request = HttpUtil.createPost(url).timeout(15000);
            request.contentType("multipart/form-data; boundary=" + boundary);
            request.body(data);
            if (StrUtil.isNotBlank(referer)) {
                request.header("Referer", referer);
            }
            if (StrUtil.isNotBlank(cookie)) {
                request.cookie(cookie);
            }
            HttpResponse response = request.execute();
            return WebUtils.getSafeHtml(response);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static byte[] imageToBytes(BufferedImage img) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MemoryCacheImageOutputStream outputStream = new MemoryCacheImageOutputStream(byteArrayOutputStream);
        try {
            Iterator iter = ImageIO.getImageWritersByFormatName("jpeg");
            ImageWriter writer = (ImageWriter) iter.next();
            ImageWriteParam iwp = writer.getDefaultWriteParam();
            iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            iwp.setCompressionQuality(0.5f);
            writer.setOutput(outputStream);
            IIOImage image = new IIOImage(img, null, null);
            writer.write(null, image, iwp);
            writer.dispose();
            byte[] result = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            outputStream.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static void handleList(int start, int end) {
        for (int i = start; i < end; i++) {
            try {
                System.out.println("<==========================" + i + "start==============================>");
                System.out.println("");
                File selectedFile = new File("E:\\file\\book\\convert\\mx_" + i + ".jpg");
                BufferedImage image = ImageIO.read(selectedFile);
                byte[] bytes = imageToBytes(image);
                List<String> resultList = bdAccurateOcr(bytes);
                if (CollectionUtils.isNotEmpty(resultList)) {
                    resultList.forEach(System.out::println);
                }
                System.out.println("");
                System.out.println("<==========================" + i + "end ==============================>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void handleFile(String name) {
        try {
            File selectedFile = new File("E:\\file\\download\\纯粹导图\\" + name);
            BufferedImage image = ImageIO.read(selectedFile);
            byte[] bytes = imageToBytes(image);
            List<String> resultList = bdAccurateOcr(bytes);
            if (CollectionUtils.isNotEmpty(resultList)) {
                resultList.forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        handleList(300, 378);
    }
}
