package com.aruld.resources;

import org.jboss.resteasy.client.ClientRequestFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import java.net.URI;

public class ResteasyClient {
    public static void main(String[] args) throws Exception {

        RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
        Item item = new Item("aruld", "Hello Xop World!".getBytes("UTF-8"));
        ClientRequestFactory clientRequestFactory = new ClientRequestFactory();
        clientRequestFactory.setBase(new URI("http://localhost:8080/jboss-resource-war/xop"));
        XopClient resource = clientRequestFactory.createProxy(XopClient.class);
        UserInfo bean = resource.addItem(item, "aruld");
        System.out.println(bean.getUid());
    }
}
