package by.chernyavski.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractBaseEntity{

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @JsonIgnore
    private List<Meal> meals;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @JsonIgnore
    private List<Vote> votes;

    public Restaurant(){

    }

    public Restaurant(@NotBlank @Size(min = 2, max = 100) String name, List<Meal> meals) {
        this.name = name;
        this.meals = meals;
    }

    public Restaurant(Integer id, @NotBlank @Size(min = 2, max = 100) String name, List<Meal> meals) {
        super(id);
        this.name = name;
        this.meals = meals;
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

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", meals=" + meals +
                ", id=" + id +
                '}';
    }
}
