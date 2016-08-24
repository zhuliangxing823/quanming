package com.ycmedia.constants;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: MySQLConfig
 * @Description: (配置MySQL数据源)
 * @author Zhaoxu
 * @date 2016年5月13日 下午5:04:34
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.ycmedia.dao", sqlSessionTemplateRef = "mysqlSqlSessionTemplate")
public class MySQLConfig {

	@Primary
	@Bean(name = "mysqlDS")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * @Title: sqlSessionFactory
	 * @Description: (配置SqlSessionFactory)
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "mysqlSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(
			@Qualifier("mysqlDS") DataSource ds) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(ds);
		sessionFactory
				.setMapperLocations(new PathMatchingResourcePatternResolver()
						.getResources("classpath:/mapper/*.xml"));
		return sessionFactory.getObject();
	}

	/**
	 * @Title: sqlSessionTemplate
	 * @Description: (配置SqlSessionTemplate)
	 * @param sqlSessionFactory
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "mysqlSqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(
			@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
			throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
