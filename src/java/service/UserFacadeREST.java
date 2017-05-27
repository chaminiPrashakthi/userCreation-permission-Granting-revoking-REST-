/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Presentation.Wrapper;
import entity.User;
import entity.UserPK;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Chamini
 */
@Stateless
@Path("entity.user")
public class UserFacadeREST extends AbstractFacade<User> {
    @PersistenceContext(unitName = "permission_finalPU")
    private EntityManager em;

    private UserPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;host=hostValue;user=userValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entity.UserPK key = new entity.UserPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> host = map.get("host");
        if (host != null && !host.isEmpty()) {
            key.setHost(host.get(0));
        }
        java.util.List<String> user = map.get("user");
        if (user != null && !user.isEmpty()) {
            key.setUser(user.get(0));
        }
        return key;
    }

    public UserFacadeREST() {
        super(User.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(User entity) {
        super.create(entity);
    }
    
    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void user(@FormParam("username")String user,@FormParam("password")String pass,@FormParam("S")String s,@FormParam("I")String i,@FormParam("U")String u,@FormParam("D")String d)throws SQLException, ClassNotFoundException{
        
        Wrapper object1 = new Wrapper();
        object1.queue(user, pass);
        object1.check1(user, s, i, d, u);
        
    }
    
    @POST
    @Path("/window")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void wind(@QueryParam("window") String window){
        Wrapper object2 = new Wrapper();
        object2.window(window);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, User entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entity.UserPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public User find(@PathParam("id") PathSegment id) {
        entity.UserPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<User> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
