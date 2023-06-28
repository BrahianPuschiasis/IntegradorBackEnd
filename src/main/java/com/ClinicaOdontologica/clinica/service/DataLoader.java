package com.ClinicaOdontologica.clinica.service;

import com.ClinicaOdontologica.clinica.entity.AppUser;
import com.ClinicaOdontologica.clinica.entity.AppUserRole;
import com.ClinicaOdontologica.clinica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        BCryptPasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder();
        String hashedPassword1 = passwordEncoder1.encode("password1");

        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");

        userRepository.save(new AppUser("Brahian","Comander","comander@gmail.com",hashedPassword1, AppUserRole.ADMIN));
        userRepository.save(new AppUser("Cristian","Cris","cris@gmail.com",hashedPassword2, AppUserRole.USER));
    }
}
