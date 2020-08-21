package DAO;

import models.Marque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MarqueDAO {
	public static Marque getOne(int id){
		try {
			Connection conn = DB.getDB();
			assert conn != null;
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM t_marques WHERE id_marque = " + id);
			while (resultSet.next()) {
				return new Marque(
						resultSet.getInt("id_marque"),
						resultSet.getString("nom_marque")
				);
			}
			return null;
		} catch (SQLException throwable) {
			throwable.printStackTrace();
			return null;
		}
	}
}
