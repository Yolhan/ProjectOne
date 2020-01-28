package dev.jason.daos;

import java.util.List;

import dev.jason.entities.Reimbursement;

public interface ReimbursementDAOS {
// CRUD
	
// CREATE 
	/***
	 * The filled out reinbursment will be updated to the que on the database
	 * @param reinbursment - The filled out item to be added to the database
	 * The r_id will be updated
	 * @return - The returned Reinbursement will have the updated r_id attached
	 */
	public Reimbursement createReimbursement(Reimbursement reimbursement);
	
	// READ
	/***
	 * Will find an item with the r_id matching inside the database. Will return NULL if failed to find r_id
	 * @param r_id - The primary key to search the database
	 * @return - The item to be found. This will return null if the item was not found
	 */
	public Reimbursement getReimbursementbyID(int r_id);
	
	/***
	 * This will provide all the items on the database
	 * @return - The total list of items to be processed. This will be null if the list is empty.
	 */
	public List<Reimbursement> getReimbursements();
	
	// UPDATE
	/***
	 * Will update the item with the valid r_id. Will return NULL if failed to find r_id
	 * @param reimbursement
	 * @return
	 */
	public Reimbursement updateReimbursement(Reimbursement reimbursement);
	
	// DELETE
	/***
	 * This will remove the reimbursement item based off r_id. 
	 * @param reimbursement - The item containing the r_id for the item to re removed from the database
	 * @return - will return true if the item was found and removed. False if otherwise
	 */
	public boolean removeReimbursement(Reimbursement reimbursement);
}
