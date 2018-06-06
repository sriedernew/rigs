package web.plattform.rigs.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;

    @ManyToMany(mappedBy = "owners")
    private Set<Rig> rigs = new HashSet<>();

    public Owner(){

    }

    public Owner(String name, String country){
        this.name = name;
        this.country = country;
    }

    public Owner(String name, String country, Set<Rig> Rigs){
        this.name = name;
        this.country = country;
        this.rigs = rigs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        return id != null ? id.equals(owner.id) : owner.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", rigs=" + rigs +
                '}';
    }
}
