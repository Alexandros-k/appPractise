package appPractise;

public class doctors {
	
	
	private int id;
	private String name;
	private String specialty;
	private String address;
	private String phone;
	private String city;
	private String geographical_area;
	private String institution;
	private String position;
	private String medical_visitor;
	
	
	
	
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getMedical_visitor() {
		return medical_visitor;
	}


	public void setMedical_visitor(String medical_visitor) {
		this.medical_visitor = medical_visitor;
	}


	

	public doctors(String name, String specialty, String address, String phone, String city, String geographical_area,
			String institution, String position, String medical_visitor) {
		super();
		this.name = name;
		this.specialty = specialty;
		this.address = address;
		this.phone = phone;
		this.city = city;
		this.geographical_area = geographical_area;
		this.institution = institution;
		this.position = position;
		this.medical_visitor = medical_visitor;
	}


	public doctors(int id, String name, String specialty, String address, String phone, String city,
			String geographical_area, String institution, String position, String medical_visitor) {
		super();
		this.id = id;
		this.name = name;
		this.specialty = specialty;
		this.address = address;
		this.phone = phone;
		this.city = city;
		this.geographical_area = geographical_area;
		this.institution = institution;
		this.position = position;
		this.medical_visitor = medical_visitor;
	}


	




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGeographical_area() {
		return geographical_area;
	}
	public void setGeographical_area(String geographical_area) {
		this.geographical_area = geographical_area;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String toString() {
		return "doctors [id=" + id + ", name=" + name + ", specialty=" + specialty + ", address=" + address + ", phone="
				+ phone + ", city=" + city + ", geographical_area=" + geographical_area + ", institution=" + institution
				+ ", position=" + position + ", medical_visitor=" + medical_visitor + "]";
	}


	
	
	
}
