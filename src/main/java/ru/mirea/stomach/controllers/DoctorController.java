package ru.mirea.stomach.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.stomach.entity.Doctor;
import ru.mirea.stomach.entity.DoctorDTO;
import ru.mirea.stomach.services.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/read")
    public ResponseEntity<List<Doctor>> readAll() {
        return new ResponseEntity<>(doctorService.readAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Doctor> create(@RequestBody DoctorDTO dto) {
        return new ResponseEntity<>(doctorService.create(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        doctorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
