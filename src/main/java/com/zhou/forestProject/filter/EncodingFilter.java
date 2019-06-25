package com.zhou.forestProject.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    String encoding="UTF-8";
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
         String encoding  =config.getInitParameter("encoding");
    }

}
