package com.parth.shon.config;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.parth.shon")
@PropertySource("classpath:application.properties")
public class MySQLDataSource {

    @Value("${mysql.password}")
    private String password;

    @Value("${mysql.user}")
    private String login;

    @Value("${mysql.url}")
    private String url;

    @Value("${mysql.driver}")
    private String driver;


    @Bean("datasource")
    public DataSource buildDataSource() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e){
            System.out.println("error in loading database drives");
        }
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setURL(url);
        dataSource.setPassword(password);
        dataSource.setUser(login);
        return dataSource;
    }

}
