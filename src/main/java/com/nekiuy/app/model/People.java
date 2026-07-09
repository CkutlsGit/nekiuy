package com.nekiuy.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fullName;
    private int age;
    private String purpose;

    @ManyToOne
    @JoinColumn(name = "id_rgt", nullable = false)
    private Regiment regiment;
}
