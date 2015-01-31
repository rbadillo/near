package com.near.clients.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * This Class to test general Health of the server.. 
 * 
 * @author rbadillo
 *
 */
public class ClientHealthCheck extends HealthCheck {
  @Override
  protected Result check() throws Exception {  
    return Result.healthy();
  }
}
