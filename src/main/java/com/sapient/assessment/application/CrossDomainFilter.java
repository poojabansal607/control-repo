package com.sapient.assessment.application;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CrossDomainFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

         HttpServletResponse res = (HttpServletResponse) response;

         res.setHeader("Access-Control-Allow-Origin", "*");
         res.setHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
         res.setHeader("Access-Control-Allow-Credentials", "true");
         res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
         res.setHeader("Access-Control-Max-Age", "1209600");

         chain.doFilter(request, response);
     }

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
