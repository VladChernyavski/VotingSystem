package by.chernyavski.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "restaurant")
public class Restaurant extends AbstractBaseEntity{

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private Set<Meal> meals;

    public Restaurant(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
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
