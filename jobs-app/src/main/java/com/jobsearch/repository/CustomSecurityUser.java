package com.jobsearch.repository;

import java.util.Set;
import org.springframework.security.core.userdetails.UserDetails;

import com.jobsearch.domain.Authority;
import com.jobsearch.domain.User;

public class CustomSecurityUser extends User implements UserDetails {
	
	private static final long serialVersionUID = 6572472581245004235L;
	
	public CustomSecurityUser() {
		
	}
	
	public CustomSecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setEmail(user.getEmail());
	}
	
	@Override
	public Set<Authority> getAuthorities() {
		return super.getAuthorities();
	}
	
	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
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
}
