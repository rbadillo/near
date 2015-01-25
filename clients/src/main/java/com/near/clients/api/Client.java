package com.near.clients.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Represents a Client data object. A Client is an example of an object for other Near 
 * abstractions.
 * 
 * @author rbadillo
 *
 */
public class Client {
  /**
   * Allows mapping from an SQL query to a new Client instance.
   * 
   * @author rbadillo
   *
   */
  
  /** Unique identifier of a Client */
  private long id;
  /** The name of the Client. It has to be unique */
  private String name;

  
  public Client(long id, String name) {
    this.id = id;
    this.name = name;
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
  public void setId(long id) {
    this.id = id;
  }
  
  @JsonProperty
  public void setName(String name) {
    this.name = name;
  }


  public boolean equals(Client compareTo) {
    return getId() == compareTo.getId() && getName().equals(compareTo.getName()); 
  }
}
