package models;

import DAO.*;

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
	
	public Rhum(int id, String nom, String details, int prix, int idMarque, int idOrigine) {
		this.id = id;
		this.nom = nom;
		this.details = details;
		this.prix = prix;
		this.marque = MarqueDAO.getOne(idMarque);
		this.origine = OrigineDAO.getOne(idOrigine);
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
