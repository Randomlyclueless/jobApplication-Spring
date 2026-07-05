package spring_boot_rest.spring_boot_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import spring_boot_rest.spring_boot_rest.model.User;
import spring_boot_rest.spring_boot_rest.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    private final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder(12);

    public User saveUser(User user) {

        User existingUser = repo.findByUsername(user.getUsername());

        if (existingUser != null) {
            throw new RuntimeException("Username already exists");
        }

        user.setPassword(
                encoder.encode(user.getPassword())
        );

        return repo.save(user);
    }
}