package com.hk.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Classname LoginFilter
 * @Description TODO
 * @Date 2019/7/10 12:50
 * @Created by HK
 */
public class LoginFilter implements Filter {
    private String[] doFilter;

    public LoginFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String str = filterConfig.getInitParameter("doFilter");
        doFilter = str.split(";");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String path = req.getServletPath();
        for (int i=0; i<doFilter.length; i++){
            if (path.startsWith(doFilter[i])){
                filterChain.doFilter(req, resp);
                return;
            }
        }
        String username = (String) req.getSession().getAttribute("username");
        if (username==null){
            PrintWriter out = resp.getWriter();
            out.print("<script>window.location.href ='/TeachSystem/login.html';</script>");
            out.flush();
            return;
        }
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
