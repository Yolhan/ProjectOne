package dev.jason.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.jason.entities.Reimbursement;
import dev.jason.utilities.ConnectionUtil;

public class ReimbursementJDBCDAOS implements ReimbursementDAOS {

	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "INSERT INTO reimbursement VALUES(r_id=0, c_id=?, e_id=?, status=?, notes=?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, reimbursement.getC_id());
			ps.setInt(2, reimbursement.getE_id());
			ps.setInt(3, reimbursement.getStatus());
			ps.setString(4, reimbursement.getNotes());
			ResultSet rs = ps.executeQuery();
			rs.next();
			reimbursement.setR_id(rs.getInt("r_id"));
			return reimbursement;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Something went wrong in createRimbursement() in JDBCDAOS");
		return null;
	}

	public Reimbursement getReimbursementbyID(int r_id) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM reimbursement WHERE r_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Reimbursement reimbursement = new Reimbursement();
			reimbursement.setR_id(rs.getInt("r_id"));
			reimbursement.setC_id(rs.getInt("c_id"));
			reimbursement.setE_id(rs.getInt("e_id"));
			reimbursement.setStatus(rs.getInt("status"));
			reimbursement.setNotes(rs.getString("notes"));
			return reimbursement;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("That r_id was not found.");
		return null;
	}

	public List<Reimbursement> getReimbursements() {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM reimbursement";
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Reimbursement reimbursement;
			while(rs.next()) {
				reimbursement = new Reimbursement();
				reimbursement.setR_id(rs.getInt("r_id"));
				reimbursement.setC_id(rs.getInt("c_id"));
				reimbursement.setE_id(rs.getInt("e_id"));
				reimbursement.setStatus(rs.getInt("status"));
				reimbursement.setNotes(rs.getString("notes"));
				reimbursements.add(reimbursement);
			}
			if(reimbursements.size() == 0) return null;
			return reimbursements;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Something went wrong in gerReimbursements in JDBCDAOS");
		return null;
	}

	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "UPDATE reimbursement SET c_id=?, e_id=?, status=?, notes=? WHERE r_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbursement.getC_id());
			ps.setInt(2, reimbursement.getE_id());
			ps.setInt(3, reimbursement.getStatus());
			ps.setString(4, reimbursement.getNotes());
			ps.setInt(5, reimbursement.getR_id());
			ps.execute();
			return reimbursement;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("The r_id was not found.");
		return null;
	}

	public boolean removeReimbursement(Reimbursement reimbursement) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "DELETE FROM reimbursement WHERE r_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbursement.getR_id());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("That r_id was not found.");
		return false;
	}

}
