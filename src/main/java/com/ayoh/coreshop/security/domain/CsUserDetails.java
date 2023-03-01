package com.ayoh.coreshop.security.domain;

import com.ayoh.coreshop.entity.member.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// @EqualsAndHashCode
public class CsUserDetails implements UserDetails {

    private final String email;
    private final String password;
    private final List<Authority> authorities;

    public CsUserDetails(String email, String password, List<Authority> authorities) {
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.stream()
                          .map(authority -> new SimpleGrantedAuthority(authority.getCode()))
                          .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

    /**
     * {@inheritDoc}
     *
     * @return 활성화 여부
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}
