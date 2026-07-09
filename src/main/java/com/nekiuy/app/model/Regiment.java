package com.nekiuy.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Regiment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int number;
    private String name;

    @OneToMany(mappedBy = "regiment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<People> people = new ArrayList<>();
}
