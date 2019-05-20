package com.parth.shon.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

@Component
public class SqlSessionFactoryForMybatis {

    @Autowired
    DataSource dataSource;

    SqlSessionFactory sqlSessionFactory;

    @Bean("sqlSessionFactoryold")
    public SqlSessionFactory createSqlSessionfactory() throws Exception{

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:mybatis/mybatis-config.xml");

        sessionFactoryBean.setMapperLocations(resources);
        return sessionFactoryBean.getObject();

    }


    @Bean("sqlSessionFactorynew")
    public SqlSessionFactory getSqlSessionFactory(){

            String resource = "mybatis/mybatis-config.xml";
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sqlSessionFactory;

    }


}
