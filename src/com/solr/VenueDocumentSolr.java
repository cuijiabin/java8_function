package com.solr;

import org.apache.solr.client.solrj.beans.Field;
import org.apache.solr.common.SolrInputDocument;

public class VenueDocumentSolr extends SolrInputDocument {

    @Field
    private Long id;

    @Field
    private String name;

    @Field
    private Integer sex;

    public VenueDocumentSolr() {
    }

    public VenueDocumentSolr(Long id, String name, Integer sex) {

        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
