package com.trading.app.demo.db;

import com.github.javafaker.Faker;
import com.trading.app.demo.model.Profile;
import com.trading.app.demo.model.Trade;
import com.trading.app.demo.model.User;
import com.trading.app.demo.model.Wire;
import com.trading.app.demo.repository.ProfileRepository;
import com.trading.app.demo.repository.TradeRepository;
import com.trading.app.demo.repository.UserRepository;
import com.trading.app.demo.repository.WireRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class DataLoader {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final WireRepository wireRepository;
    private final TradeRepository tradeRepository;

    public DataLoader(UserRepository userRepository,
                      ProfileRepository profileRepository,
                      WireRepository wireRepository,
                      TradeRepository tradeRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.wireRepository = wireRepository;
        this.tradeRepository = tradeRepository;
    }

    public void seedDb() {
        // values needed
        int usersToSeed = 20;
        int wiresToSeed = 3;
        int tradesToSeed = 14;

        // libraries needed
        Faker faker = new Faker();
        Random random = new Random();

        // actual code
        for (int i = 0; i < usersToSeed; i++) {

            // CREATE A USER
            User user = new User(
                    faker.internet().emailAddress(),
                    "123456"
            );
            try {
                userRepository.save(user);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // CREATE ITS PROFILE
            Profile profile = new Profile(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.address().fullAddress(),
                    faker.phoneNumber().phoneNumber()
            );


            // BAD PRACTICE TO CHECK ON :
            // IF I DON'T SAVE FIRST I CANNOT ADD THE USER TO
            // THE MODEL, BECAUSE OF DETACHED MODE
            // I SAVE TWICE WHICH IS NOT GOOD
            profileRepository.save(profile);
            profile.setUser(user);
            profileRepository.save(profile);

            // CREATE WIRES
            for (int j = 0; j < wiresToSeed; j++) {
                Wire wire = new Wire(
                        faker.number().numberBetween(1134, 3321),
                        random.nextBoolean(),
                        user
                );

                wireRepository.save(wire);
            }


            // CREATES TRADES
            for (int j = 0; j < tradesToSeed; j++) {
                Trade trade = new Trade(
                        faker.stock().nyseSymbol(),
                        faker.number().numberBetween(13,56),
                        faker.number().numberBetween(1000, 10000),
                        faker.number().numberBetween(1000, 10000),
                        LocalDateTime.now().minusYears(1),
                        LocalDateTime.now().minusMonths(11),
                        random.nextBoolean(),
                        user
                );

                tradeRepository.save(trade);

            }
        }
    }
}
