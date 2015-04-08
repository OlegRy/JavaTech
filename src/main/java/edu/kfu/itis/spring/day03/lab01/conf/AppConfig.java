package edu.kfu.itis.spring.day03.lab01.conf;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan("edu.kfu.itis.spring.day03.lab01*")
public class AppConfig {

    @Value("${url}")
    private String url;

    @Value("${username}")
    private String user;

    @Value("${password}")
    private String password;

    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setUrl(url);
        jdbcDataSource.setUser(user);
        jdbcDataSource.setPassword(password);
        return  jdbcDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public JdbcTemplate template() throws ClassNotFoundException {
        return new JdbcTemplate(dataSource());
    }
}
