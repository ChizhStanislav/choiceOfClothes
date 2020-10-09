package main.java.ru.leverx.choiceOfClothes.servlet;

import main.java.ru.leverx.choiceOfClothes.dictonary.Temperature;
import main.java.ru.leverx.choiceOfClothes.service.ClothesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static main.java.ru.leverx.choiceOfClothes.util.JspPathUtil.*;
import static main.java.ru.leverx.choiceOfClothes.util.UrlPath.*;

@WebServlet(CLOTHES)
public class ClothesServlet extends HttpServlet {

    private final ClothesService clothesService = ClothesService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("temperatures", Temperature.values());
        getServletContext().getRequestDispatcher(get(CLOTHES)).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        clothesService.save(req.getParameter("name"), req.getParameter("temperature"));
        getServletContext().getRequestDispatcher(get(CLOTHES)).forward(req, resp);
    }
}
