package com.near.appusers.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * This Class to test general Health of the server.. 
 * 
 * @author zwkero
 *
 */
public class AppUserHealthCheck extends HealthCheck {
  @Override
  protected Result check() throws Exception {  
    return Result.healthy();
  }
}
