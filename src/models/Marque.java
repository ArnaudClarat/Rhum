package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Marque {
	int id;
	String nom;
	
	public Marque (int id) {
		try {
			Connection conn = DB.getDB();
			assert conn != null;
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM t_marques WHERE id_marque = " + id);
			if(resultSet.next()) {
				this.id = resultSet.getInt("id_marque");
				this.nom = resultSet.getNString("nom_marque");
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
