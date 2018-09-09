/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.config;

import com.jeesite.common.io.PropertiesUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * JeeSite Web
 * @author ThinkGem
 * @version 2018-1-8
 */
//@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.jeesite.modules"})
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		SpringApplication app = new SpringApplication(Application.class);
//		app.setDefaultProperties(PropertiesUtils.getInstance().getProperties());
//		app.run(args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		this.setRegisterErrorPageFilter(false); // 错误页面有容器来处理，而不是SpringBoot
		builder.properties(PropertiesUtils.getInstance().getProperties());
		return builder.sources(Application.class);
	}
	
}