package uk.ac.ebi.app.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CorsFilter extends OncePerRequestFilter
{
    private boolean enableCORS = true;
    private String frontendUrl = "http://localhost:4200";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        if (enableCORS)
        {
            response.setHeader("Access-Control-Allow-Origin", frontendUrl);
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, content-type");
            response.addHeader("Access-Control-Expose-Headers", "Authorization, content-type");

            if ("OPTIONS".equals(request.getMethod()))
            {
                response.setStatus(HttpServletResponse.SC_OK);
            }
            else
            {
                filterChain.doFilter(request, response);
            }
        }
    }
}