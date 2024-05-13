package ru.mirea.stomach.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.stomach.entity.Doctor;
import ru.mirea.stomach.services.MyUserDetailsService;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/secured")
public class MainController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @GetMapping("/user/name")
    public String userAccess(Principal principal){
            if(principal == null){
                return null;
            }
        return principal.getName();
    }
    @GetMapping("/user/fio")
    public String fioAccess(Principal principal){
        if(principal == null){
            return null;
        }
        return myUserDetailsService.getFio(principal.getName());
    }

    @PostMapping("/doctor/add/{doctorId}")
    public ResponseEntity<?> addLikedMusic(Principal principal, @PathVariable Long doctorId) {
        myUserDetailsService.addDoctor(principal.getName(), doctorId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/doctor/remove/{doctorId}")
    public ResponseEntity<?> removeLikedMusic(Principal principal, @PathVariable Long doctorId) {
        myUserDetailsService.removeDoctor(principal.getName(), doctorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getLikedMusic(Principal principal) {
        List<Doctor> doctors = myUserDetailsService.getDoctors(principal.getName());
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }

}
