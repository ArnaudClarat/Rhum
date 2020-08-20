package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Origine {
	int id;
	String nom;
	
	public Origine (int id) {
		try {
			Connection conn = DB.getConn();
			assert conn != null;
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM t_origines WHERE id_origine = " + id);
			if(resultSet.next()) {
				this.id = resultSet.getInt("id_origine");
				this.nom = resultSet.getNString("nom_origine");
			}
			conn.close();
		} catch (
			SQLException throwable) {
			throwable.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
