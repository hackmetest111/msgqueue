package com.dbs.lcsa.messagequeue.Model;




public class QueueDetails {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;

    public QueueDetails(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
