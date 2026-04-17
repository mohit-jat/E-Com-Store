package Dao;


import java.sql.*;

import model.USER;

	public class UserDao {  
	    
	    public Connection getConnection() {
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_info", "root", "mohit");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
	    }

	    
	    
	    public int registerUser(USER user) {
	               int i =0;
	    	String query = "INSERT INTO users(name, username, email, phone, password, address) VALUES(?,?,?,?,?,?)";
	        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setString(1, user.getName());
	            ps.setString(2, user.getUsername());
	            ps.setString(3, user.getEmail());
	            ps.setString(4, user.getPhone());
	            ps.setString(5, user.getPassword());
	            ps.setString(6, user.getAddress());

	             i = ps.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return i;
	    }
	    public USER loginUser(String username) {
	        USER user = null;
	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=?")) {

	            ps.setString(1, username.trim());
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                user = new USER();
	                user.setUser_id(rs.getInt("user_id"));   
	                user.setName(rs.getString("name"));
	                user.setUsername(rs.getString("username"));
	                user.setEmail(rs.getString("email"));
	                user.setPhone(rs.getString("phone"));
	                user.setPassword(rs.getString("password"));
	                user.setAddress(rs.getString("address"));
	                
	                // --- YE LINE ADD KARO ---
	                user.setRole(rs.getString("role")); 
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return user;
	    }
	    
	    
	    
	    public int updateUser(USER user) {

	    	int i=0;
	    	String query = "UPDATE users SET name=?, username=?, email=?, phone=?, password=?, address=? WHERE user_id=?";
	        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setString(1, user.getName());
	            ps.setString(2, user.getUsername());
	            ps.setString(3, user.getEmail());
	            ps.setString(4, user.getPhone());
	            ps.setString(5, user.getPassword());
	            ps.setString(6, user.getAddress());
	            ps.setInt(7, user.getUser_id());

	            i = ps.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return i;
	    }
	  
	    public String getpassword(String username) {
	        String pass = null;
	        try {
	            Connection con = getConnection();
	            PreparedStatement ps = con.prepareStatement("SELECT password FROM users WHERE username=?");
	            ps.setString(1, username);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                pass = rs.getString("password");
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return pass;
	    }
	  
	    public int storeOtp(String email, String otp) {
	        int i = 0;

	        try (Connection con = getConnection();
	             PreparedStatement pst = con.prepareStatement(
	                "UPDATE users SET otp=? WHERE email=?")) {

	            pst.setString(1, otp.trim());
	            pst.setString(2, email.trim().toLowerCase());

	            i = pst.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return i;
	    }
	
	    
	    
	    public int updatePassword(String email, String hashed) {
			int i = 0;
			try (Connection con = getConnection();
					PreparedStatement pst = con.prepareStatement(
							"update users set password = ? where email = ?");) {

				pst.setString(1, hashed);
				pst.setString(2, email);
				
				i = pst.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return i;
		}
	
	    
	    
	    public int updatePassword(String email, String hashed, String otp) {
		    int i = 0;

		    try (Connection con = getConnection();
		         PreparedStatement pst = con.prepareStatement(
		            "UPDATE users SET password=?, otp=NULL WHERE email=? AND otp=?")) {

		        pst.setString(1, hashed);
		        pst.setString(2, email.trim().toLowerCase());
		        pst.setString(3, otp.trim());

		        i = pst.executeUpdate();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return i;
		}
	  
	    
	    public USER getUserByUsername(String username) {
	        USER user = null;
	        String sql = "SELECT * FROM users WHERE username=?";
	        try(Connection con = getConnection();
	            PreparedStatement ps = con.prepareStatement(sql)){
	            ps.setString(1, username);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                user = new USER();
	                user.setUser_id(rs.getInt("user_id"));
	                user.setName(rs.getString("name"));
	                user.setUsername(rs.getString("username"));
	                user.setEmail(rs.getString("email"));
	                user.setAddress(rs.getString("address"));
	                user.setPhone(rs.getString("phone"));    
	                
	                user.setRole(rs.getString("role"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return user;
	    }
	    
	    
	    
	    public int updateUserFull(int id, String name, String email, String phone, String address) {

	    	int  i =0;
	        
	    	String query = "UPDATE users SET name=?, email=?, phone=?, address=? WHERE user_id=?";
	          try( Connection con = getConnection();
	            PreparedStatement ps = con.prepareStatement(query)){

	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3, phone);
	            ps.setString(4, address);
	            ps.setInt(5, id);

	            i = ps.executeUpdate();
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return i;
	    }
	    
	  
	    
	    public int changePassword(int userId, String oldPass, String newPass) {

	    	int i =0;
	    	
	    	String q = "UPDATE users SET password=? WHERE user_id=? AND password=?";
	          try( Connection con = getConnection();
	            PreparedStatement ps = con.prepareStatement(q)){
	            ps.setString(1, newPass);
	            ps.setInt(2, userId);
	            ps.setString(3, oldPass);
	            i=ps.executeUpdate();
	            con.close();
	        } catch (Exception e) { e.printStackTrace(); }
	        return i;
	    }

	    
	    
	    
	    
	    public int deleteAccount(int userId) {

	        int i = 0;

	        try {
	            Connection con = getConnection();
	            String q = "DELETE FROM users WHERE user_id=?";
	            PreparedStatement ps = con.prepareStatement(q);

	            ps.setInt(1, userId);

	            i = ps.executeUpdate();

	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return i;
	    }
	  
	}