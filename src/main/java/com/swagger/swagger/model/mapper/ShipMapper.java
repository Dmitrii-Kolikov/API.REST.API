package com.swagger.swagger.model.mapper;

import com.swagger.swagger.model.entity.Ship;
import com.swagger.swagger.model.enums.ShipStatusType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShipMapper implements RowMapper<Ship> {

    @Override
    public Ship mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Ship ship = new Ship();
        ship.setId(rs.getLong("id"));
        ship.setName(rs.getString("name"));
        ship.setStatus(ShipStatusType.getStatusType(rs.getString("status")));
        final Long portId = rs.getLong("port_id");
        if (!rs.wasNull()) {
            ship.setPortId(portId);
        }
        return ship;
    }
}
