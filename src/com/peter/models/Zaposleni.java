package com.peter.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author peter
 * Class represents a single employee, a general record which exists in a table of Zaposleni.
 * It has 4 String properties ime, priimek, oddelek, interna_telefonska_stevilka, with some validation, and a Long id, which is a primary key for table Zaposleni.
 * Methods in a class are auto-generated getters, setters and constructors.
 */
@Entity
@org.hibernate.annotations.Entity
@Table(name = "Zaposleni")
public class Zaposleni {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Pattern(regexp = ".+", message = "Dodajte ime")
	@Column(name = "ime")
	private String ime;

	@Pattern(regexp = ".+", message = "Dodajte priimek")
	@Column(name = "priimek")
	private String priimek;

	@Pattern(regexp = ".+", message = "Izberite oddelek")
	@Column(name = "oddelek")
	private String oddelek;

	@NotNull
	@Pattern(regexp = "^[0-9]{3}$", message = "Interna telefonska številka mora vsebovati natanko 3 števke.")
	@Column(name = "interna_telefonska_stevilka")
	private String interna_telefonska_stevilka;

	public Zaposleni() {
	}

	public Zaposleni(String ime, String priimek, String oddelek,
			String interna_telefonska_stevilka) {
		this.ime = ime;
		this.priimek = priimek;
		this.oddelek = oddelek;
		this.interna_telefonska_stevilka = interna_telefonska_stevilka;
	}



	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public String getOddelek() {
		return oddelek;
	}

	public void setOddelek(String oddelek) {
		this.oddelek = oddelek;
	}

	public String getInterna_telefonska_stevilka() {
		return interna_telefonska_stevilka;
	}

	public void setInterna_telefonska_stevilka(
			String interna_telefonska_stevilka) {
		this.interna_telefonska_stevilka = interna_telefonska_stevilka;
	}


	@Override
	public String toString() {
		return "Zaposleni [id=" + id + ", ime=" + ime + ", priimek=" + priimek
				+ ", oddelek=" + oddelek + ", interna_telefonska_stevilka="
				+ interna_telefonska_stevilka + "]";
	}
}
