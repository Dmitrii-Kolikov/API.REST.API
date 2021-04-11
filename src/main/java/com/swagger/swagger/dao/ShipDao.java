package com.swagger.swagger.dao;

import com.swagger.swagger.model.entity.Ship;
import com.swagger.swagger.model.enums.ShipStatusType;

import java.util.List;

public interface ShipDao {

    List<Ship> selectAllShips();
    List<Ship> selectShipsByStatus(ShipStatusType status);

    int selectShipsCountByPortId(long id);

    Ship selectShipById(long id);
    void insertShip(Ship ship);
    void deleteShipById(long id);

    void updateShipStatusById(long id, ShipStatusType status);
    void updateShipPortIdById(long id, Long portId);
}
