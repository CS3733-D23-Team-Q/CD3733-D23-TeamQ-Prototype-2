package edu.wpi.cs3733.D23.teamQ.db.impl;

import java.sql.SQLException;
import lombok.Getter;

public enum ConferenceDaoSingleton {
  Connection;
  @Getter private final ConferenceRequestDaoImpl DaoCCR;

  {
    try {
      DaoCCR = new ConferenceRequestDaoImpl();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
