package one_to_one;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="company")
public class Company 
{
	private int id;
	private Account acc;
	private String name;
	private String location;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cid")
	public int getId() {
		return id;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	public Account getAcc() {
		return acc;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
