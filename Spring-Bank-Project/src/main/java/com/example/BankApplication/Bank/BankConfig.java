package com.example.BankApplication.Bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BankConfig {
    @Bean
    CommandLineRunner commandLineRunner(BankRepository bankRepository) {
        return args -> {
            Bank user1 = new Bank("Anmol", "anmol@gmail.com", 9818638819L);
            Bank user2 = new Bank("Ramu", "ramu@gmail.com", 8130766092L);
        bankRepository.saveAll(List.of(user1, user2));
        };
    }
}
