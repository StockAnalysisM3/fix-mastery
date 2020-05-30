package com.fixmastery.users.security;

import com.fixmastery.users.model.Client;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ClientDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public ClientDetails() {}

    public ClientDetails(String userName) {
        this.userName = userName;
    }

    public ClientDetails(Client client) {
        this.userName = client.getUserName();
        this.password = client.getPassword();
        this.active = client.isActive();
        this.authorities = getGrantedAuthoritiesFromClientData(client.getRoles());
    }

        private List<GrantedAuthority> getGrantedAuthoritiesFromClientData(String stringRoles) {
            String[] rolesArray = stringRoles.split(",");
            List<GrantedAuthority> grantedAuthorities =
                Arrays.stream(rolesArray)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
            return grantedAuthorities;
        }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
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
        return active;
    }
}
