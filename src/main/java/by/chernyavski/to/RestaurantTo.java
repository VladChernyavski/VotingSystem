package by.chernyavski.to;

import by.chernyavski.model.Meal;
import by.chernyavski.model.Vote;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class RestaurantTo {

    private Integer id;

    private String name;

    private List<Meal> meals;

    private List<Vote> votes;

    private int countVote;

    public RestaurantTo() {
    }

    public RestaurantTo(Integer id, String name, List<Meal> meals, List<Vote> votes, int countVote) {
        this.id = id;
        this.name = name;
        this.meals = meals;
        this.votes = votes;
        this.countVote = countVote;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public int getCountVote() {
        return countVote;
    }

    public void setCountVote(int countVote) {
        this.countVote = countVote;
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", meals=" + meals +
                ", votes=" + votes +
                ", countVote=" + countVote +
                '}';
    }
}
