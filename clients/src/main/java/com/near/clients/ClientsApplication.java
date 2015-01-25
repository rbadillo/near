package com.near.clients;

import java.util.ArrayList;
import com.near.clients.api.Client;
import com.near.clients.health.ClientHealthCheck;
import com.near.clients.resources.ClientResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ClientsApplication extends Application<ClientsConfiguration> {
  
  public static void main(String[] args) throws Exception {
    new ClientsApplication().run(args);
  }

  @Override
  public void initialize(Bootstrap<ClientsConfiguration> bootstrap) {
    // nothing to do yet
  }

    
  @Override
  public void run(ClientsConfiguration configuration, Environment environment) {
    environment.jersey().register(new ClientResource(new ArrayList<Client>()));
    environment.healthChecks().register("ClientsInArrayList", new ClientHealthCheck());
  }
}
