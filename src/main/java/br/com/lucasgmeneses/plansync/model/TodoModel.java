package br.com.lucasgmeneses.plansync.model;

import br.com.lucasgmeneses.plansync.model.enuns.Weekday;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "TB_TODO")
@Getter
@Setter
public class TodoModel implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description; // support markdown

    @Enumerated(EnumType.STRING)
    private Weekday weekday;
    @ManyToOne
    @JoinColumn(name = "planner_id")
    private PlannerModel planner;

    private LocalTime startTime;
    private LocalTime endTime;

    private Date dateCreated;
    private Date dateUpdated;


    public TodoModel(String title, String description, Weekday weekday, LocalTime startTime, LocalTime endTime) {
        this.title = title;
        this.description = description;
        this.weekday = weekday;
        this.startTime = startTime;
        this.endTime = endTime;

        this.dateUpdated = new Date();
        this.dateCreated = new Date();
    }
}
