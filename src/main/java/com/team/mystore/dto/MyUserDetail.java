package com.team.mystore.dto;

import com.team.mystore.entity.Role;
import com.team.mystore.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetail  implements UserDetails {
    private String userName ;
    private String passsword;
    private String active;
    private String email;

    private List<GrantedAuthority> authorites;
    public MyUserDetail(User user){

        this.userName= user.getUsername();
        this.passsword=user.getPassword();
        this.active=user.getFlagDelete();
        List<GrantedAuthority> role= new ArrayList<>();
        //user.getRoles().forEach(i -> role.add(i.getName()));

        for(Role i:user.getRoles()){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(i.getName());
            role.add(simpleGrantedAuthority);
        }
        this.authorites= role;
        this.email=user.getEmail();


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorites;
    }

    @Override
    public String getPassword() {
        return passsword;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return this.active.equals("0")?true:false;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
