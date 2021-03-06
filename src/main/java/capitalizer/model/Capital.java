package capitalizer.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "capital")
/*
 * define O-R mapping of todolist table
 */
public class Capital {
	@Id //primary key
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long pk) {
		id = pk;
	}
	
	@Basic
	@Column(name = "CAPITAL")
	private String capital;

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	@Basic
	@Column(name = "COUNTRY")
	private String country;
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Basic
	@Column(name = "CITY_POPULATION")
	private int cityPopulation;
	
	public int getCityPopulation() {
		return cityPopulation;
	}

	public void setCityPopulation(int cityPopulation) {
		this.cityPopulation = cityPopulation;
	}
	
	@Basic
	@Column(name = "COUNTRY_POPULATION")
	private int countryPopulation;
	
	public int getCountryPopulation() {
		return countryPopulation;
	}

	public void setCountryPopulation(int countryPopulation) {
		this.countryPopulation = countryPopulation;
	}
	
	@Basic
	@Column(name = "FUN_FACT")
	private String funFact;
	
	public String getFunFact() {
		return funFact;
	}

	public void setFunFact(String funFact) {
		this.funFact = funFact;
	}
	
	/*
	@Override
	public String toString() {
		return String.format("{\"id\": \"%d\", \"name\": \"%s\"}", id, name);
	}
	*/
}
