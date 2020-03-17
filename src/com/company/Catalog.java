package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    //…
    public void add(Document doc) {
        documents.add(doc);
    }
    public Document findById(String id) {
        //…
        this.name=id;
        return  documents;
    }

    public String getPath() {
        return path;
    }
}