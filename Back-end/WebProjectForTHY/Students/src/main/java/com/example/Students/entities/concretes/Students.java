package com.example.Students.entities.concretes;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Table(name="students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Students {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="student_id")
        private Long studentId;

        @Column(name="first_name")
        private String FirstName;

        @Column(name="last_name")
        private String LastName;

        @Column(name="Phone_number")
        private String PhoneNumber;

        @Column(name="City_id")
        private Long CityId;

        @Column(name="District_id")
        private Long DistrictId;

        @Column(name="Description")
        private String Description;
}
