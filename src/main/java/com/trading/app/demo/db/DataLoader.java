package com.trading.app.demo.db;

import com.github.javafaker.Faker;
import com.trading.app.demo.model.*;
import com.trading.app.demo.repository.ProfileRepository;
import com.trading.app.demo.repository.TradeRepository;
import com.trading.app.demo.repository.UserRepository;
import com.trading.app.demo.repository.WireRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
@AllArgsConstructor
public class DataLoader {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final WireRepository wireRepository;
    private final TradeRepository tradeRepository;

    public void seedDb() {
        // values needed
        int usersToSeed = 20;
        int wiresToSeed = 3;
        int tradesToSeed = 14;


        Faker faker = new Faker();

        // CREATE A CONSTANT Admin (no faker)

        createUserAndProfile(
                "admin@admin.com",
                passwordEncoder.encode("123456"),
                Role.ADMIN,
                "Bruce",
                "Wayne",
                "Gotham City",
                "234-24-234",
                wiresToSeed,
                tradesToSeed,
                faker
        );


        // Loop as needed :
        for (int i = 0; i < usersToSeed; i++) {

            createUserAndProfile(
                    faker.internet().emailAddress(),
                    passwordEncoder.encode("123456"),
                    Role.USER,
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.address().fullAddress(),
                    faker.phoneNumber().phoneNumber(),
                    wiresToSeed,
                    tradesToSeed,
                    faker
            );

        }
    }


    private void createUserAndProfile(
            String email,
            String password,
            Role role,
            String firstName,
            String lastName,
            String address,
            String phone,
            int wiresNumber,
            int tradesNumber,
            Faker faker
            ){


        // libraries needed
        Random random = new Random();

        // CREATE A USER using Lombok builder
        User user = User.builder()
                .email(email)
                .role(role)
                .password(password)
                .build();

        try {
            userRepository.save(user);
            System.out.println("User " + user.getId() + " created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // CREATE ITS PROFILE with lombok builder
        Profile profile = Profile.builder()
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .phoneNumber(phone)
                .build();


        // BAD PRACTICE TO CHECK ON :
        // IF I DON'T SAVE FIRST I CANNOT ADD THE USER TO
        // THE MODEL, BECAUSE OF DETACHED MODE
        // I SAVE TWICE WHICH IS NOT GOOD
        profileRepository.save(profile);
        profile.setUser(user);
        profileRepository.save(profile);
        System.out.println("Profile for user " + user.getId() + " created");


        // CREATE WIRES
        for (int j = 0; j < wiresNumber; j++) {
            Wire wire = Wire.builder()
                    .amount(faker.number().numberBetween(1134, 3321))
                    .withdrawal(random.nextBoolean())
                    .build();

            wireRepository.save(wire);
        }
        System.out.println("User " + user.getId() + " wires created");


        // CREATES TRADES
        for (int j = 0; j < tradesNumber; j++) {
            Trade trade = Trade.builder()
                    .symbol(faker.stock().nyseSymbol())
                    .quantity(faker.number().numberBetween(13,56))
                    .openPriceInCent(faker.number().numberBetween(1000, 10000))
                    .closePriceInCent(faker.number().numberBetween(1000, 10000))
                    .openDateTime(LocalDateTime.now().minusYears(1))
                    .closeDateTime(LocalDateTime.now().minusMonths(11))
                    .open(random.nextBoolean())
                    .user(user)
                    .build();

            tradeRepository.save(trade);

        }

        System.out.println("User " + user.getId() + " trades created");

    }
}
