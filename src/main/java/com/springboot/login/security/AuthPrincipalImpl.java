package com.springboot.login.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthPrincipalImpl implements AuthPrincipal{
	
	@Override
	public String getAuthentication() {
		Authentication authen = SecurityContextHolder.getContext().getAuthentication();
		return authen.getPrincipal().toString();
	}
}
