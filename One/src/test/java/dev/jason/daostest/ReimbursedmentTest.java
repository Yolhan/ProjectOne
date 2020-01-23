package dev.jason.daostest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dev.jason.daos.ReimbursementDAOS;
import dev.jason.daos.ReimbursementJDBCDAOS;
import dev.jason.entities.Reimbursement;

public class ReimbursedmentTest {
	ReimbursementDAOS rd = new ReimbursementJDBCDAOS();
	@Test
	public void createReimbursementTest() {
		Reimbursement reimbursement = new Reimbursement(0, 4, 4, 1, "Order Pending");
		reimbursement = rd.createReimbursement(reimbursement);
		System.out.println(reimbursement);
		Assert.assertNotNull(reimbursement);
	}
	
	@Test
	public void getReimbursementbyIDTest() {
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setR_id(3);
		reimbursement = rd.getReimbursementbyID(reimbursement.getR_id());
		System.out.println(reimbursement);
		Assert.assertNotNull(reimbursement);
		
		// Negative test case
		reimbursement.setR_id(404);
		reimbursement = rd.getReimbursementbyID(reimbursement.getR_id());
		Assert.assertNull(reimbursement);
	}
	
	@Test
	public void getReimbursementsTest() {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>(rd.getReimbursements());
		for (Reimbursement reimbursement : reimbursements) {
			System.out.println(reimbursement);
		}
		Assert.assertNotNull(reimbursements);
	}
	
	@Test
	public void updateReimbursementTest() {
		Reimbursement reimbursement = new Reimbursement(5, 2, 5, 2, "Granted. Reimbursement has been processed.");
		reimbursement = rd.updateReimbursement(reimbursement);
		System.out.println(reimbursement);
		Assert.assertNotNull(reimbursement);
		
		// Negative test case
		reimbursement.setR_id(404);
		reimbursement = rd.updateReimbursement(reimbursement);
		Assert.assertNull(reimbursement);
	}
	
	@Test
	public void removeReimbursementTest() {
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setR_id(5);
		
		boolean result = rd.removeReimbursement(reimbursement);
		Assert.assertArrayEquals(true, result);
		
		// Negative test case
		result = rd.removeReimbursement(reimbursement);
		Assert.assertArrayEquals(false, result);
	}
}
