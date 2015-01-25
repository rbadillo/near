package com.near.appusers.resources;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import com.near.appusers.api.AppUser;
import com.google.common.base.Optional;

import org.junit.Test;

public class AppUserResourceTest {
  @Test
  public void testCreateAppUser() {
    ArrayList<AppUser> AppUsers = new ArrayList<AppUser>();
    String expectedName = "Expected";
    AppUser expectedAppUser = new AppUser("0", expectedName);
    AppUserResource AppUserResource = new AppUserResource(AppUsers);
    AppUserResource.createAppUser(Optional.of(expectedName));
    
    AppUser createdAppUser = AppUsers.get(0);
    System.out.print(createdAppUser.equals(expectedAppUser));
    
    if(!createdAppUser.equals(expectedAppUser)){
      fail("AppUsers are not equal");
    }
  }
}
