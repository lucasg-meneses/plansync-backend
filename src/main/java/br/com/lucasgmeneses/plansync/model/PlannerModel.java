package br.com.lucasgmeneses.plansync.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_PLANNER")
@Getter
@Setter
public class PlannerModel implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private long month;
    private long year;

    @OneToMany(mappedBy = "planner", cascade = CascadeType.ALL)
    private List<TodoModel> todos;

    private String notes; // markdown support

    private UserModel owner;
    private Date dateCreated;
    private Date dateUpdated;

    public PlannerModel(String title, long month, long year, String notes, UserModel owner) {
        this.title = title;
        this.month = month;
        this.year = year;
        this.notes = notes;
        this.owner = owner;

        todos = new ArrayList<>();
    }
}
