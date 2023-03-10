package miniHackathon;

public class Customer {

	// here are the fields required for a Customer Object:
   
    //"first_name",
    //"last_name",
    //"company_name",
    //"address",
    //"city",
    //"county",
    //"state",
    //"zip",
    //"phone1",
    //"phone2",
    //"email",
    //"web"
	
	private String first_name;
	private String last_name;
	private String company_name;
	private String address;
    private String city;
    private String county;
    private String state;
    private String zip;
    private String phone1;
    private String phone2;
    private String email;
    private String web;
    
    public Customer(String first_name, String last_name, String company_name, 
    String address, String city, String county, String state, String zip,
    String phone1, String phone2, String email, String web) {
    	
    	this.first_name = first_name;
		this.last_name = last_name;
		this.company_name = company_name;
		this.address = address;
		this.city = city;
		this.county = county;
		this.state = state;
		this.zip = zip;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.web = web;
    	
    }
    
    public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	public String getCompanyName() {
		return company_name;
	}
	public void setCompanyName(String company_name) {
		this.company_name = company_name;
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
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
    
	@Override
    public String toString() {
        return "First Name: " + first_name + ", Last Name: " +
        		 ", Company Name: " + company_name
 				+ ", address: " + address + ", city: " + city + ", county: " + county + ", state: " + state + ", zip: " + zip
 				+ ", phone1: " + phone1 + ", phone2: " + phone2 + ", email: " + email + ", web: " + web;

}}
