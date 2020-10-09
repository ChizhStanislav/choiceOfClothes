package main.java.ru.leverx.choiceOfClothes.filter;

import main.java.ru.leverx.choiceOfClothes.dictonary.Role;
import main.java.ru.leverx.choiceOfClothes.dto.UserDto;
import main.java.ru.leverx.choiceOfClothes.util.UrlPath;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static main.java.ru.leverx.choiceOfClothes.util.UrlPath.*;

@WebFilter(CLOTHES)
public class AuthorisationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (isUserHasPermissions(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect(LOGIN);
        }
    }

    private boolean isUserHasPermissions(ServletRequest servletRequest) {
        UserDto user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return Objects.nonNull(user) && Role.ADMIN == user.getRole();
    }

    @Override
    public void destroy() {

    }
}
