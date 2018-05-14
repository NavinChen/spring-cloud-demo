package com.springcloud.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Neo
 * @date 2018/5/3
 */
@Component
public class ThrowExceptionFilter extends ZuulFilter {
    
    private static final Logger logger = LoggerFactory.getLogger(ThrowExceptionFilter.class);
    
    @Override
    public String filterType() {
        return "pre";
    }
    
    @Override
    public int filterOrder() {
        return 0;
    }
    
    @Override
    public boolean shouldFilter() {
        return true;
    }
    
    @Override
    public Object run() {
        logger.info("This is a pre filter, it will throw a RuntimeException");
        
        try {
            doSomething();
        } catch (Exception e) {
            // context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            // context.set("error.exception", e);
            throw new ZuulRuntimeException(e);
        }
    
        return null;
    }
    
    private void doSomething() {
        throw new RuntimeException("Exist some errors...");
    }
    
}
