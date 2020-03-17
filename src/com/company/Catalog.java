package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    public Catalog(String java_resources, String s) {

        this.setName(java_resources);
        this.setPath(s);
    }
    //functia de add a documentelor
    public void add(Document doc) {
        documents.add(doc);
    }
    //va cauta dupa ID
    public Document findById(String id) {
        return documents.stream()
                .filter(d->d.getId().equals(id)).findFirst().orElse(null);
    }
    //setter si getters
    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}