package fr.istic.tpservlet.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Home {

	private int id;
	
	private String adresse;
	
	private int superficie;
	
	private String adresseIP;
	
	private Person person;
	
	private List<Device> devices = new ArrayList<Device>();
	
	public Home() {
		
	}
	
	public Home(String adresse, int superficie, String adresseIP, Person person) {
		
		this.adresse = adresse;
		this.superficie = superficie;
		this.adresseIP = adresseIP;
		this.person = person;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public String getAdresseIP() {
		return adresseIP;
	}

	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}
	
	@ManyToOne
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
	public List<Device> getHeater() {
		return devices;
	}
	
	public void setHeater(List<Device> devices) {
		this.devices = devices;
	}
	
	public void addDevice(List<Device> devices) {
		this.setHeater(devices);
	}

}
