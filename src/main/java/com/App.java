package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cat.common.listener.REnvContent;
import com.cat.common.listener.RSystemConfig;

/**
 * 启动类注解 如果其他代码不在这个类的子目录里面需要加
 * 
 * @ComponentScan(basePackages = { "com.cat.**", "com.smk.**","com.boot.**"})
 * @ServletComponentScan
 * @EnableScheduling
 * @EnableAsync
 * @author luoyang
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@Configuration
@EnableAsync
@EnableScheduling
public class App extends SpringBootServletInitializer {

	/**
	 * 获取系统的环境变量
	 */
	public static final String env_home="CODE_HOME";
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		//自定义配置，必须先初始化环境变量的位置
		RSystemConfig.init(env_home);
		builder.sources(App.class);
		Properties p = new Properties();
		String path = RSystemConfig.Home_Path + REnvContent.Application;
		try {
			p.load(new FileInputStream(new File(path)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		builder.application().setDefaultProperties(p);
		return builder;
	}

	public static void main(String[] args) throws IOException {
		/*
		 * Properties p = new Properties(); String path =
		 * RSystemConfig.Home_Path + REnvContent.Application; p.load(new
		 * FileInputStream(new File(path))); SpringApplication app = new
		 * SpringApplication(App.class); app.setDefaultProperties(p);
		 * app.run(args);
		 */
		SpringApplication.run(App.class, args);
	}

}
