package com.kosa.myapp.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//컨피그인지를 지정하기 위한 어노테이션
//파일명과 클래스명은 내마음임 
@Configuration
@MapperScan(basePackages="com.kosa.myapp.board.repository")
public class MyBatisConfig {
	 
	@Autowired
    ApplicationContext applicationContext;

	//hikari 설정하기   
	@Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }
    
	@Bean //객체 생성 
	public SqlSessionFactory makeSqlSessionFactory(DataSource dataSource) throws Exception
	{
		//SqlSessionFactory -  Factory 공장객체를 먼저 만들어서 던진다 
		final SqlSessionFactoryBean factory   = new SqlSessionFactoryBean();
		
		//저객체와 application.properties 파일에 있는  datasource 와 연결 
		factory.setDataSource(dataSource);
		//설정파일과 연동하기(mybatis-config.xml)파일과 연동
		PathMatchingResourcePatternResolver resolver  = new PathMatchingResourcePatternResolver();
		//classpath - src/main/resource
		Resource configLocation = resolver.getResource("classpath:mybatis-config.xml");
		
		factory.setConfigLocation(configLocation);
		return factory.getObject();
	}
	
	@Bean 
	public SqlSessionTemplate makeSqlSession(SqlSessionFactory factory)
	{
		return new SqlSessionTemplate(factory);
	}
}





