package ru.mirea.stomach.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.stomach.entity.Doctor;
import ru.mirea.stomach.entity.DoctorDTO;
import ru.mirea.stomach.repository.DoctorRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor create(DoctorDTO dto) {
        Doctor doctor = Doctor.builder()
                .username(dto.getUsername())
                .speciality(dto.getSpeciality())
                .build();
        return doctorRepository.save(doctor);
    }

    public List<Doctor> readAll(){
        return doctorRepository.findAll();
    }

    public void delete(Long id){
        doctorRepository.deleteById(id);
    }

}
