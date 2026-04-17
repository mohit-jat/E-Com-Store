package model;


	public class USER {

	    private int user_id;
	    private String name;
	    private String username;
	    private String email;
	    private String phone;
	    private String password;
	    private String address;
	    private String role;

	    public USER() {
	    }

	    public USER(int user_id, String name, String username, String email, String phone, String password, String address,String role) {
	        this.user_id = user_id;
	        this.name = name;
	        this.username = username;
	        this.email = email;
	        this.phone = phone;
	        this.password = password;
	        this.address = address;
	        this.role = role;
	    }

	    public USER(String name, String username, String email, String phone, String password, String address,String role) {
	        this.name = name;
	        this.username = username;
	        this.email = email;
	        this.phone = phone;
	        this.password = password;
	        this.address = address;
	        this.role = role;

	    }

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
         
		public String getRole() {
			return  role;
		}
		
		public void setRole(String role)
		{
			this.role = role;
		}
		@Override
		public String toString() {
			return "USER [user_id=" + user_id + ", name=" + name + ", username=" + username + ", email=" + email
					+ ", phone=" + phone + ", password=" + password + ", address=" + address + ",role =" +role+"]";
		}

	  }