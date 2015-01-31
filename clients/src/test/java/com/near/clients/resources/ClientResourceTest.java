package com.near.clients.resources;

import static org.junit.Assert.fail;
import java.util.ArrayList;

import com.near.clients.api.Client;
import com.near.clients.resources.ClientResource;

import org.junit.Test;
import com.google.common.base.Optional;

public class ClientResourceTest {
  @Test
  public void testCreateClient() {
    ArrayList<Client> Clients = new ArrayList<Client>();
    String expectedName = "Expected";
    
    Client expectedClient = new Client(0, expectedName);
    ClientResource ClientResource = new ClientResource(Clients);
    
    ClientResource.createClient(Optional.of(expectedName));
    
    Client createdClient = Clients.get(0);
    System.out.print(createdClient.equals(expectedClient));
    
    if(!createdClient.equals(expectedClient)){
      fail("Clients are not equal");
    }
  }
}
