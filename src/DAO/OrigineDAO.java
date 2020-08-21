package DAO;

import models.Origine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrigineDAO {
	public static Origine getOne(int id){
		try {
			Connection conn = DB.getDB();
			assert conn != null;
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM t_origines WHERE id_origine = " + id);
			while (resultSet.next()) {
				return new Origine(
						resultSet.getInt("id_origine"),
						resultSet.getString("nom_origine")
				);
			}
			return null;
		} catch (SQLException throwable) {
			throwable.printStackTrace();
			return null;
		}
	}
}
