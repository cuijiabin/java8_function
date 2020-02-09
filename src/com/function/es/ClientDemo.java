package com.function.es;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import static org.elasticsearch.index.query.QueryBuilders.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientDemo {

    public TransportClient getClient() throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("10.5.97.40"), 9200))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("10.5.96.195"), 9200))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("10.5.96.200"), 9300));

        return client;
    }

    public static void main(String[] args) throws UnknownHostException {

        ClientDemo clientDemo = new ClientDemo();
        TransportClient client = clientDemo.getClient();

        SearchResponse response = client.prepareSearch().get();
        System.out.println(response);
//        QueryBuilder qb = termQuery("multi", "test");
//
//        SearchResponse scrollResp = client.prepareSearch("test")
//                .addSort(FieldSortBuilder.DOC_FIELD_NAME, SortOrder.ASC)
//                .setScroll(new TimeValue(60000))
//                .setQuery(qb)
//                .setSize(100).get(); //max of 100 hits will be returned for each scroll
//        //Scroll until no hits are returned
//        do {
//            for (SearchHit hit : scrollResp.getHits().getHits()) {
//                //Handle the hit...
//            }
//
//            scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
//        } while (scrollResp.getHits().getHits().length != 0); //
    }
}
