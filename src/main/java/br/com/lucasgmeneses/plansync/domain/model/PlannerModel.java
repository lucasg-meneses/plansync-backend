package br.com.lucasgmeneses.plansync.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_PLANNER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PlannerModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private String title;

    private long month;
    private long year;

    @OneToMany(mappedBy = "planner", cascade = CascadeType.ALL)
    private List<TodoModel> todos = new ArrayList<>();

    private String notes; // markdown support
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel owner;

    private Date dateCreated;
    private Date dateUpdated;

}
