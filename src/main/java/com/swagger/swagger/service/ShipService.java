package com.swagger.swagger.service;

import com.swagger.swagger.model.entity.Ship;
import com.swagger.swagger.model.entity.ShipStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShipService {

    ResponseEntity<List<Ship>> readAllShips(String status);
    ResponseEntity<String> createShip(Ship ship);
    ResponseEntity<String> deleteShip(long id);
    ResponseEntity<ShipStatus> readShipStatus(long id);
    ResponseEntity<ShipStatus> updateShipStatus(long id, Long portId, ShipStatus shipStatus);
}
