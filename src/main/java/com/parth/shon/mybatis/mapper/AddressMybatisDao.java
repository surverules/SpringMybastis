package com.parth.shon.mybatis.mapper;

import com.parth.shon.models.Address;
import org.springframework.stereotype.Component;

@Component
public interface AddressMybatisDao {

    public int insertRecord(Address address);

    public Address getRecord(int aptnumber);


}
