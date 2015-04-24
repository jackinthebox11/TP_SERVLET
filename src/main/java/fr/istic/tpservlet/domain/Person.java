package fr.istic.tpservlet.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Person {
	
	@Id
	private int id;
	
	private String nom;
	
	private String prenom;
	
	private String genre;
	
	private String email;
	
	private List<Home> homes = new ArrayList<Home>();
	
	@Temporal(TemporalType.DATE)
	private java.util.Date dateNaissance;
	
	private String profilFacebook;
	
	public Person() {
		super();
	}
	
	public Person(String nom, String prenom, String genre, String email, java.util.Date date, String profilFacebook) {
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.email = email;
		this.dateNaissance = date;
		this.profilFacebook = profilFacebook;
	}
	
	public Person(String nom) {
		this.nom = nom;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date date) {
		this.dateNaissance = date;
	}

	public String getProfilFacebook() {
		return profilFacebook;
	}

	public void setProfilFacebook(String profilFacebook) {
		this.profilFacebook = profilFacebook;
	}
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public List<Home> getHomes() {
		return homes;
	}
	
	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}

}
