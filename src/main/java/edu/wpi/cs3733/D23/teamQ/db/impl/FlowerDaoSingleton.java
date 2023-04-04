package edu.wpi.cs3733.D23.teamQ.db.impl;

import java.sql.SQLException;
import lombok.Getter;

public enum FlowerDaoSingleton {
  Connection;
  @Getter private final FlowerRequestDaoImpl DaoFR;

  {
    try {
      DaoFR = new FlowerRequestDaoImpl();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
