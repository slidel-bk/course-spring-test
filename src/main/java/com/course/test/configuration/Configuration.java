package com.course.test.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
public class Configuration {

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

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        restTemplate.getMessageConverters().add(converter);
        return  restTemplate;
    }
}
