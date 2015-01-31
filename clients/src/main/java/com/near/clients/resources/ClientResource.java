package com.near.clients.resources;

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
import com.near.clients.api.Client;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {
  static final Logger logger = LoggerFactory.getLogger(ClientResource.class.getName());
  
  // TODO(rbadillo): remove this and change for a ClientDAO object.
  public final ArrayList<Client> Clients;
  
  public ClientResource(ArrayList<Client> Clients) {
    this.Clients = Clients;
  }
  
  /** Get the information from a single Client given the ID */
  @GET
  @Timed
  @Path("/{id}")
  public Client readClient(@PathParam("id") int id) {
    logger.info("Reading Client");
    Client client = Clients.get(id);
    return client;
  }
  
  /** Gets all the AppUsers form the DB */
  @GET
  @Timed
  public ArrayList<Client> allClients() {
    logger.info("Getting all Clients");
    return Clients;
  }
  
  /** Url to request to create a Client */
  @POST
  @Timed
  public Client createClient(@QueryParam("name") Optional<String> name) {
    logger.info("Creating a Client with parameters:\n"
        + " - name: " + name);
    long nextId = Clients.size();
    String ClientName = name.or("");
    Client client = new Client(nextId, ClientName);
    Clients.add(client);
    return client;
  }
  
  /** Updates a Client in the DB */
  @PUT
  @Timed
  @Path("/{id}")
  public void updateClient(@PathParam("id") int id, @QueryParam("name") String name,
      @QueryParam("age") int age) {
    Client client = Clients.get(id);
    client.setName(name);
  }
  
  @DELETE
  @Timed
  @Path("/{id}")
  public void deleteClient(@PathParam("id") int id) {
    Client client = Clients.get(id);
    client.setName("");
  }
}
