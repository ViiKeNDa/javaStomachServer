package ru.mirea.stomach.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mirea.stomach.entity.Doctor;
import ru.mirea.stomach.entity.User;
import ru.mirea.stomach.repository.DoctorRepository;
import ru.mirea.stomach.repository.UserRepository;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private DoctorRepository doctorRepository;

    public void addDoctor(String userName, Long doctorId) {
        User user = repository.findByUsername(userName)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь не найден: " + userName));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Врач не найден: " + doctorId));
        user.addDoctor(doctor);
        repository.save(user);
    }

    public void removeDoctor(String userName, Long doctorId) {
        User user = repository.findByUsername(userName)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь не найден: " + userName));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Врач не найден: " + doctorId));
        user.removeDoctor(doctor);
        repository.save(user);
    }

    public List<Doctor> getDoctors(String userName) {
        User user = repository.findByUsername(userName)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь не найден: " + userName));
        return user.getWrittenDoctors();
    }


    public String getFio(String username){
        User user = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
        return user.getFio();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
        return MyUserDetails.build(user);
    }



}
