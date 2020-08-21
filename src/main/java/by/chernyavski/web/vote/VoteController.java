package by.chernyavski.web.vote;

import by.chernyavski.model.Restaurant;
import by.chernyavski.model.User;
import by.chernyavski.model.Vote;
import by.chernyavski.repository.RestaurantRepository;
import by.chernyavski.repository.UserRepository;
import by.chernyavski.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
@RequestMapping(value = "/vote")
public class VoteController {

    private final VoteRepository voteRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public VoteController(VoteRepository voteRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public String vote(HttpServletRequest request){

        User loggedUser = userRepository.getByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

        Vote vote = voteRepository.getVoteByDateAndUser(LocalDate.now(), loggedUser);
        if(vote != null){
            return "redirect:/restaurants";
        }
        vote = new Vote();
        vote.setUser(loggedUser);
        vote.setDate(LocalDate.now());
        Restaurant restaurant = restaurantRepository.get(Integer.parseInt(request.getParameter("rest")));
        vote.setRestaurant(restaurant);

        voteRepository.save(vote);
        return "redirect:/restaurants";
    }

}
