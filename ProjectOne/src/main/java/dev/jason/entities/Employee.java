package dev.jason.entities;

public class Employee {
	// DATA MEMBERS / FIELDS
	private int e_id;
	private String username;
	private String password;
	private boolean ismanager;
	
	// CTORS
	public Employee() {}
	public Employee(int e_id, String username, String password, boolean ismanager) {
		this.setE_id(e_id);
		this.setUsername(username);
		this.setPassword(password);
		this.setIsmanager(ismanager);
	}
	
	// SETTERS AND GETTERS
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isIsmanager() {
		return ismanager;
	}
	public void setIsmanager(boolean ismanager) {
		this.ismanager = ismanager;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + e_id;
		result = prime * result + (ismanager ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (e_id != other.e_id)
			return false;
		if (ismanager != other.ismanager)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", username=" + username + ", password=" + password + ", ismanager="
				+ ismanager + "]";
	}
	
	
	
	
}
