package com.parth.shon.JDBCTemplate.mapper;


import com.parth.shon.models.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Address address = new Address();
        address.setAptname(resultSet.getString("aptname"));
        address.setState(resultSet.getString("state"));
        address.setCity(resultSet.getString("city"));
        address.setMoveinDate(resultSet.getString("moveindate"));
        return address;
     }
}
