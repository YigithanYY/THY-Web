package com.example.Students.entities.concretes;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Table(name="Cities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="city_id")
    private Long cityId;

    @Column(name="city_name")
    private String cityName;
}
