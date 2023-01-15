package com.bruce.springboot.lab23.springmvc.config;

import com.bruce.springboot.lab23.springmvc.core.interceptor.FirstInterceptor;
import com.bruce.springboot.lab23.springmvc.core.interceptor.SecondInterceptor;
import com.bruce.springboot.lab23.springmvc.core.interceptor.ThirdInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * @author Bruce Wong
 * @date 2022年12月23日 17:09
 */
@Configuration
public class SpringMVCConfiguration implements WebMvcConfigurer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public FirstInterceptor firstInterceptor () {
        return new FirstInterceptor();
    }

    @Bean
    public SecondInterceptor secondInterceptor () {
        return new SecondInterceptor();
    }

    @Bean
    public ThirdInterceptor thirdInterceptor () {
        return new ThirdInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.firstInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(this.secondInterceptor()).addPathPatterns("/users/current_user");
        registry.addInterceptor(this.thirdInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public ServletRegistrationBean testServlet01() {
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>(
                new HttpServlet() {
                    @Override
                    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                        logger.info("[doGet][uri: {}]", req.getRequestURI());
                    }
                }
        );

        servletServletRegistrationBean.setUrlMappings(Collections.singleton("/test/01"));
        return servletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean testFilter01() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>(new Filter() {

            @Override
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                logger.info("[doFilter]");
                filterChain.doFilter(servletRequest, servletResponse);
            }

        });
        filterRegistrationBean.setUrlPatterns(Collections.singleton("/test/*"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<?> testListener01() {
        return new ServletListenerRegistrationBean<>(new ServletContextListener() {

            @Override
            public void contextInitialized(ServletContextEvent sce) {
                logger.info("[contextInitialized]");
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
            }

        });
    }
}
