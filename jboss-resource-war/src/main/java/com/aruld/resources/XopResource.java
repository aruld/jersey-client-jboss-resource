package com.aruld.resources;

import org.jboss.resteasy.annotations.providers.multipart.XopWithMultipartRelated;
import org.jboss.resteasy.plugins.providers.multipart.MultipartConstants;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/")
public class XopResource {

    @POST
    @Consumes(MultipartConstants.MULTIPART_RELATED)
    @Produces(MediaType.APPLICATION_XML)
    @Path("user/{user_id}")
    public UserInfo addItem(@XopWithMultipartRelated Item item, @PathParam("user_id") String userId) {
        System.out.println("Received request from # " + userId);
        // process XOP
        System.out.println("XOP # " + new String(item.getImage()));
        return new UserInfo(UUID.randomUUID().toString());
    }

}
