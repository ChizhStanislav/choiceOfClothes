package main.java.ru.leverx.choiceOfClothes.servlet;

import main.java.ru.leverx.choiceOfClothes.dto.UserDto;
import main.java.ru.leverx.choiceOfClothes.service.UserService;
import main.java.ru.leverx.choiceOfClothes.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

import static main.java.ru.leverx.choiceOfClothes.util.UrlPath.*;

@WebServlet(LOGIN)
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(JspPathUtil.get(LOGIN)).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Optional<UserDto> user = userService.login(req.getParameter("username"), req.getParameter("password"));

        if (user.isPresent()) {
            req.getSession().setAttribute("user", user.get());
            resp.sendRedirect(CLOTHES);
        } else {
            resp.sendRedirect(LOGIN);
        }
    }
}
