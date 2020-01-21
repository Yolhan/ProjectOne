package entities;

public class Course {
	// DATA MEMBERS / FIELDS
	private int c_id;
	private String name;
	private int cost;
	
	// CTORS
	public Course() {}
	public Course(int c_id, String name, int cost) {
		this.setC_id(c_id);
		this.setName(name);
		this.setCost(cost);
	}
	
	// SETTERS AND GETTERS
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		if (cost >= 0)
			this.cost = cost;
		else this.cost = 0;
	}
}
