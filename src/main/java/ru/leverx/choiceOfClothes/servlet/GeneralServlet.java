package main.java.ru.leverx.choiceOfClothes.servlet;



import main.java.ru.leverx.choiceOfClothes.dto.ClothesDto;
import main.java.ru.leverx.choiceOfClothes.service.ClothesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static main.java.ru.leverx.choiceOfClothes.util.JspPathUtil.*;
import static main.java.ru.leverx.choiceOfClothes.util.UrlPath.*;


@WebServlet(GENERAL)
public class GeneralServlet extends HttpServlet {

    private final ClothesService clothesService = ClothesService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(get(GENERAL)).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("clothes", clothesService.findAllByCity(req.getParameter("city")));
        getServletContext().getRequestDispatcher(get(GENERAL)).forward(req, resp);
    }
}
