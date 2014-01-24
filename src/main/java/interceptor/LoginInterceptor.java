package interceptor;

import com.google.common.collect.ImmutableSet;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: chen
 * DateTime: 12/28/13 10:40 AM
 */
public class LoginInterceptor implements HandlerInterceptor {

    ImmutableSet<String> interceptUri = ImmutableSet.of(
        "/user/.*",
        "/js/.*",
        "/bower/.*",
        "/css/.*",
        "/img/.*"
    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ( request.getSession().getAttribute("userId") != null )
            return true;

        for ( String uri : interceptUri ) {
            if ( request.getRequestURI().matches(uri) )
                return true;
        }

        response.sendRedirect("/user/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
