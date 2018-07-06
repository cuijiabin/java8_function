package com.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.LBHttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SolrDemo {

    private static SolrClient lbHttpSolrClient = new LBHttpSolrClient.Builder().withBaseSolrUrls("http://172.16.96.119:8983/solr/popsolr/", "http://172.16.96.119:7574/solr/popsolr/").build();


    @Test
    public void addSolrInputDocument() {

        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "552199");
        document.addField("name", "00005lbHttpSolrClient");
        document.addField("price", "49.99");

        try {
            lbHttpSolrClient.add(document);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addSolrInputDocumentList() {

        List<SolrInputDocument> list = new ArrayList<>();

        SolrInputDocument d1 = new SolrInputDocument();
        d1.addField("id", "552199");
        d1.addField("name", "00005lbHttpSolrClient");
        d1.addField("price", "49.99");

        SolrInputDocument d2 = new SolrInputDocument();
        d2.addField("id", "552101");
        d2.addField("name", "00005lbHttpSolrClient");
        d2.addField("price", "49.99");

        list.add(d2);

        try {
            lbHttpSolrClient.add(list);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addBean() {
        VenueDocumentSolr p = new VenueDocumentSolr(2L, "person2", 2);
        try {
            lbHttpSolrClient.addBean(p);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delByIds() {
        try {
            lbHttpSolrClient.deleteById(Arrays.asList("552199", "2"));
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO deleteByQuery(String query)

    @Test
    public void getByIds() {
        try {
            SolrDocument document = lbHttpSolrClient.getById("400989a9-099c-42a1-b7bd-a54309aff36e");

            System.out.println(document);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQuery() {

        Map<String, String> p = new HashMap<String, String>();
        p.put("q", "content:佣金 or title:蜜芽");
        p.put("fl", "title");

        SolrParams param = new MapSolrParams(p);
        try {
            QueryResponse response = lbHttpSolrClient.query(param);

            System.out.println(response);
            SolrDocumentList list = response.getResults();

            if(list.getNumFound() <1 ){

                return ;
            }
            System.out.println(response.getFacetDate("title"));

            List<String> titleList = list.stream().map(sd -> sd.get("title").toString()).map(s -> s.substring(1,s.length()-1)).collect(Collectors.toList());

            System.out.println(titleList);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
