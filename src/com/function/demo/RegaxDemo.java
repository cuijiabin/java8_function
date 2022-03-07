package com.function.demo;

import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegaxDemo {
    public static void main(String[] args) {

        List<String> addressList = Arrays.asList("江北金石二路汝湖镇荣头村惠荣生活超市", "云南省昆明市呈贡区马金铺高新邻里绿苑小区7-2907", "河南省郑州市金水区姚桥乡龙子湖街道陈三桥社区西院", "广裕路广裕超市楼上", "河北省涞水县东文山乡东长堤村中街47号", "河北省邢台市南和县怡馨家园小区4号楼二单元401", "四川省宜宾市泥南镇", "中华北路金银新村菜市", "沈阳市浑南区绮霞街 浦江御景湾 7号楼 1-25-1", " 浙江省 台州市 三门县 全境 浦坝港镇圩岙村", "沙溪坝三棵树绿色食品超市（不要使用中通，无快递站点）", " 上海市 青浦区 全境 华新镇华腾路华腾苑555弄6号楼401", "贵州省贵阳市观山湖区碧海乾图花园9-5栋1单元", "重庆市九龙坡区石桥铺新阳苑1单元", "市府路税务局", "城市花园73栋", "城市花园73栋", "贵州省赤水市南桥路、江源小区二栋一单元602室", "龙潮村八佳超市后面第一条巷子", "四川省甘孜藏族州甘孜县甘孜镇格达小区", "武汉市东湖新技术开发区，光谷大道308号10栋1楼，武汉企邦物业有限公司", "莲花西路开福市场后兴盛玉栖苑", "新桥街道企安路城市丽都花园8B505", "河北省邢台市桥东区中兴大街创智园小区", "湖北省荆门市钟祥市郢中街道王府大道路王府广场A栋2单元401室 ", "乌苏市塔里木河东路046号", "广西省贵港市港南区桥圩镇白洋路56号", "邹平市黄山东路22号鲁中职业学院", "市府路税务局", "讷河市讷河二中", "上海市静安区康定路1018号2楼227室", "上海市静安区康定路1018号2楼227室", "广东省广州市白云区均禾街道富力城北区E12栋301", "福建省泉州市洛江区万安街道第十一中学安达路1号", "河市镇机场篮球场家家乐超市（到了电话联系，谢谢！）", "贵州省遵义市播州区南白客运站通村村调度中心23215143收，j03", "重庆市彭水县新田镇新田中学旁边", "和田市古勒巴格街道北京西路287号和田师范专科学校 ", "四川省，遂宁市，大英县，回马镇陶都街", "河南省漯河市召陵区黄岗村君临华府", "广东省 深圳市 龙岗区 全境 布吉街道东大街八期桂芳园搅月阁33C拣1702室 ", "浙江省衢州市江山市清湖街道清泉二区9号", "广东省 深圳市 龙岗区 全境 布吉街道东大街八期桂芳园搅月阁33C拣1702室 ", "摩托车市场和谐家园六栋三单元", "阿克苏市新城街道仁和春天小区", "北京市房山区韩村河镇孤山口村健身器对面", "丹东市振兴区书香苑小区36-2北方机床", "宏图大道城市风景20栋1单元", "重庆市渝北区礼嘉白马花园六号地", "重庆市渝北区礼嘉镇白马小区6号地强强电器", "海府路32号省粮食局宿舍楼", "贵州省贵阳市白云区艳山红镇，西南家具城C区（板材区）2栋3单元202", "成都市郫都区龙光君悦华庭二期", "重庆市大渡口区大堰二村22号", "英阿瓦提路朝阳佳苑后门亿客隆超市", "太平小区菜市场7号铺金福娃童装母婴店", "成都市双流华阳滨河路二段戛纳湾滨江", "合肥市肥西县禹州华侨城三期荷园20栋2406室", "湖南省株洲市茶陵县高陇镇，高陇街上", "湖北省宜昌市枝江市百里洲乡新和村一组，覃明新，‭13618689365‬", "米市苑小区", "新疆乌鲁木齐市水磨沟区新民东街140号绿景花苑一期", "甘肃省兰州市城关区雁滩莱茵小镇2号楼", "玉溪市红塔区许家湾路28号", "北京市昌平区回龙观龙跃一区24号楼二单元402", "海南省东方市琼西路碧海云天 G1(601)", "九龙坡区渝州路街道石小路177号康德城市风云3栋", "湖北省随州市曾都区东城办事处文峰塔居委会8⃣️组（美多超市", "福建省厦门市翔安区新圩镇龙新路39号", "广东省深圳市龙岗区南联谭鸭血", "安徽省亳州市谯城区光明东路贾元中心路10号", "八里湾镇东方超市", "喜树街780号锦江城市花园一期2栋3302", "宜兴阜旷世新城春泽苑2号楼1门803或者3号楼奋斗猫超市", "四川省成都市成华区东丽街51号首创光和城2期", "广东省湛江市雷州市中国园酒店西湖大道198号", "库尔勒市千城梨香水韵41栋3单元302", "秀兰城市美地8号楼", "湖南省长沙市望城区百合湖滨2栋1205室", "广东省揭阳市惠来县周田镇前湖中学", "广东省揭阳市普宁市船埔镇天青村", "四川省遂宁市船山区明月路海琪明月花园", "昆明市五华区黑林铺街道玉峰路普惠园小区", "安徽省合肥市肥西县紫蓬山开发区紫蓬小区", "重庆市奉节县新民镇长鹏村史家平6组", "油山镇油山市场", "安徽省宣城市泾县泾川镇泾秀苑15幢2楼", "陕西省西安市鄠邑区大王镇大庞路，陕西商储西咸沣西物流园（蜜芽项目组 售后部）", "新疆喀什市阿瓦提乡9村8组", "凤凰城南区(马鞍山市含山县)", "广东省云浮市云城区 全境振华南一路16号（交警宿舍对面）", "楚雄市茶花大道白龙雅苑二期商铺23-3号兴海不锈钢", "解放路2号宜昌市第一人民医院 辅助楼3层 捐赠物资库房（蜜芽公司捐赠抗菌用品）", "解放路2号宜昌市第一人民医院 辅助楼3层 捐赠物资库房（蜜芽公司捐赠医用口罩）", "湖北省襄阳市第一人民医院樊城区解放路15号 （蜜芽公司捐赠医用口罩）", "解放路2号宜昌市第一人民医院 辅助楼3层 捐赠物资库房（蜜芽公司捐赠抗菌用品）", "市辖区城外老剪子口洋洲公寓", "库尔勒市千城梨香水韵41栋3单元302", "上海市静安区公兴路175号 （蜜芽公司捐赠物资）", "上海市静安区公兴路175号 （蜜芽公司捐赠物资）");
        for (String address : addressList) {
            System.out.println(address);
//            System.out.println(addressResolution(address));
            System.out.println(getAddressInfo(address));
        }

    }


    /**
     * 解析地址
     *
     * @param address
     * @return
     * @author lin
     */
    public static List<Map<String, String>> addressResolution(String address) {
        String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m = Pattern.compile(regex).matcher(address);
        String province = null, city = null, county = null, town = null, village = null;
        List<Map<String, String>> table = new ArrayList<Map<String, String>>();
        Map<String, String> row = null;
        while (m.find()) {
            row = new LinkedHashMap<String, String>();
            province = m.group("province");
            row.put("province", province == null ? "" : province.trim());
            city = m.group("city");
            row.put("city", city == null ? "" : city.trim());
            county = m.group("county");
            row.put("county", county == null ? "" : county.trim());
            town = m.group("town");
            row.put("town", town == null ? "" : town.trim());
            village = m.group("village");
            row.put("village", village == null ? "" : village.trim());
            table.add(row);
        }
        return table;
    }


    /**
     * 解析地址
     *
     * @param address
     * @return
     */
    public static Map<String, String> getAddressInfo(String address) {
        //1级 省 自治区  2级 市 自治州 地区 3级：区县市旗(镇？)
        String province = null, city = null, provinceAndCity = null, town = null;
        Map<String, String> row = new LinkedHashMap<>();
        List<Map<String, String>> table = new ArrayList<>();
        Map<String, String> resultMap = new HashMap<>(4);

        if (address.startsWith("香港特别行政区")) {
            resultMap.put("province", "香港");
            return resultMap;
        } else if (address.contains("澳门特别行政区")) {
            resultMap.put("province", "澳门");
            return resultMap;
        } else if (address.contains("台湾")) {
            resultMap.put("province", "台湾");
            return resultMap;
        } else {
            //普通地址
            String regex = "((?<provinceAndCity>[^市]+市|.*?自治州|.*?区|.*县)(?<town>[^区]+区|.*?市|.*?县|.*?路|.*?街|.*?道|.*?镇|.*?旗)(?<detailAddress>.*))";
            Matcher m = Pattern.compile(regex).matcher(address);
            while (m.find()) {
                provinceAndCity = m.group("provinceAndCity");
                String regex2 = "((?<province>[^省]+省|.+自治区|上海市|北京市|天津市|重庆市|上海|北京|天津|重庆)(?<city>.*))";
                Matcher m2 = Pattern.compile(regex2).matcher(provinceAndCity);
                while (m2.find()) {
                    province = m2.group("province");
                    row.put("province", province == null ? "" : province.trim());
                    city = m2.group("city");
                    row.put("city", city == null ? "" : city.trim());
                }
                town = m.group("town");
                row.put("town", town == null ? "" : town.trim());
                table.add(row);
            }
        }
        if (table != null && table.size() > 0) {
            if (StringUtils.isNotBlank(table.get(0).get("province"))) {
                province = table.get(0).get("province");
                //对自治区进行处理
                if (province.contains("自治区")) {
                    if (province.contains("内蒙古")) {
                        province = province.substring(0, 4);
                    } else {
                        province = province.substring(0, 3);
                    }

                }
            }
            if (StringUtils.isNotBlank(province)) {
                if (StringUtils.isNotBlank(table.get(0).get("city"))) {
                    city = table.get(0).get("city");
                    if (city.equals("上海市") || city.equals("重庆市") || city.equals("北京市") || city.equals("天津市")) {
                        province = table.get(0).get("city");
                    }
                } else if (province.equals("上海市") || province.equals("重庆市") || province.equals("北京市") || province.equals("天津市")) {
                    city = province;
                }
                if (StringUtils.isNotBlank(table.get(0).get("town"))) {
                    town = table.get(0).get("town");
                }
                province = province.substring(0, province.length() - 1);

            }

        } else {
            return resultMap;
        }
        resultMap.put("province", province);
        resultMap.put("city", city);
        resultMap.put("area", town);

        return resultMap;
    }

}
