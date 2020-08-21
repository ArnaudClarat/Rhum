package models;

public class Marque {
	int id;
	String nom;
	
	public Marque(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
