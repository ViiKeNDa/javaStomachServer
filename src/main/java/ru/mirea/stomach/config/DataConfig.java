package ru.mirea.stomach.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mirea.stomach.entity.Doctor;
import ru.mirea.stomach.repository.DoctorRepository;

import java.util.ArrayList;

@Configuration
public class DataConfig {
    @Bean
    public CommandLineRunner loadData(DoctorRepository doctorRepository) {
        return (args) -> {
            if (doctorRepository.findAll().isEmpty()) {
                var doctors  = new ArrayList<Doctor>();
                doctors.add(Doctor.builder()
                        .username("Баранова Ольга Викторовна")
                        .speciality("Врач-хирург").build());

                doctors.add(Doctor.builder()
                        .username("Пупов Абоба Абобович")
                        .speciality("Врач-хирург").build());

                doctors.add(Doctor.builder()
                        .username("Михеева Татьяна Александровна")
                        .speciality("Ортодонт").build());

                doctors.add(Doctor.builder()
                        .username("Магомаев Максим Алексеевич")
                        .speciality("Ортодонт").build());

                doctors.add(Doctor.builder()
                        .username("Плугин Олег Маратович")
                        .speciality("Ортодонт").build());

                doctors.add(Doctor.builder()
                        .username("Рубина Ксения Олеговна")
                        .speciality("Ортопед").build());

                doctors.add(Doctor.builder()
                        .username("Феменко Мария Владимировна")
                        .speciality("Ортопед").build());

                doctors.add(Doctor.builder()
                        .username("Васильев Дмитрий Максимович")
                        .speciality("Ортопед").build());

                doctors.add(Doctor.builder()
                        .username("Дешко Агван Тиграныч")
                        .speciality("Терапевт").build());

                doctors.add(Doctor.builder()
                        .username("Гобубин Фёдор Петрович")
                        .speciality("Терапевт").build());

                doctorRepository.saveAll(doctors);
            }
        };
    }
}