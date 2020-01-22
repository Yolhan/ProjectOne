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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c_id;
		result = prime * result + cost;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Course other = (Course) obj;
		if (c_id != other.c_id)
			return false;
		if (cost != other.cost)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Course [c_id=" + c_id + ", name=" + name + ", cost=" + cost + "]";
	}
	
}
