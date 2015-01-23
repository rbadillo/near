package com.near.appusers.api;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Represents a AppUser data object. AppUsers refers to the users of Near Mobile Application.
 * Data in this representation is the same as the one provided by Facebook, which is:
 * <ul>
 * <li>id
 * <li>name
 * <li>first_name
 * <li>last_name
 * <li>link
 * <li>gender
 * <li>locale
 * <li>timezone
 * <li>updated_time
 * <li>verified
 * <li>user_friends
 * <li>email
 * </ul> 
 * 
 * <p>
 * As this data is stored also by FB, we will only keep id, and name.
 * More information about this fields and their types can be found here:
 * https://developers.facebook.com/docs/graph-api/reference/v2.2/user
 * 
 * @author zwkero
 *
 */
public class AppUser {  
  /** Unique identifier of the AppUser */
  private String id;
  /** The name of the AppUser. It could be repeated among other AppUsers */
  private String name;
  
  public AppUser(String id, String name) {
    this.id = id;
    this.name = name;
  }
  
  @JsonProperty
  public String getId() {
    return id;
  }
  
  @JsonProperty
  public String getName() {
    return name;
  }
  
  @JsonProperty
  public void setId(String id) {
    this.id = id;
  }
  
  @JsonProperty
  public void setName(String name) {
    this.name = name;
  }

  public boolean equals(AppUser compareTo) {
    return getId() == compareTo.getId() && getName().equals(compareTo.getName());
  }
}
