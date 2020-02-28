package com.webonise.jwtsecurity.security.jwt;

import com.webonise.jwtsecurity.model.JwtUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * @author webonise on 24/02/20
 * @project jwt-security
 */
@Service
public class JwtUserService {

    private List<JwtUser> userRepository = new ArrayList<JwtUser>(){{
       add(new JwtUser("Swati", "Swati", 1, "Admin"));
       add(new JwtUser("Komal", "Komal", 2, "Admin" ));
       add(new JwtUser("Ashwin", "Ashwin", 3, "Admin"));
    }};

    public JwtUser get(JwtUser jwtUser) {
        JwtUser userFromRepo = userRepository.stream().filter(user -> user.getUserName().equals(jwtUser.getUserName())).findFirst().orElse(null);
        if (Optional.ofNullable(userFromRepo).isPresent() && userFromRepo.getPassword().equals(jwtUser.getPassword())) {
            return userFromRepo;
        } else {
            throw new RuntimeException("User not exist");
        }
    }
}
