package edu.wpi.cs3733.D23.teamQ.db.impl;

import lombok.Getter;

public enum ConferenceDaoSingleton {
  Connection;
  @Getter private final ConferenceRequestDaoImpl DaoCCR;

  {
    DaoCCR = new ConferenceRequestDaoImpl();
  }
}
