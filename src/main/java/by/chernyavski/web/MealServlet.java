package by.chernyavski.web;

import by.chernyavski.repository.MealRepository;
import by.chernyavski.repository.meal.DataJpaMealRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MealServlet extends HttpServlet {

    private MealRepository repository;
    private ApplicationContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        repository = context.getBean(DataJpaMealRepository.class);
    }

    @Override
    public void destroy(){
        super.destroy();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
        request.setAttribute("meals", repository.getAll(restaurantId));
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }

}
