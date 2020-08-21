package DAO;

import models.Rhum;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RhumDAO {
	static private Connection conn = DB.getDB();
	
	public static Rhum getOne(int id) {
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM t_rhums WHERE id_rhum = " + id);
			Rhum rhum = new Rhum(
					resultSet.getInt("id_rhum"),
					resultSet.getNString("nom_rhum"),
					resultSet.getNString("details_rhum"),
					resultSet.getInt("prix_rhum"),
					resultSet.getInt("marque_rhum"),
					resultSet.getInt("origine_rhum")
			);
			return rhum;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Rhum> getAll() {
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM t_rhums");
			List<Rhum> rhums = new ArrayList<Rhum>();
			while (resultSet.next()) {
				Rhum rhum = new Rhum(
				resultSet.getInt(1),
				resultSet.getString(2),
				resultSet.getString(3),
				resultSet.getInt(4),
				resultSet.getInt(5),
				resultSet.getInt(6)
				);
				rhums.add(rhum);
			}
			return rhums;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
