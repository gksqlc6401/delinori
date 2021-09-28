package com.noriteo.delinori.common.config;

import com.noriteo.delinori.board.config.BoardRootConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.ArrayList;


@Configuration
@Import(BoardRootConfig.class)
@EnableTransactionManagement
//@ComponentScan(basePackages = {"com.noriteo.delinori.board.service"})
//@MapperScan(basePackages = "com.noriteo.delinori.board.mapper")
public class RootConfig {

    @Bean //mybatis 연결
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean.getObject();
    }
    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");

        config.setJdbcUrl("jdbc:log4jdbc:mysql://106.241.252.51:1524/delinori");
        config.setUsername("delinori");
        config.setPassword("delinoripw");
        config.setMaximumPoolSize(3);
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Bean
    public TransactionManager transactionManager() {

        return new DataSourceTransactionManager(dataSource());
    }


}
