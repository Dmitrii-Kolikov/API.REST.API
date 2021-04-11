package com.swagger.swagger.dao;

import com.swagger.swagger.model.entity.Port;

import java.util.List;

public interface PortDao {

    List<Port> selectAllPorts();
    Port selectPortById(long id);
}
