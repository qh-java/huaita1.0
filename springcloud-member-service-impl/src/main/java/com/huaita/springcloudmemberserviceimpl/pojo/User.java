package com.huaita.springcloudmemberserviceimpl.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1749243243491717954L;
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
