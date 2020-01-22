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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c_id;
		result = prime * result + e_id;
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + r_id;
		result = prime * result + status;
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
		Reimbursement other = (Reimbursement) obj;
		if (c_id != other.c_id)
			return false;
		if (e_id != other.e_id)
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (r_id != other.r_id)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursement [r_id=" + r_id + ", e_id=" + e_id + ", c_id=" + c_id + ", status=" + status + ", notes="
				+ notes + "]";
	}
	
	
	
}
