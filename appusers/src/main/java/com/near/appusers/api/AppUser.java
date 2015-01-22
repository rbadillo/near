package com.near.appusers.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Represents a AppUser data object. A AppUser is an example of an object for other Near 
 * abstractions.
 * 
 * @author zwkero
 *
 */
public class AppUser {
  /**
   * Allows mapping from an SQL query to a new AppUser instance.
   * 
   * @author zwkero
   *
   */
  public class Mapper implements ResultSetMapper<AppUser> {
    public AppUser map(int id, ResultSet resultSet, StatementContext ctx) throws SQLException {
      return new AppUser(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getInt("age"));
    }
  }
  
  /** Unique identifier of a AppUser */
  private long id;
  /** The name of the AppUser. It could be repeated among other AppUsers */
  private String name;
  /** The age of the AppUser */
  private int age;
  
  public AppUser(long id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }
  
  @JsonProperty
  public long getId() {
    return id;
  }
  
  @JsonProperty
  public String getName() {
    return name;
  }

  @JsonProperty
  public int getAge() {
    return age;
  }
  
  @JsonProperty
  public void setId(long id) {
    this.id = id;
  }
  
  @JsonProperty
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty
  public void setAge(int age) {
    this.age = age;
  }

  public boolean equals(AppUser compareTo) {
    return getId() == compareTo.getId() && getName().equals(compareTo.getName()) 
        && getAge() == compareTo.getAge();
  }
}
