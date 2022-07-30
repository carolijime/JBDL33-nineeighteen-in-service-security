package com.example.JBDL33eighteensecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DemoConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        //two users with different permission, saved locally (in memory)
        auth.inMemoryAuthentication()
                .withUser("Karan")
                .password("karan123")
                .authorities("qa")
                .and()
                .withUser("Rashmi")
                .password("rashmi123")
                .authorities("dev");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
//        super.configure(http);
        //filters of the type of any url that has qa and follows by whatever, can oly be accessed by qa autorized users
        http
                .httpBasic().and()
                .authorizeRequests()
                .antMatchers("/testcode/**").hasAuthority("qa") //only available for qa user
                .antMatchers("/developcode/**").hasAuthority("dev") //only available for dev users
                .antMatchers("/accessserver/").hasAnyAuthority("dev", "qa") //only available for dev or qa users
                .antMatchers("/home").permitAll() //available for everyone
                .and()
                .formLogin();
    }

    @Bean
    PasswordEncoder getPE(){
        return NoOpPasswordEncoder.getInstance();
    }

}
