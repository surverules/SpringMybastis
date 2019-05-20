package com.parth.shon.JDBCTemplate.DAO;

import com.parth.shon.JDBCTemplate.mapper.AddressMapper;
import com.parth.shon.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AddressDAOImpl implements AddressDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean insertAddress(Address address) {
        String sql = "insert into address(aptnumber, aptname, city, state, moveindate) values (?,?,?,?,?)";
        int count = jdbcTemplate.update(sql, new Object[]{address.getAptnumber(), address.getAptname(), address.getCity(),
        address.getState(),address.getMoveinDate()});
        return count > 0;
    }

    public Address getAddress(int aptnumber) {
        String sql = "select * from address where aptnumber = ?";
        Address address = (Address) jdbcTemplate.queryForObject(sql, new Object[]{aptnumber}, new AddressMapper());
        return address;
    }
}
