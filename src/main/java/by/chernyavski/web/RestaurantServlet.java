package by.chernyavski.web;

import by.chernyavski.model.Restaurant;
import by.chernyavski.repository.RestaurantRepository;
import by.chernyavski.repository.restaurant.DataJpaRestaurantRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestaurantServlet extends HttpServlet {

    private RestaurantRepository repository;
    private ApplicationContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        repository = context.getBean(DataJpaRestaurantRepository.class);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getParameter("name"));

        repository.save(restaurant);
        response.sendRedirect("restaurant");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        request.setAttribute("restaurant", repository.getAll());

        if ("create".equals(action)) {
            request.getRequestDispatcher("/restaurantForm.jsp").forward(request, response);
        }

        request.getRequestDispatcher("/restaurant.jsp").forward(request, response);
    }
}
