/**
 * 
 */
package com.callision.service;

import com.callision.service.bo.User;

/**
 * @author Aleksei_Mordas
 *
 *         e-mail: * alexey.mordas@gmail.com Skype: alexey.mordas
 */
public class UserFactory {
	public static User getFirstUser() {
		return new User("jsmith", "7sAEJ8pU0i2FVNpi");
	}
	
	public static User getSecondUser() {
		return new User("j.jameson", "izHJl1F2lHatbcB");
	}

}
