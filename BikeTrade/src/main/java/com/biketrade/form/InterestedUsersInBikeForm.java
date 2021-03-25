package com.biketrade.form;

import java.util.List;

import com.biketrade.model.Bike;
import com.biketrade.model.User;

public class InterestedUsersInBikeForm {
	Bike bike;
	List<User> users;
	public Bike getBike() {
		return bike;
	}
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
