package com.function.es;


import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Created by stone on 17/3/22.
 */
public class EsTest {
    protected final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private String CLUSTER_NAME = "log";
    private Settings settings = Settings.builder()
            .put("cluster.name", CLUSTER_NAME)
            .put("client.transport.sniff", true)
            .build();
    private TransportClient client;

    private String es_host = "10.1.114.1:9300,10.1.11.30:9300,10.1.11.31:9300";

//    public TransportClient getClient() throws UnknownHostException {
//        if (client == null) {
//            synchronized (ESClient.class) {
//                if (client == null) {
//                    client = TransportClient.builder().settings(settings).build();
//                    for (String host_port : es_host.split(",")) {
//                        String[] s = host_port.split(":");
//                        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(s[0]), Integer.valueOf(s[1])));
//                    }
//                }
//            }
//        }
//        return client;
//    }
//
//    protected final String TIMESTAMP_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.sss'Z'";
//    // from to index query_string
//    protected final String discoverUrl = "http://elk.ops.mia.com/app/kibana?#/discover?_g=(refreshInterval:(display:Off,pause:!f,section:0,value:0),time:(from:'%s',mode:absolute,to:'%s'))&_a=(columns:!(_source),filters:!(),index:'%s',interval:auto,query:(query_string:(analyze_wildcard:!t,query:'%s')),sort:!('@timestamp',desc))";
//    // index from to query_string aggs
//    protected final String visualizeUrl = "http://elk.ops.mia.com/app/kibana#/visualize/create?type=histogram&indexPattern=%s&_g=(refreshInterval:(display:Off,pause:!f,value:0),time:(from:'%s',mode:absolute,to:'%s'))&_a=(filters:!(),linked:!f,query:(query_string:(analyze_wildcard:!t,query:'%s')),vis:(aggs:!(%s),listeners:(),params:(addLegend:!t,addTimeMarker:!f,addTooltip:!t,defaultYExtents:!f,mode:stacked,scale:linear,setYExtents:!f,shareYAxis:!t,spyPerPage:100,times:!(),yAxis:()),type:histogram))";
//
//    protected String getELKDiscover(Date startTime, Date endTime, String index, String queryString) {
//        return String.format(discoverUrl,
//                DateFormatUtils.formatUTC(startTime, TIMESTAMP_PATTERN),
//                DateFormatUtils.formatUTC(endTime, TIMESTAMP_PATTERN),
//                index,
//                queryString);
//    }
//
//    @Test
//    public void filterFailCoupon() throws UnknownHostException {
//        BoolQueryBuilder queryBuilder = boolQuery()
//                .must(queryStringQuery("\"normal-20170519-3\" AND \"-1014\" AND method:\"bindCouponByBatchCode\"").analyzeWildcard(true));
//
//        // 时间过滤
//        queryBuilder.filter(rangeQuery("@timestamp").from(1495417055838L).to(1495503455839L));
//        //
//        SearchRequestBuilder requestBuilder = getClient().prepareSearch("logstash-coupon-*")
//                .setTypes("application_log").setFrom(0).setSize(1000).setExplain(true);
//        requestBuilder.setQuery(queryBuilder);
//        //
//        SearchResponse response = requestBuilder.execute().actionGet();
//        SearchHit[] hits = response.getHits().getHits();
//        System.err.println(hits.length);
//        for (int i = 0; i < hits.length; i++) {
//            Map<String, Object> source = hits[i].getSource();
//            if (source.containsKey("logmessage")) {
//                Object o = source.get("logmessage");
//                JavaType javaType = JacksonUtils.jsonJavaTypeForMap(HashMap.class, String.class, Object.class);
//                Map<String, Object> m = JacksonUtils.jsonToObject(o.toString(), javaType);
//                if (m.containsKey("params")) {
//                    Map<String, Object> ps = (Map<String, Object>) m.get("params");
//                    if (ps.containsKey("p0")) {
//                        Map<String, Object> p0 = (Map<String, Object>) ps.get("p0");
//                        System.err.println(p0.get("uid"));
//                    }
//                }
//            }
//        }
//    }
//
//
//    @Test
//    public void testBackRefund() throws ParseException, UnknownHostException {
//        String qStr = "\"创建退款单失败\"";
//        String type = "application_log";
//        String index = "logstash-order-*";
//        Date startTime = DateUtils.parseDate("2017-08-29 09:30:00", "yyyy-MM-dd HH:mm:ss");
//        Date endTime = DateUtils.parseDate("2017-08-30 09:30:00", "yyyy-MM-dd HH:mm:ss");
//        BoolQueryBuilder queryBuilder = boolQuery()
//                .must(queryStringQuery(qStr).analyzeWildcard(true));
//        // 时间过滤
//        queryBuilder.filter(rangeQuery("@timestamp").from(startTime).to(endTime));
//        //
//        SearchRequestBuilder requestBuilder = getClient().prepareSearch(index)
//                .setTypes(type).setFrom(0).setSize(0).setExplain(true);
//        requestBuilder.setQuery(queryBuilder);
//        System.err.println(requestBuilder.toString());
//        long total = requestBuilder.execute().actionGet().getHits().getTotalHits();
//        System.err.println(total);
//    }
}
