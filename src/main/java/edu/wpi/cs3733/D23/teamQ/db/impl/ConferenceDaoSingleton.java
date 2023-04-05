package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.Qdb;
import lombok.Getter;

public enum ConferenceDaoSingleton {
  Connection;
  @Getter private final ConferenceRequestDaoImpl DaoCCR;
  {
    DaoCCR = (ConferenceRequestDaoImpl) Qdb.getInstance().conferenceRequestTable;
  }
}
