package serializationDeserialization;

import java.util.List;

public class Student {

	
	public Integer id;
	public String firstname;
	public String lastName;
	public String email;
	public String programme;
	
	List<String> courses;
	
	public int gerSID() {
		return id;
	}
	
	public void setSID(Integer id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}
}
