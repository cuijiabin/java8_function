package com.function.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class EsDemo {

    public static void main(String[] args) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("10.5.97.40", 9300, "http"),
                        new HttpHost("10.5.97.195", 9300, "http"),
                        new HttpHost("10.5.97.200", 9300, "http")));

        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
