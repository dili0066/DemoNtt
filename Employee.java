
public class Employee {
	
	private String name;
	private String email;
	private String address;
	private String mobile;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Employee(int id,String name, String email, String address, String mobile) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
	}
	
	@Override
	public String toString() {
		return "Employee [id="+id+" name=" + name + ", email=" + email + ", address=" + address + ", mobile=" + mobile +"]";
	}
	public Employee() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
