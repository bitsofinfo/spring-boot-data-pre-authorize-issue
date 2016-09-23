package my.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestRecord {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String firstname;
	private String lastname;
	
	public String toString() {
		return "id: "+id +
				" Firstname:" + firstname +
				" Lastname: " + lastname +
				" ID:" + getClass().getName() + '@' + Integer.toHexString(hashCode());
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
}
