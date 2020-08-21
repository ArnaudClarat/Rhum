package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Rhum {
	int id; // ID du rhum
	String nom; // Nom du rhum
	String details; // Détails du rhum
	int prix; // Prix du rhum
	Marque marque; // Marque du rhum
	Origine origine; // Origine du rhum
	
	public Rhum(ResultSet resultSet) {
		// Crée le rhum en fonction du ResultSet
		try {
			if (resultSet.next()) {
				/*System.out.println(resultSet.toString());
				this.id = resultSet.getInt("id_rhum");
				this.nom = resultSet.getNString("nom_rhum");
				this.details = resultSet.getNString("details_rhum");
				this.prix = resultSet.getInt("prix_rhum");
				this.marque = new Marque(resultSet.getInt("marque_rhum"));
				this.origine = new Origine(resultSet.getInt("origine_rhum"));
				 */
				System.out.println("id: "+resultSet.getInt("id_rhum"));
				System.out.println("nom: "+resultSet.getString("nom_rhum"));
				System.out.println("origine: "+resultSet.getInt("origine_rhum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		System.out.println(origine);
		return origine;
	}
	
	public static String getRhums() {
		// Regroupe la partie SQL
		try {
			Connection conn = DB.getDB();
			assert conn != null;
			
			Statement statement = conn.createStatement();
			ResultSet rS = statement.executeQuery("SELECT id_rhum FROM t_rhums");
			List<Integer> index = new ArrayList<>();
			while (rS.next()) {
				index.add(rS.getInt(1));
			}
			System.out.println(index);
			/*
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM t_rhums WHERE id_rhum = " + id);
			Rhum rhum = new Rhum(resultSet);
			stmt.close();
			return rhum;
			 */
			return null;
		} catch (SQLException throwable) {
			throwable.printStackTrace();
			return null;
		}
	}
}
