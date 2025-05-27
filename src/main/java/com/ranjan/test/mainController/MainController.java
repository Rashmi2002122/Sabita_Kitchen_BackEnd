package com.ranjan.test.mainController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranjan.test.entity.UserModel;
import com.ranjan.test.repository.UserRepository;
import com.ranjan.test.services.UserServices;

@RestController
@CrossOrigin(origins = {"https://sabita-cloud-kitchen.onrender.com", "http://localhost:3000"})
public class MainController {

	@Autowired
    private UserServices services;

  

    @RequestMapping("/")
    public String home() {
        return "Welcome to Sabita Cloud Kitchen!";
    }


    @GetMapping("/user")
    public Map<String, Object> getUser(OAuth2AuthenticationToken authentication) {
        if (authentication == null || authentication.getPrincipal() == null) {
            throw new RuntimeException("User is not authenticated");
        }

        OAuth2User oauthUser = authentication.getPrincipal();
        Map<String, Object> attributes = oauthUser.getAttributes();

        // Extract user details
        String id = (String) attributes.get("sub"); // Google ID
        String name = (String) attributes.get("name");
        String email = (String) attributes.get("email");
        String picture = (String) attributes.get("picture");

        // Save user to MongoDB
        services.saveOrUpdateUser(id, name, email, picture);

        return attributes;
    }
}
