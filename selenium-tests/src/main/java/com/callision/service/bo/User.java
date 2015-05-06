/**
 * 
 */
package com.callision.service.bo;

/**
 * @author Aleksei_Mordas
 *
 *         e-mail: * alexey.mordas@gmail.com Skype: alexey.mordas
 */
public class User {

	private String password;

	private String username;

	public User(final String username, final String password) {
		setUsername(username);
		setPassword(password);
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
