package by.chernyavski.util;

import by.chernyavski.model.Restaurant;
import by.chernyavski.model.Vote;
import by.chernyavski.to.RestaurantTo;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VoteCounterUtil {

    public static List<RestaurantTo> getTo(List<Restaurant> restaurants, List<Vote> votes){
        Map<Restaurant, Integer> map = restaurants.stream()
                .collect(
                        Collectors.toMap(rest -> rest, rest -> {
                                    rest.setVotes(votes);
                                    return (int) rest.getVotes().stream()
                                            .filter(vote -> vote.getRestaurant().getId().equals(rest.getId()))
                                            .count();
                                }
                        )
                );

        return restaurants.stream()
                .map(restaurant -> createTo(restaurant, map.get(restaurant)))
                .collect(Collectors.toList());
    }

    public static RestaurantTo createTo(Restaurant restaurant, int voteCount) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), restaurant.getMeals(),
                restaurant.getVotes(), voteCount);
    }

}
