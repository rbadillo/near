package com.near.appusers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.near.appusers.api.AppUser;

/**
 * Implements ResultSetMapper interface to allow JDBI queries to be mapped to a AppUser 
 * representation.
 * 
 * @author zwkero
 *
 */
public class AppUserMapper implements ResultSetMapper<AppUser> {
  /** Allows mapping from an SQL query to a new AppUser instance. */
  public AppUser map(int id, ResultSet resultSet, StatementContext ctx) throws SQLException {
    return new AppUser(resultSet.getString("id"), resultSet.getString("name"));
  }
}
