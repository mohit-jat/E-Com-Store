package model;


	public class Support {

	    private int id;
	    private String name;
	    private String email;
	    private String message;
	    private String createdAt;

	    // 🔥 Constructors
	    public Support() {
	    }

	    public Support(int id, String name, String email, String message, String createdAt) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.message = message;
	        this.createdAt = createdAt;
	    }

	    public Support(String name, String email, String message) {
	        this.name = name;
	        this.email = email;
	        this.message = message;
	    }

	    // 🔥 Getters & Setters
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

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public String getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(String createdAt) {
	        this.createdAt = createdAt;
	    }

	    @Override
	    public String toString() {
	        return "Support [id=" + id + ", name=" + name + ", email=" + email + ", message=" + message + ", createdAt=" + createdAt + "]";
	    }
	}

