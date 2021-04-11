package com.swagger.swagger.dao.impl;

import com.swagger.swagger.dao.BaseDao;
import com.swagger.swagger.dao.PortDao;
import com.swagger.swagger.model.mapper.PortMapper;
import com.swagger.swagger.model.entity.Port;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PortDaoImpl extends BaseDao implements PortDao {

    @Override
    public List<Port> selectAllPorts() {
        final String sql = "SELECT id, name, capacity FROM ports";
        return jdbcTemplate.query(sql, new PortMapper());
    }

    @Override
    public Port selectPortById(long id) {
        final String sql = "SELECT id, name, capacity FROM ports WHERE id=" + id;
        try {
            return jdbcTemplate.queryForObject(sql, new PortMapper());
        } catch (DataAccessException ex) {
            return null;
        }
    }
}
