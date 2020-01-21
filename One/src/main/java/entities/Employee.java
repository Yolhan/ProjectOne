package entities;

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
}
