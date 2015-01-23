package com.near.appusers.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.near.appusers.api.AppUser;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

@Path("/appuser")
@Produces(MediaType.APPLICATION_JSON)
public class AppUserResource {
  static final Logger logger = LoggerFactory.getLogger(AppUserResource.class.getName());
  
  // TODO(zwkero): remove this and change for a AppUsersDAO object.
  public final ArrayList<AppUser> AppUsers;
  
  public AppUserResource(ArrayList<AppUser> AppUsers) {
    this.AppUsers = AppUsers;
  }
  
  /** Get the information from a single AppUser given the ID */
  @GET
  @Timed
  @Path("/{id}")
  public AppUser readAppUser(@PathParam("id") int id) {
    logger.info("Reading AppUser");
    AppUser AppUser = AppUsers.get(id);
    return AppUser;
  }
  
  /** Gets all the AppUsers form the DB */
  @GET
  @Timed
  public ArrayList<AppUser> allAppUsers() {
    logger.info("Getting all AppUsers");
    return AppUsers;
  }
  
  /** Url to request to create a AppUser */
  @POST
  @Timed
  public AppUser createAppUser(@QueryParam("name") Optional<String> name, 
      @QueryParam("age") Optional<Integer> age) {
    logger.info("Creating a AppUser with parameters:\n"
        + " - name: " + name + "\n"
        + " - age: " + age);
    long nextId = AppUsers.size();
    String AppUserName = name.or("");
    int AppUserAge = age.or(0);
    AppUser AppUser = new AppUser(nextId, AppUserName, AppUserAge);
    AppUsers.add(AppUser);
    return AppUser;
  }
  
  /** Updates a AppUser in the DB */
  @PUT
  @Timed
  @Path("/{id}")
  public void updateAppUser(@PathParam("id") int id, @QueryParam("name") String name,
      @QueryParam("age") int age) {
    AppUser AppUser = AppUsers.get(id);
    AppUser.setName(name);
    AppUser.setAge(age);
  }
  
  @DELETE
  @Timed
  @Path("/{id}")
  public void deleteAppUser(@PathParam("id") int id) {
    AppUser AppUser = AppUsers.get(id);
    AppUser.setName("");
    AppUser.setAge(0);
  }
  
}
