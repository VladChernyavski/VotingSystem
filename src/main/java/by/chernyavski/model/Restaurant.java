package by.chernyavski.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractBaseEntity{

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private List<Meal> meals;

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

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", meals=" + meals +
                ", id=" + id +
                '}';
    }
}
