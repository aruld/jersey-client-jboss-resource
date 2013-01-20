package com.aruld.resources;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.multipart.BodyPart;
import com.sun.jersey.multipart.MultiPart;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

public class JerseyClient {

    public static void main(String[] args) throws Exception {
        MediaType mediaType = new MediaType("multipart", "related");

        Client client = Client.create();
        client.addFilter(new LoggingFilter());
        WebResource resource = client.resource("http://localhost:8080/jboss-resource-war/xop");

        Item xop = new Item("aruld", "Hello Xop World!".getBytes("UTF-8"));
        MultiPart multiPart = new MultiPart(mediaType);
        BodyPart bp = new BodyPart(xop, MediaType.APPLICATION_XML_TYPE);
        multiPart.bodyPart(bp);

        UriBuilder uriBuilder = resource.getUriBuilder().path("user").path("aruld");
        UserInfo userInfo = resource.uri(uriBuilder.build()).type(mediaType).post(UserInfo.class, multiPart);
        System.out.println(userInfo.getUid());
    }
}
