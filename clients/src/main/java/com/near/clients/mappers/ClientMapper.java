package com.near.clients.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.near.clients.api.Client;

/**
 * Implements ResultSetMapper interface to allow JDBI queries to be mapped to a AppUser 
 * representation.
 * 
 * @author rbadillo
 *
 */
public class ClientMapper implements ResultSetMapper<Client> {
  /** Allows mapping from an SQL query to a new AppUser instance. */
  public Client map(int id, ResultSet resultSet, StatementContext ctx) throws SQLException {
    return new Client(resultSet.getLong("id"), resultSet.getString("name"));
  }
}