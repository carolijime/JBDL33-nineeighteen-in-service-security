package com.example.JBDL33eighteensecurity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyUser implements UserDetails {

    private static final String AUTHORITY_DELIMITER = ",";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Getter
    private String name;

    @Column(unique = true, nullable = false)
    private String email; //SHOULD ALWAYS BE UNIQUE: email id, insta handle, codechef handle
    private String password;
    @Getter
    private String authority;

    // dev --> deploying, monitoring, maintenance
    // qa --> monitoring, testing, performance_testing


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] authorities = this.authority.split(AUTHORITY_DELIMITER);
        return Arrays.stream(authorities)
                .map(x -> new SimpleGrantedAuthority(x))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    //need to make all below false (default value) into true for the below functions to work
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
}
