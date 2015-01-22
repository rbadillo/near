package com.near.appusers;

import java.util.ArrayList;

import com.near.appusers.api.AppUser;
import com.near.appusers.health.AppUserHealthCheck;
import com.near.appusers.resources.AppUserResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class AppUsersApplication extends Application<AppUsersConfiguration> {
	public static void main(String[] args) throws Exception {
        new AppUsersApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<AppUsersConfiguration> bootstrap) {
        // nothing to do yet
    }

    
    @Override
    public void run(AppUsersConfiguration configuration, Environment environment) {
      environment.jersey().register(new AppUserResource(new ArrayList<AppUser>()));
      environment.healthChecks().register("AppUsersInArrayList", new AppUserHealthCheck());
    }
}
