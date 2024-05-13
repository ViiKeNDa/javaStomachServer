package ru.mirea.stomach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.stomach.entity.Doctor;
import ru.mirea.stomach.entity.User;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<User> findByUsername(String username);
}
