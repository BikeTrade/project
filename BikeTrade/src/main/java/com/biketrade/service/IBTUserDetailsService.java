package com.biketrade.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.biketrade.model.BikeState;
import com.biketrade.model.User;

public interface IBTUserDetailsService {
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException; 
	
	public User findUserByEmail(String email);
	
    public User findUserByUserName(String userName);

    public User saveUser(User user);
    
    public User getCurrentUser();
    
    public List<User> findUserByIds(List<Integer> ids);
    
}
