package com.emsi.patientsmvc.entities;

import jakarta.persistence.*;

import jakarta.validation.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty @Size(min = 4 , max = 20)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date  dateNaissance;
    private boolean malade;
    @Min(10)
    private int score;
}
