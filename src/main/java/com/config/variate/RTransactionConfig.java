package com.config.variate;

/**
 * 配置事务，
 * 如果有多个数据库，就需要配置多个事务
 * 具体名称和sping-data-config.xml 配置文件里面找到
 * org.springframework.jdbc.datasource.DataSourceTransactionManager的ID
 * @author luoyang
 *
 */
public class RTransactionConfig {

	/**
	 * 补登活动红包的数据库事务
	 */
	public static final String Transaction_AcT = "smkAppTransaction";
}
