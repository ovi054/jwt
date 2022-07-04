package com.security.repository;

import com.security.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
@Configuration
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    //@Test
    @Bean
    public void testCreateUser()
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("12345");

        User newUser = new User("avi.pal257@gmail.com", password);
        User savedUser = userRepository.save(newUser);

        //assertThat(savedUser).isNotNull();
        //assertThat(savedUser.getId()).isGreaterThan(0);
    }
}
