package com.cd.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

public class HeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain  chain) throws IOException, ServletException {
        System.out.println("he filter 您已经入filter过滤器，您的请求正常，请继续遵守规则...");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
