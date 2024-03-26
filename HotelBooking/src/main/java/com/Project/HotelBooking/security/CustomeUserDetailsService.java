package com.Project.HotelBooking.security;

import com.Project.HotelBooking.Entity.User;
import com.Project.HotelBooking.Exception.ResourceNotFoundException;
import com.Project.HotelBooking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomeUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public CustomeUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String emailormobileNumber) throws UsernameNotFoundException {
User user1 = userRepository.findByEmailorMobilenumber(emailormobileNumber, emailormobileNumber).
                orElseThrow(() -> new ResourceNotFoundException("user not found with emailormobilenumber:" + emailormobileNumber));
        return new
                org.springframework.security.core.userdetails.User(user1.getEmail(),
                user1.getMobileNumber(), mapRolesToAuthorities(user1.getRoles()));

    }



    private Collection< ? extends GrantedAuthority>
    mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new
                SimpleGrantedAuthority(role.toString())).collect(Collectors.toList());
    }
}
