package com.aruld.resources;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserInfo {

    private String uid;

    public UserInfo(String uid) {
        this.uid = uid;
    }

    public UserInfo() {
    }

    public String getUid() {
        return uid;
    }
}
