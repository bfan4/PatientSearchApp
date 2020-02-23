package com.qpidhealth.qpid.search.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bo Fan on 2/22/2020.
 */

public class Patient {
    private Long id;    
    private String name;
    private List<String> documents; // id ::: date ::: contents
    
    public Patient() {
        documents = new ArrayList<String>();
    }
    
    public static Patient create() {
        return new Patient();
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
    
    public List<String> getDocuments() {
        return documents;
    }
    
    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }
}
