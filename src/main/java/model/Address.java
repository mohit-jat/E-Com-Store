package model;



	public class Address {

	    private int id;
	    private int userId;
	    private String name;
	    private String mobile;
	    private String address;
	    private String city;
	    private String pincode;
		public Address(int id, int userId, String name, String mobile, String address, String city, String pincode) {
			super();
			this.id = id;
			this.userId = userId;
			this.name = name;
			this.mobile = mobile;
			this.address = address;
			this.city = city;
			this.pincode = pincode;
		}
		public Address() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Address(int userId, String name, String mobile, String address, String city, String pincode) {
			super();
			this.userId = userId;
			this.name = name;
			this.mobile = mobile;
			this.address = address;
			this.city = city;
			this.pincode = pincode;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
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
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		@Override
		public String toString() {
			return "Address [id=" + id + ", userId=" + userId + ", name=" + name + ", mobile=" + mobile + ", address="
					+ address + ", city=" + city + ", pincode=" + pincode + "]";
		}
	    
	    
	    
	    
	    
		
	}

