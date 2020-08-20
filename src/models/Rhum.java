package models;

import java.sql.*;

public class Rhum {
	int id; // ID du rhum
	String nom; // Nom du rhum
	String details; // Détails du rhum
	int prix; // Prix du rhum
	Marque marque; // Marque du rhum
	Origine origine; // Origine du rhum
	
	public Rhum(ResultSet resultSet) {
		try {
			if(resultSet.next()) {
				this.id = resultSet.getInt("id_rhum");
				this.nom = resultSet.getNString("nom_rhum");
				this.details = resultSet.getNString("details_rhum");
				this.prix = resultSet.getInt("prix_rhum");
				this.marque = new Marque(resultSet.getInt("marque_rhum"));
				this.origine = new Origine(resultSet.getInt("origine_rhum"));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getDetails() {
		return details;
	}
	
	public int getPrix() {
		return prix;
	}
	
	public Marque getMarque() {
		return marque;
	}
	
	public Origine getOrigine() {
		return origine;
	}
	
	public static Rhum getRhum(int id) {
		try {
			Connection conn = DB.getConn();
			assert conn != null;
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM t_rhums WHERE id_rhum = " + id);
			Rhum rhum = new Rhum(resultSet);
			conn.close();
			return rhum;
		} catch (SQLException throwable) {
			throwable.printStackTrace();
			return null;
		}
	}
}
