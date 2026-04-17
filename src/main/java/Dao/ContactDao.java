
	    package Dao;

	    import java.sql.*;
	    import java.util.*;
	    import model.Contact;

	    public class ContactDao {

	        public static Connection getConnection() {
	            Connection con = null;
	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/ecommerce_info",
	                    "root",
	                    "mohit"
	                );
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            return con;
	        }
	        public List<Contact> getAllContacts() {

	            List<Contact> list = new ArrayList<>();

	            
	            String sql = "SELECT * FROM contact ORDER BY created_at DESC";
	            try(Connection con = getConnection();

	                PreparedStatement ps = con.prepareStatement(sql)){

	                ResultSet rs = ps.executeQuery();

	                while(rs.next()){

	                    Contact c = new Contact();

	                    c.setId(rs.getInt("id"));
	                    c.setName(rs.getString("name"));
	                    c.setEmail(rs.getString("email"));
	                    c.setMessage(rs.getString("message"));
	                    c.setCreatedAt(rs.getString("created_at"));

	                    list.add(c);
	                }

	            } catch(Exception e){
	                e.printStackTrace();
	            }

	            return list;
	        }
	    
	    public boolean saveContact(String name, String email, String message) {

	        boolean f = false;

	         
	        String sql = "INSERT INTO contact(name, email, message) VALUES(?,?,?)";
	         try(Connection con = getConnection();

	            PreparedStatement ps = con.prepareStatement(sql)){

	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3, message);

	            int i = ps.executeUpdate();

	            if(i > 0){
	                f = true;
	            }

	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return f;
	    }
	}

