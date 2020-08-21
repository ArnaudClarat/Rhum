package models;


public class Origine {
	int id;
	String nom;
	
	public Origine(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
