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
  
  // TODO(zwkero): remove this and change for a real AppUsersDAO object that uses JDBI.
  public final ArrayList<AppUser> appUsersDAO;
  
  public AppUserResource(ArrayList<AppUser> appUsersDAO) {
    this.appUsersDAO = appUsersDAO;
  }
  
  /** Get the information from a single AppUser given the ID */
  @GET
  @Timed
  @Path("/{id}")
  public AppUser readAppUser(@PathParam("id") int id) {
    logger.info("Reading AppUser");
    AppUser AppUser = appUsersDAO.get(id);
    return AppUser;
  }
  
  /** Gets all the AppUsers form the DB */
  @GET
  @Timed
  public ArrayList<AppUser> allAppUsers() {
    logger.info("Getting all AppUsers");
    return appUsersDAO;
  }
  
  /** Url to request to create a AppUser */
  @POST
  @Timed
  public AppUser createAppUser(@QueryParam("name") Optional<String> name) {
    logger.info("Creating a AppUser with parameters:\n"
        + " - name: " + name);
    String nextId = Integer.toString(appUsersDAO.size());
    String appUserName = name.or("");
    AppUser AppUser = new AppUser(nextId, appUserName);
    appUsersDAO.add(AppUser);
    return AppUser;
  }
  
  /** Updates a AppUser in the DB */
  @PUT
  @Timed
  @Path("/{id}")
  public void updateAppUser(@PathParam("id") int id, @QueryParam("name") String name,
      @QueryParam("age") int age) {
    AppUser AppUser = appUsersDAO.get(id);
    AppUser.setName(name);
  }
  
  @DELETE
  @Timed
  @Path("/{id}")
  public void deleteAppUser(@PathParam("id") int id) {
    AppUser AppUser = appUsersDAO.get(id);
    AppUser.setName("");
  }
}
