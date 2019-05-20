package com.parth.shon.mybatis.mapper;

import com.parth.shon.models.Address;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressMybatisDaoImpl implements AddressMybatisDao {

    @Autowired
    @Qualifier("sqlSessionFactorynew")
    SqlSessionFactory sqlSessionFactory;

    public int insertRecord(Address address) {

        SqlSession session = sqlSessionFactory.openSession();
        return session.insert("Address.insert", address);
    }

    public Address getRecord(int aptnumber) {
        SqlSession session = sqlSessionFactory.openSession();
        List<Address> list = session.selectList("Address.getById", aptnumber);
        return list.get(0);
    }
}
