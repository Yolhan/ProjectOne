package entities;

public class Reimbursement {
	// DATA MEMBERS / FIELDS
	private int r_id;
	private int e_id;
	private int c_id;
	private int status;
	private String notes;
	
	// CTOR
	public Reimbursement() {}
	public Reimbursement(int r_id, int e_id, int c_id, int status, String notes) {
		this.setR_id(r_id);
		this.setE_id(e_id);
		this.setC_id(c_id);
		this.setStatus(status);
		this.setNotes(notes);
	}
	
	// SETTERS AND GETTERS
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
