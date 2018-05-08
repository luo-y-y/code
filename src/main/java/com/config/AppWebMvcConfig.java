package com.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.config.interceptor.AppExtInterceptor;
import com.config.interceptor.WebDoInterceptor;


/**
 * MVC拦截器
 * @author luoyang
 *
 */
@Component
public class AppWebMvcConfig extends WebMvcConfigurerAdapter {


    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    
	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureContentNegotiation(configurer);
		configurer.mediaType("ext", MediaType.APPLICATION_JSON);// 设置ext放回类型为json
		configurer.mediaType("in", MediaType.APPLICATION_JSON);// 设置ext放回类型为json
		configurer.favorPathExtension(false);
	}

	/**
	 * 设置是否允许跨域
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		super.addCorsMappings(registry);
		registry.addMapping("/**");
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		super.addFormatters(registry);
		// registry.addFormatter(arg0);新增格式化
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AppExtInterceptor()).addPathPatterns("/**/*.ext");
		registry.addInterceptor(new WebDoInterceptor()).addPathPatterns("/**/*.do");
		super.addInterceptors(registry);
	}

}
