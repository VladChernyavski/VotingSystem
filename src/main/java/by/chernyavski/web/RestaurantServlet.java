package by.chernyavski.web;

import by.chernyavski.repository.RestaurantRepository;
import by.chernyavski.repository.datajpa.DataJpaRestaurantRepository;
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
    public void destroy(){
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("restaurant", repository.getAll());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
