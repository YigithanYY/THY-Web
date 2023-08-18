package com.example.Students.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Table(name="Districts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Districts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="district_id")
    private Long districtId;

    @Column(name="district_name")
    private String districtName;

    @Column(name="city_id")
    private Long cityId;

}
