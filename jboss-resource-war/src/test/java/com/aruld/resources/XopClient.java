package com.aruld.resources;

import org.jboss.resteasy.annotations.providers.multipart.XopWithMultipartRelated;
import org.jboss.resteasy.plugins.providers.multipart.MultipartConstants;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public interface XopClient {

    @POST
    @Consumes(MultipartConstants.MULTIPART_RELATED)
    @Produces(MediaType.APPLICATION_XML)
    @Path("user/{user_id}")
    UserInfo addItem(@XopWithMultipartRelated Item item, @PathParam("user_id") String userId);

}