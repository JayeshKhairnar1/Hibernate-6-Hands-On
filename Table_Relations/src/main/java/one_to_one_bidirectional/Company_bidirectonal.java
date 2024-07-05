package one_to_one_bidirectional;

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
public class Company_bidirectonal 
{
	@Override
	public String toString() {
		return "Company [id=" + id + ", acc=" + acc + ", name=" + name + ", location=" + location + "]";
	}
	private int id;
	private Account_bidirectional acc;
	private String name;
	private String location;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cid")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	public Account_bidirectional getAcc() {
		return acc;
	}
	public void setAcc(Account_bidirectional acc) {
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
