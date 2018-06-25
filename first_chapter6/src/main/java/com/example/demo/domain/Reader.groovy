package com.example.demo.domain;

import grails.persistence.Entity;
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class Reader implements UserDetails {

    String username
    String fullname
    String password

    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"))
    }

    @Override
    boolean isAccountNonExpired() {
        false
    }

    @Override
    boolean isAccountNonLocked() {
        false
    }

    @Override
    boolean isCredentialsNonExpired() {
        false
    }

    @Override
    boolean isEnabled() {
        false
    }
}