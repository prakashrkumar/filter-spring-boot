package in.prakash.filter.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

//@Component
public class ReponseBodyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(httpServletResponse);
        filterChain.doFilter(httpServletRequest, wrappedResponse);

        if (wrappedResponse.getStatus() < HttpServletResponse.SC_OK
                || wrappedResponse.getStatus() >= HttpServletResponse.SC_MULTIPLE_CHOICES) {
            wrappedResponse.copyBodyToResponse();
            return;
        }

        Charset charset = Charset.forName(wrappedResponse.getCharacterEncoding());
        String originalBody = new String(wrappedResponse.getContentAsByteArray(), charset);
        String modifiedBody = """
                {"originalResponse":%s,"appName":"Student Management System"}
                """.formatted(originalBody);

        wrappedResponse.resetBuffer();


        wrappedResponse.getWriter().write(modifiedBody);
        wrappedResponse.copyBodyToResponse();
    }
}
