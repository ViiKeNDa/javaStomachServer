package ru.mirea.stomach.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String fio;
    @OneToMany
    @JoinColumn(name = "doctor_id")
    private List<Doctor> writtenDoctors=new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        this.writtenDoctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        this.writtenDoctors.remove(doctor);
    }

}



