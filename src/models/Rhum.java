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
				// this.marque = new Marque(resultSet.getInt("marque_rhum")); TODO créer constructeur Marque
				// this.origine = new Origine(resultSet.getInt("marque_origine")); TODO Créer contructeur Origine
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
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM t_rhums " +
					"LEFT JOIN t_marques ON marque_rhum = id_marque " +
					"LEFT JOIN t_origines ON origine_rhum = id_origine " +
					"WHERE id_rhum = " + id
			);
			System.out.println(resultSet);
			Rhum rhum = new Rhum(resultSet);
			return rhum;
		} catch (SQLException throwable) {
			throwable.printStackTrace();
			return null;
		}
	}
}
