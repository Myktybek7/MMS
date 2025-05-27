package alatoo.edu.medicalmanagementsystem.services.impl;


import alatoo.edu.medicalmanagementsystem.entities.User;
import alatoo.edu.medicalmanagementsystem.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String roleFromDb = user.getRole();
        String roleWithPrefix = roleFromDb.startsWith("ROLE_") ? roleFromDb : "ROLE_" + roleFromDb;

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(roleWithPrefix));

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
    }

}

