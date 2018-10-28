package com.cd.springboot.config;

import com.cd.springboot.filter.HeFilter;
import com.cd.springboot.servlet.HeServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * springboot没有xml，@Configuration表示一个spring的XML配置文件
 * 相当于applicationContext.xml
 */

@Configuration
public class ServletConfig {

    /**
     * <bean id="heServletRegistrationBean" class="org.springframework.boot.web.servlet.ServletRegistrationBean;">
     * </bean>
     * @return
     */
    @Bean
    public ServletRegistrationBean heServletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new HeServlet(), "/servlet/heServlet");
        return registration;
    }

    /**
     * <bean id="heFilterRegistration" class="org.springframework.boot.web.servlet.FilterRegistrationBean;">
     * </bean>
     * @return
     */
    @Bean
    public FilterRegistrationBean heFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new HeFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    /**
     * 等价于web.xml配置CharacterEncodingFilter
     * 只有当spring.http.encoding.enable=false时，配置才能生效
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        
        registrationBean.setFilter(characterEncodingFilter);
        registrationBean.addUrlPatterns("/*");
        
        return registrationBean;
    }
}
