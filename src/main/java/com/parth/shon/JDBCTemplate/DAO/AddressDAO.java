package com.parth.shon.JDBCTemplate.DAO;

import com.parth.shon.models.Address;

public interface AddressDAO {

    public boolean insertAddress(Address address);

    public Address getAddress(int aptnumber);
}
