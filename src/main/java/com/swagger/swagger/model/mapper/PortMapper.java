package com.swagger.swagger.model.mapper;

import com.swagger.swagger.model.entity.Port;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PortMapper implements RowMapper<Port> {

    @Override
    public Port mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Port port = new Port();
        port.setId(rs.getLong("id"));
        port.setCapacity(rs.getInt("capacity"));
        port.setName(rs.getString("name"));
        return port;
    }
}
