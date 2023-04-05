package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.Qdb;
import lombok.Getter;

public enum FlowerDaoSingleton {
  Connection;
  @Getter private final FlowerRequestDaoImpl DaoFR;

  {
    DaoFR = (FlowerRequestDaoImpl) Qdb.getInstance().flowerRequestTable;
  }
}
