package com.function.demo;

import com.hankcs.hanlp.restful.HanLPClient;

import java.io.IOException;

public class HanLPDemo {

    public static void main(String[] args) throws IOException {
        // auth不填则匿名，zh中文，mul多语种
        HanLPClient HanLP = new HanLPClient("https://www.hanlp.com/api", null, "zh", 60);
        HanLP.parse("2021年HanLPv2.1为生产环境带来次世代最先进的多语种NLP技术。阿婆主来到北京立方庭参观自然语义科技公司。");
    }
}
