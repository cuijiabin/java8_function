package com.function.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

public class JsonConvert {
    /**
     * 转换确认收货出账信息
     *
     * @param content 苏宁接口结果
     * @return list
     */
    private List<OrderItemInfo> convertOrderItemInfoList(String content) {
        JSONObject json = JSONObject.parseObject(content);
        json = json.getJSONObject("sn_responseContent");
        if (json == null) {
            return null;
        }

        json = json.getJSONObject("sn_body");
        if (json == null) {
            return null;
        }

        json = json.getJSONObject("confirmCmmdtyreceive");
        if (json == null) {
            return null;
        }

        JSONArray jsonArray = json.getJSONArray("orderItemInfo");
        if (jsonArray == null) {
            return null;
        }

        return jsonArray.toJavaList(OrderItemInfo.class);
    }

    /**
     * 确认收货出账信息返回结果
     */
    static class OrderItemInfo {

        private String orderItemId;
        private String returnCode;
        private String returnMessage;

        public String getOrderItemId() {
            return orderItemId;
        }

        public void setOrderItemId(String orderItemId) {
            this.orderItemId = orderItemId;
        }

        public String getReturnCode() {
            return returnCode;
        }

        public void setReturnCode(String returnCode) {
            this.returnCode = returnCode;
        }

        public String getReturnMessage() {
            return returnMessage;
        }

        public void setReturnMessage(String returnMessage) {
            this.returnMessage = returnMessage;
        }

        @Override
        public String toString() {
            return "OrderItemInfo{" +
                    "orderItemId='" + orderItemId + '\'' +
                    ", returnCode='" + returnCode + '\'' +
                    ", returnMessage='" + returnMessage + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<String> snRowItemIdList = Arrays.asList("2147483647", "2147483647", "2147483647");
        JSONArray orderItemInfo = new JSONArray();
        for (String snRowItemId : snRowItemIdList) {
            JSONObject sn = new JSONObject();

            sn.put("orderItemId", snRowItemId);
            sn.put("returnCode", "N");
            sn.put("returnMessage", "{\"errorCode\":\"biz.online.confirmcmmdtyreceive.invalid-biz:102\",\"errorMsg\":\"订单不存在\"}");

            orderItemInfo.add(sn);
        }

        JSONObject confirmCmmdtyreceive = new JSONObject();
        confirmCmmdtyreceive.put("orderItemInfo", orderItemInfo);

        JSONObject sn_body = new JSONObject();
        sn_body.put("confirmCmmdtyreceive", confirmCmmdtyreceive);

        JSONObject sn_request = new JSONObject();
        sn_request.put("sn_body", sn_body);

        JSONObject request_data = new JSONObject();
        request_data.put("sn_responseContent", sn_request);

        String content = request_data.toJSONString();
        System.out.println(content);

        JsonConvert c = new JsonConvert();
        List<OrderItemInfo> list = c.convertOrderItemInfoList(content);
        list.forEach(System.out::println);
    }
}
