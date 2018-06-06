package web.plattform.rigs.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinTable;

@Entity
public class Rig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer IMO;
    private String type;

    @ManyToMany
    @JoinTable(name = "owner_rig", joinColumns = @JoinColumn(name="rig_id"),
    inverseJoinColumns = @JoinColumn(name = "owner_id"))

    private Set<Owner> owners = new HashSet<>();

    public Rig(){

    }

    public Rig(String name, Integer IMO, String type){
        this.name = name;
        this.IMO = IMO;
        this.type = type;
    }

    public Rig(String name, Integer IMO, String type, Set<Owner> owners){
        this.name = name;
        this.IMO = IMO;
        this.type = type;
        this.owners = owners;
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

    public Integer getIMO() {
        return IMO;
    }

    public void setIMO(Integer IMO) {
        this.IMO = IMO;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rig rig = (Rig) o;

        return id != null ? id.equals(rig.id) : rig.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Rig{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", IMO=" + IMO +
                ", type='" + type + '\'' +
                ", owners=" + owners +
                '}';
    }
}
