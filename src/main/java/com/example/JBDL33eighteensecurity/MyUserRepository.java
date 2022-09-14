package com.example.JBDL33eighteensecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    MyUser findByEmail(String u);
}
