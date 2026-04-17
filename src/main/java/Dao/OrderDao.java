package Dao;


	import java.sql.*;
	import java.util.*;

import model.Address;
import model.OrderDetails;

	public class OrderDao {

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
             
	    public List<OrderDetails> getUserOrders(int userId) {

	        List<OrderDetails> list = new ArrayList<>();

	        String query = "SELECT o.*, p.title, p.category, p.img " +
	                       "FROM orders o " +
	                       "JOIN products p ON o.product_id = p.product_id " +
	                       "WHERE o.user_id = ? " +
	                       "ORDER BY o.order_date DESC";

	        try (
	            Connection con = getConnection();
	            PreparedStatement ps = con.prepareStatement(query)
	        ) {

	            ps.setInt(1, userId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                OrderDetails od = new OrderDetails();

	                od.setOrderId(rs.getInt("order_id"));
	                od.setProductId(rs.getInt("product_id"));

	                od.setTitle(rs.getString("title"));
	                od.setCategory(rs.getString("category"));
	                od.setImg(rs.getString("img"));

	                od.setQuantity(rs.getInt("quantity"));
	                od.setPrice(rs.getDouble("price"));
	                od.setAddress(rs.getString("address"));
	                od.setPaymentType(rs.getString("payment_type"));
	                od.setStatus(rs.getString("status"));
	                od.setOrderDate(rs.getString("order_date"));
	                od.setReturnStatus(rs.getString("return_status"));
	                list.add(od);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
	   	    
	  
	    
	    public List<OrderDetails> getAllOrders() {

	        List<OrderDetails> list = new ArrayList<>();

	        String query = "SELECT o.order_id, o.user_id, o.product_id, o.quantity, o.price, " +
	                "o.address, o.payment_type, o.status, o.order_date, o.return_status, " + 
	                "p.title, p.category, p.img " +
	                "FROM orders o " +
	                "JOIN products p ON o.product_id = p.product_id " +
	                "ORDER BY o.order_date DESC";
	        try (
	            Connection con = getConnection();
	            PreparedStatement ps = con.prepareStatement(query);
	            ResultSet rs = ps.executeQuery()
	        ) {

	            while (rs.next()) {

	                OrderDetails od = new OrderDetails();

	                od.setOrderId(rs.getInt("order_id"));
	                od.setUserId(rs.getInt("user_id"));
	                od.setProductId(rs.getInt("product_id"));
	                od.setQuantity(rs.getInt("quantity"));
	                od.setPrice(rs.getDouble("price"));
	                od.setAddress(rs.getString("address"));
	                od.setPaymentType(rs.getString("payment_type"));
	                od.setStatus(rs.getString("status"));
	                od.setOrderDate(rs.getString("order_date"));
	                od.setReturnStatus(rs.getString("return_status"));
	                od.setTitle(rs.getString("title"));
	                od.setCategory(rs.getString("category"));
	                od.setImg(rs.getString("img"));
                    
	                list.add(od);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
	   
	    
	    
	    
	    public void placeOrder(int userId, String address, String payment) {

	        try (Connection con = getConnection()) {

	            String cartQuery = "SELECT c.product_id, c.quantity, p.discountPrice " +
	                               "FROM cart c " +
	                               "JOIN products p ON c.product_id = p.product_id " +
	                               "WHERE c.user_id=?";

	            PreparedStatement ps = con.prepareStatement(cartQuery);
	            ps.setInt(1, userId);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                PreparedStatement insert = con.prepareStatement(
	                    "INSERT INTO orders(user_id, product_id, quantity, price, address, payment_type, status) " +
	                    "VALUES(?,?,?,?,?,?,?)"
	                );

	                insert.setInt(1, userId);
	                insert.setInt(2, rs.getInt("product_id"));
	                insert.setInt(3, rs.getInt("quantity"));

	                insert.setDouble(4, rs.getDouble("discountPrice"));

	                insert.setString(5, address);
	                insert.setString(6, payment);
	                insert.setString(7, "Pending");

	                insert.executeUpdate();
	            }

	            PreparedStatement clear = con.prepareStatement("DELETE FROM cart WHERE user_id=?");
	            clear.setInt(1, userId);
	            clear.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
	        
	    }
	    
	    
	    
	    public boolean requestReturn(int orderId) {

	        boolean f = false;

	      
	        String sql = "UPDATE orders SET return_status=? WHERE order_id=?";
	        try( Connection con = getConnection();

	            PreparedStatement ps = con.prepareStatement(sql)){

	            ps.setString(1, "Requested");
	            ps.setInt(2, orderId);

	            f = ps.executeUpdate() > 0;

	            con.close();

	        } catch(Exception e){
	            e.printStackTrace();
	        }

	        return f;
	    }
	    
	    
	    
	    public List<OrderDetails> getReturnRequests() {

	        List<OrderDetails> list = new ArrayList<>();

	       
	        String sql = "SELECT * FROM orders WHERE return_status='Requested'";
	            try(Connection con = getConnection();

	            PreparedStatement ps = con.prepareStatement(sql)){

	            ResultSet rs = ps.executeQuery();

	            while(rs.next()){

	                OrderDetails o = new OrderDetails();

	                o.setOrderId(rs.getInt("order_id"));
	                o.setUserId(rs.getInt("user_id"));
	                o.setStatus(rs.getString("status"));
	                o.setOrderDate(rs.getString("order_date"));

	                list.add(o);
	            }

	        } catch(Exception e){
	            e.printStackTrace();
	        }

	        return list;
	    }
	    
	    
	    public boolean approveReturn(int orderId) {

	        boolean f = false;

	        
	        String sql = "UPDATE orders SET return_status=? WHERE order_id=?";
	        try(Connection con = getConnection();

	            PreparedStatement ps = con.prepareStatement(sql)){

	            ps.setString(1, "Approved");
	            ps.setInt(2, orderId);

	            f = ps.executeUpdate() > 0;

	            ps.close();
	            con.close();

	        } catch(Exception e){
	            e.printStackTrace();
	        }

	        return f;
	    }
	   
	    
	    public boolean rejectReturn(int orderId) {

	        boolean f = false;

	       
	        String sql = "UPDATE orders SET return_status=? WHERE order_id=?";
	       try(Connection con = getConnection();

	            PreparedStatement ps = con.prepareStatement(sql)){

	            ps.setString(1, "Rejected");
	            ps.setInt(2, orderId);

	            f = ps.executeUpdate() > 0;

	            ps.close();
	            con.close();

	        } catch(Exception e){
	            e.printStackTrace();
	        }

	        return f;
	    }
	   
	    
	    
	    public List<OrderDetails> getUserReturnOrders(int userId) {

	        List<OrderDetails> list = new ArrayList<>();

	        

	            String sql = "SELECT o.*, p.title, p.category, p.img " +
	                         "FROM orders o " +
	                         "JOIN products p ON o.product_id = p.product_id " +
	                         "WHERE o.user_id=? AND o.return_status IS NOT NULL";
	            try(Connection con = getConnection();

	            PreparedStatement ps = con.prepareStatement(sql)){
	            ps.setInt(1, userId);

	            ResultSet rs = ps.executeQuery();

	            while(rs.next()) {

	                OrderDetails o = new OrderDetails();

	                o.setOrderId(rs.getInt("order_id"));
	                o.setProductId(rs.getInt("product_id"));
	                o.setTitle(rs.getString("title"));
	                o.setCategory(rs.getString("category"));
	                o.setImg(rs.getString("img"));
	                o.setQuantity(rs.getInt("quantity"));
	                o.setPrice(rs.getDouble("price"));
	                o.setStatus(rs.getString("return_status"));

	                list.add(o);
	            }

	        } catch(Exception e){
	            e.printStackTrace();
	        }

	        return list;
	    }
	  
	    
	    public boolean saveAddress(Address a) {

		    try {
		        Connection con = getConnection();

		        String sql = "INSERT INTO saved_address(user_id,name,mobile,address,city,pincode) VALUES(?,?,?,?,?,?)";

		        PreparedStatement ps = con.prepareStatement(sql);

		        ps.setInt(1, a.getUserId());
		        ps.setString(2, a.getName());
		        ps.setString(3, a.getMobile());
		        ps.setString(4, a.getAddress());
		        ps.setString(5, a.getCity());
		        ps.setString(6, a.getPincode());

		        return ps.executeUpdate() > 0;

		    } catch(Exception e){
		        e.printStackTrace();
		    }

		    return false;
		}
	
	    
	    public double getYearSales(int year) {

	        double total = 0;

	        try {
	            Connection con = getConnection();

	            String sql = "SELECT SUM(o.price * o.quantity) " +
	                         "FROM orders o " +
	                         "JOIN products p ON o.product_id = p.product_id " +
	                         "WHERE YEAR(o.order_date)=?";

	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, year);

	            ResultSet rs = ps.executeQuery();

	            if(rs.next()){
	                total = rs.getDouble(1);
	            }

	        } catch(Exception e){
	            e.printStackTrace();
	        }

	        return total;
	    }
	            
	   
	    
	    public double getMonthSales(int month, int year) {

	        double total = 0;

	        try {
	            Connection con = getConnection();

	            String sql = "SELECT SUM(o.price * o.quantity) " +
	                         "FROM orders o " +
	                         "JOIN products p ON o.product_id = p.product_id " +
	                         "WHERE MONTH(o.order_date)=? AND YEAR(o.order_date)=?";

	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, month);
	            ps.setInt(2, year);

	            ResultSet rs = ps.executeQuery();

	            if(rs.next()){
	                total = rs.getDouble(1);
	            }

	        } catch(Exception e){
	            e.printStackTrace();
	        }

	        return total;
	    }
	    
	    
	    
	    public String getTopProduct() {

	        String product = "";

	        try {
	            Connection con = getConnection();

	            String sql = "SELECT p.title, SUM(o.quantity) as total " +
	                         "FROM orders o " +
	                         "JOIN products p ON o.product_id = p.product_id " +
	                         "GROUP BY p.title " +
	                         "ORDER BY total DESC LIMIT 1";

	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            if(rs.next()){
	                product = rs.getString("title");
	            }

	        } catch(Exception e){
	            e.printStackTrace();
	        }

	        return product;
	    }
	    

	    public String getTopCategory() {

	        String category = "";

	        try {
	            Connection con = getConnection();

	            String sql = "SELECT p.category, SUM(o.quantity) as total " +
	                         "FROM orders o " +
	                         "JOIN products p ON o.product_id = p.product_id " +
	                         "GROUP BY p.category " +
	                         "ORDER BY total DESC LIMIT 1";

	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            if(rs.next()){
	                category = rs.getString("category");
	            }

	        } catch(Exception e){
	            e.printStackTrace();
	        }

	        return category;
	    }
	    
	    
	    public Map<String, Integer> getTopProductsList() {

	        Map<String, Integer> map = new LinkedHashMap<>();

	        

	            String sql = "SELECT p.title, SUM(o.quantity) as total " +
	                         "FROM orders o " +
	                         "JOIN products p ON o.product_id = p.product_id " +
	                         "GROUP BY p.title " +
	                         "ORDER BY total DESC LIMIT 5";
	            try(Connection con = getConnection();

	            PreparedStatement ps = con.prepareStatement(sql)){
	            ResultSet rs = ps.executeQuery();

	            while(rs.next()){
	                map.put(rs.getString("title"), rs.getInt("total"));
	            }

	        } catch(Exception e){
	            e.printStackTrace();
	        }

	        return map;
	    }
	}