package com.example.client1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //    new authentication using jdbc
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")  //selects username from mysql table "users"
                .authoritiesByUsernameQuery("select username, role from users where username=?");
    }


//    todo DELETE commented out redundant code
@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
               .mvcMatchers("/css/**").permitAll()
               .mvcMatchers("/images/**").permitAll()
               .mvcMatchers("/").permitAll()
               .mvcMatchers("/viewMembers").hasRole("ADMIN")
               .mvcMatchers("/viewRecipients").hasRole("ADMIN")
               .mvcMatchers("/bookSessionAdmin").hasRole("ADMIN")
               .mvcMatchers("/sessionAdmin").hasRole("ADMIN")
               .mvcMatchers("/SupportAdmin").hasRole("ADMIN")
               .mvcMatchers("/membersArea" ).hasAnyRole("MEMBER","ADMIN")
               .mvcMatchers("/membersArea/extraMaterials").hasAnyRole("MEMBER","ADMIN")
               .mvcMatchers("/membersArea/extraMaterials/**").hasAnyRole("MEMBER","ADMIN")
               .mvcMatchers("/adminUserQuery").hasRole("ADMIN")
               .mvcMatchers("/news/**").permitAll()
               .mvcMatchers("/Add").permitAll()
               .mvcMatchers("/fileUpload").permitAll()
               .mvcMatchers("/admin/news/**").permitAll()
               .mvcMatchers("/admin/login").permitAll()



            .and()
                .formLogin().permitAll()
          .loginPage("/login")
                .defaultSuccessUrl("/membersArea", true) //go to homepage on succesful login - think I will remove this
            .and()
                .logout().logoutSuccessUrl("/")  //when user logs out redirect to homepage
            .and()
                .logout().permitAll()
//            .and()
            .and()
                .csrf().disable()
                .exceptionHandling().accessDeniedPage("/403");    //error handling for if user tries to access restricted page without logging in (403 error) - will build this page later..

    }
//    Bean for encoding using noop (only uses plaintext)
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}










