package edu.wpi.cs3733.D23.teamQ.db.impl;
import lombok.Getter;
public enum FlowerDaoSingleton {
    Connection;
    @Getter
    private final FlowerRequestDaoImpl DoaFR = new FlowerRequestDaoImpl();
}
