package com.parth.shon.Context;

import com.parth.shon.JDBCTemplate.DAO.AddressDAOImpl;
import com.parth.shon.config.JDBCTemplateConfig;
import com.parth.shon.config.MySQLDataSource;
import com.parth.shon.config.SqlSessionFactoryForMybatis;
import com.parth.shon.models.Address;
import com.parth.shon.mybatis.mapper.AddressMybatisDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MySQLDataSource.class);
        context.register(JDBCTemplateConfig.class);
        context.register(SqlSessionFactoryForMybatis.class);
        context.refresh();

        Address address = context.getBean(Address.class);
        address.setAptnumber(4444);
        address.setAptname("Players");
        address.setCity("Bhongawali");
        address.setState("Maharashtra");
        address.setMoveinDate("1990-01-02");

        //JDBCTemplate Testing Code
        //AddressDAOImpl addressDAO = context.getBean(AddressDAOImpl.class);
        //boolean result = addressDAO.insertAddress(address);
        //System.out.println("Result of Query is: " + result);
        //System.out.println(addressDAO.getAddress(2222));

        //Mybatis Testing Code
        AddressMybatisDaoImpl addressMybatisDao = context.getBean(AddressMybatisDaoImpl.class);
        int count = addressMybatisDao.insertRecord(address);
        System.out.println(" Mybatis Insert record count: " + count);
        System.out.println(addressMybatisDao.getRecord(4444));

    }
}
