package filter.interceptor.listener.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import filter.interceptor.listener.component.MyFilter;
import filter.interceptor.listener.component.MyInterceptor;
import filter.interceptor.listener.component.MyListener;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**", "/login",
				"/online");
	}

	@Bean
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new MyFilter());
		frb.addUrlPatterns("/*");
		return frb;
	}

	@Bean
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServletListenerRegistrationBean listenerRegistrationBean() {
		ServletListenerRegistrationBean slrb = new ServletListenerRegistrationBean();
		slrb.setListener(new MyListener());
		return slrb;
	}
}
