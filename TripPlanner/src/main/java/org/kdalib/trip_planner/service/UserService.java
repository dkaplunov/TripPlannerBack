package org.kdalib.trip_planner.service;

import org.kdalib.trip_planner.model.security.Users;
import org.kdalib.trip_planner.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    public Users findUserByName (String userName) {
        return usersRepository.findByUserName(userName);
    }

    public UserDetails loadUserByUserId(Long userId) throws UsernameNotFoundException  {
        Users user = usersRepository.findById(userId).get();
        return getUserDetails(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
        Users user = usersRepository.findByUserName(username);
        return getUserDetails(user);
    }

    private UserDetails getUserDetails (Users user) {
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return new ArrayList<>();
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getUserName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };

    }

}
