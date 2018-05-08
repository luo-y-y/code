package com.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.App;
import com.cat.common.listener.RSystemConfig;


/*
 * 程序启动后，立即执行的方法
 */
@Component
public class ApplicationInit implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		RSystemConfig.loadEnvXml(App.env_home);
	}

}
