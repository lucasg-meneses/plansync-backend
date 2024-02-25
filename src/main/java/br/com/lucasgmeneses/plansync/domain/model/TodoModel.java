package br.com.lucasgmeneses.plansync.domain.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_TODO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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

    @OneToOne
    @JoinColumn(name = "owner_id")
    private UserModel owner;

    private LocalTime startTime;
    private LocalTime endTime;

    private Date dateCreated;
    private Date dateUpdated;

}
