/**
 * 
 */
package com.manitech.bubbleup.filter;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author Manish
 * @email 765mann@gmail.com
 * @createdDate Mar 17, 2018
 * @version 1.0
 */
public class UserAuthentication implements Authentication {

	private static final long serialVersionUID = 8438979354430732011L;
	private final UserDetails userDetails;
	private boolean authenticated = false;

	public UserAuthentication(UserDetails userDetails,boolean authenticated) {
		this.userDetails = userDetails;
		this.authenticated=authenticated;
	}

	@Override
	public String getName() {
		return userDetails.getUsername();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userDetails.getAuthorities();
	}

	@Override
	public Object getCredentials() {
		return userDetails.getPassword();
	}

	@Override
	public UserDetails getDetails() {
		return userDetails;
	}

	@Override
	public Object getPrincipal() {
		return userDetails.getUsername();
	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
}
