package com.course.test.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {

    @Value("${usr}")
    private String userdb;

    @Value("${pass}")
    private String passdb;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:sqlserver://localhost;databaseName=autores;TrustServerCertificate=True;");
        dataSourceBuilder.username(userdb); //UCEM_IRENE //prueba2
        dataSourceBuilder.password(passdb); //1234 //prueba2
        return dataSourceBuilder.build();
    }
}
