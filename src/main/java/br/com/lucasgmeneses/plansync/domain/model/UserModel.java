package br.com.lucasgmeneses.plansync.domain.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String username;
    private String password;
    private String email;
    private Date dateCreated;
    private Date dateUpdated;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<PlannerModel> planners;
}
