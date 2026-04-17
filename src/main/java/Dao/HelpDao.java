package Dao;

	import java.sql.*;

	public class HelpDao {

	    public Connection getConnection() {
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

	    public boolean saveSupport(String name, String email, String message) {

	        boolean f = false;

	        
	        String sql = "INSERT INTO support(name, email, message) VALUES(?,?,?)";
	        try( Connection con = getConnection();

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

