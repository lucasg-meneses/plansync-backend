package br.com.lucasgmeneses.plansync.domain.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_TODO")
@Getter
@Setter
public class TodoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

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

}
