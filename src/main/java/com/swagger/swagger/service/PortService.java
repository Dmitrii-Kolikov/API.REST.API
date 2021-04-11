package com.swagger.swagger.service;

import com.swagger.swagger.model.entity.Port;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PortService {

    ResponseEntity<List<Port>> readAllPorts();
    ResponseEntity<String> readPortCapacityInfo(long id);
}
