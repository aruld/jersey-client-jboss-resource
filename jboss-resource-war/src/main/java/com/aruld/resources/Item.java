package com.aruld.resources;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    private String username;

    @XmlMimeType(MediaType.APPLICATION_OCTET_STREAM)
    private byte[] image;

    public Item(String username, byte[] image) {
        this.username = username;
        this.image = image;
    }

    public Item() {
    }

    public String getUsername() {
        return username;
    }

    public byte[] getImage() {
        return image;
    }
}
