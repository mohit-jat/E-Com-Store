package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.projects;

public class ProductsDao {
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

	  public int addProduct(projects p) {

		    int i = 0;
		    try {

		        Connection con = getConnection();

		        PreparedStatement ps = con.prepareStatement(
		            "INSERT INTO products(title, category, brand, description, price, discountPrice, rating, stock, img) VALUES(?,?,?,?,?,?,?,?,?)"
		        );

		        ps.setString(1, p.getTitle());
		        ps.setString(2, p.getCategory());
		        ps.setString(3, p.getBrand());
		        ps.setString(4, p.getDescription());
		        ps.setDouble(5, p.getPrice());
		        ps.setDouble(6, p.getDiscountPrice());
		        ps.setDouble(7, p.getRating());
		        ps.setInt(8, p.getStock());
		        ps.setString(9, p.getImg());

		        i = ps.executeUpdate();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return i;
		}
	          
	  public List<projects> getAllProducts() {
		    List<projects> list = new ArrayList<>();

		    try (Connection con = getConnection();
		         PreparedStatement ps = con.prepareStatement("SELECT * FROM products")) {

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            projects p = new projects();

		            p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setCategory(rs.getString("category"));
		            p.setBrand(rs.getString("brand"));
		            p.setDescription(rs.getString("description"));
		            p.setPrice(rs.getDouble("price"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));
		            p.setRating(rs.getDouble("rating"));
		            p.setStock(rs.getInt("stock"));
		            p.setImg(rs.getString("img"));

		            list.add(p);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	  
	  public projects getProductById(int id) {
		    projects p = null;

		    try (Connection con = getConnection();
		         PreparedStatement ps = con.prepareStatement(
		             "SELECT * FROM products WHERE product_id=?")) {

		        ps.setInt(1, id);
		        ResultSet rs = ps.executeQuery();

		        if (rs.next()) {
		            p = new projects();

		            p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setCategory(rs.getString("category"));
		            p.setBrand(rs.getString("brand"));
		            p.setDescription(rs.getString("description"));
		            p.setPrice(rs.getDouble("price"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));
		            p.setRating(rs.getDouble("rating"));
		            p.setStock(rs.getInt("stock"));
		            p.setImg(rs.getString("img"));
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return p;
		}
	
	  
	  
	  public int updateProduct(projects p) {
		    int i = 0;

		   
		 try(Connection con = getConnection();

		        PreparedStatement ps = con.prepareStatement(
		            "UPDATE products SET title=?, category=?, brand=?, description=?, price=?, discountPrice=?, rating=?, stock=?, img=? WHERE product_id=?"
		        )){

		        ps.setString(1, p.getTitle());
		        ps.setString(2, p.getCategory());
		        ps.setString(3, p.getBrand());
		        ps.setString(4, p.getDescription());
		        ps.setDouble(5, p.getPrice());
		        ps.setDouble(6, p.getDiscountPrice());
		        ps.setDouble(7, p.getRating());
		        ps.setInt(8, p.getStock());
		        ps.setString(9, p.getImg());
		        ps.setInt(10, p.getproduct_id());

		        i = ps.executeUpdate();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return i;
		}
	
	  
	  
	  public int deleteProduct(int id) {
		    int status = 0;
		    
		      try(Connection con =getConnection();
		        PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE product_id=?")){
		        ps.setInt(1, id);

		        status = ps.executeUpdate();

		         } catch (Exception e) {
		        e.printStackTrace();
		          }
		         return status;
		  }
	  
	  public List<projects> searchProductsExtended(String key) {

		    List<projects> list = new ArrayList<>();

		    String query = "SELECT * FROM products " +
		                   "WHERE title LIKE ? OR category LIKE ? OR brand LIKE ?";

		    try (
		        Connection con = getConnection();
		        PreparedStatement ps = con.prepareStatement(query)
		    ) {

		        String searchKey = "%" + key + "%";

		        ps.setString(1, searchKey);
		        ps.setString(2, searchKey);
		        ps.setString(3, searchKey);

		        try (ResultSet rs = ps.executeQuery()) {

		            while (rs.next()) {

		                projects p = new projects();

		                p.setproduct_id(rs.getInt("product_id"));  
		                p.setTitle(rs.getString("title"));
		                p.setCategory(rs.getString("category"));
		                p.setBrand(rs.getString("brand"));
		                p.setDescription(rs.getString("description"));
		                p.setPrice(rs.getDouble("price"));
		                p.setDiscountPrice(rs.getDouble("discountPrice"));
		                p.setRating(rs.getDouble("rating"));
		                p.setStock(rs.getInt("stock"));
		                p.setImg(rs.getString("img"));

		                list.add(p);
		            }
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	                 
	  public List<projects> getElectronicsProducts() {

		    List<projects> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Electronics'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	projects p = new projects();

		            p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setCategory(rs.getString("category"));
		            p.setBrand(rs.getString("brand"));
		            p.setPrice(rs.getDouble("price"));
		            p.setImg(rs.getString("img"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));
                     p.setRating(rs.getDouble("rating"));
		            list.add(p);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	  
	  
	  
	  public List<projects> getFashionProducts() {

		    List<projects> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Fashion'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	projects p = new projects();

		            p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setCategory(rs.getString("category"));
		            p.setBrand(rs.getString("brand"));
		            p.setPrice(rs.getDouble("price"));
		            p.setImg(rs.getString("img"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));
                    p.setRating(rs.getDouble("rating"));

		            list.add(p);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	  
	  
	  public List<projects> getBeautyProducts() {

		    List<projects> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Beauty'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	projects p = new projects();

		            p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setCategory(rs.getString("category"));
		            p.setBrand(rs.getString("brand"));
		            p.setPrice(rs.getDouble("price"));
		            p.setImg(rs.getString("img"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));
                    p.setRating(rs.getDouble("rating"));

		            list.add(p);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	  
	  
	  
	  public List<projects> getHomeProducts() {

		    List<projects> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Home'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            projects p = new projects();

		            p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setCategory(rs.getString("category"));
		            p.setBrand(rs.getString("brand"));
		            p.setPrice(rs.getDouble("price"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));

		            p.setRating(rs.getDouble("rating"));

		            p.setImg(rs.getString("img"));

		            list.add(p);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	  

	  public List<projects> getLaptopProducts() {

		    List<projects> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Laptops'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            projects p = new projects();

		            p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setCategory(rs.getString("category"));
		            p.setBrand(rs.getString("brand"));
		            p.setPrice(rs.getDouble("price"));
		            p.setImg(rs.getString("img"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));
		            p.setRating(rs.getDouble("rating"));

		            list.add(p);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	  
	  
	  public List<projects> getMobileProducts() {

		    List<projects> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Mobiles'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            projects p = new projects();

		            p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setCategory(rs.getString("category"));
		            p.setBrand(rs.getString("brand"));
		            p.setPrice(rs.getDouble("price"));
		            p.setImg(rs.getString("img"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));
		            p.setRating(rs.getDouble("rating"));

		            list.add(p);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	  
	  
	  
	  public List<projects> getSportsProducts() {

		    List<projects> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Sports'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            projects p = new projects();

		            p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setCategory(rs.getString("category"));
		            p.setBrand(rs.getString("brand"));
		            p.setPrice(rs.getDouble("price"));
		            p.setImg(rs.getString("img"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));
		            p.setRating(rs.getDouble("rating"));

		            list.add(p);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	  
	
	  
	  public List<projects> sortByPriceHigh() {

		    List<projects> list = new ArrayList<>();
		    String query = "SELECT * FROM products ORDER BY price DESC";

		    try {
		        Connection con = getConnection();
		        PreparedStatement st = con.prepareStatement(query);
		        ResultSet rs = st.executeQuery();

		        while (rs.next()) {
		        	projects p = new projects();

		        	p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setPrice(rs.getDouble("price"));
		            p.setImg(rs.getString("img"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));
		            p.setCategory(rs.getString("category"));

		            p.setBrand(rs.getString("brand"));
		            p.setRating(rs.getDouble("rating"));
		            p.setDescription(rs.getString("description"));


		            list.add(p);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	  
	  
	  
	  public List<projects> sortByRating() {

		    List<projects> list = new ArrayList<>();
		    String query = "SELECT * FROM products ORDER BY rating DESC";

		    try {
		        Connection con = getConnection();
		        PreparedStatement st = con.prepareStatement(query);
		        ResultSet rs = st.executeQuery();

		        while (rs.next()) {
		        	projects p = new projects();

		            p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setPrice(rs.getDouble("price"));
		            p.setImg(rs.getString("img"));
		            p.setBrand(rs.getString("brand"));
		            p.setRating(rs.getDouble("rating"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));

		            p.setCategory(rs.getString("category"));

		            p.setDescription(rs.getString("description"));

		            list.add(p);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	
	   
	  
	  public List<projects> sortByNewest() {

		    List<projects> list = new ArrayList<>();
		    String query = "SELECT * FROM products ORDER BY porduct_id DESC";

		    
		    try(    Connection con = getConnection();
		        PreparedStatement st = con.prepareStatement(query)){
		        ResultSet rs = st.executeQuery();

		        while (rs.next()) {
		        	projects p = new projects();

		            p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setPrice(rs.getDouble("price"));
		            p.setImg(rs.getString("img"));
		            p.setBrand(rs.getString("brand"));
		            p.setRating(rs.getDouble("rating"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));
 
		            p.setCategory(rs.getString("category"));

		            p.setDescription(rs.getString("description"));

		            list.add(p);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	  
	  public List<projects> sortByPriceLow() {

		    List<projects> list = new ArrayList<>();
		    String query = "SELECT * FROM products ORDER BY price ASC";

		    
		    try(Connection con = getConnection();
		        PreparedStatement st = con.prepareStatement(query)){
		        ResultSet rs = st.executeQuery();

		        while (rs.next()) {

		            projects p = new projects();

		            p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setPrice(rs.getDouble("price"));
		            p.setImg(rs.getString("img"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));
		            p.setCategory(rs.getString("category"));

		            p.setBrand(rs.getString("brand"));
		            p.setRating(rs.getDouble("rating"));
		            p.setDescription(rs.getString("description"));

		            list.add(p);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}

	  public List<projects> getProductsWithOffset(int offset) {

		    List<projects> list = new ArrayList<>();

		    
		    try(Connection con = getConnection();

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products LIMIT 6 OFFSET ?"
		        )){

		        ps.setInt(1, offset);

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {

		            projects p = new projects();

		            p.setproduct_id(rs.getInt("product_id"));
		            p.setTitle(rs.getString("title"));
		            p.setCategory(rs.getString("category"));
		            p.setBrand(rs.getString("brand"));
		            p.setPrice(rs.getDouble("price"));
		            p.setDiscountPrice(rs.getDouble("discountPrice"));
		            p.setImg(rs.getString("img"));
		            p.setRating(rs.getDouble("rating"));

		            list.add(p);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	
	  
	  
	  public int getTotalProducts(){

		    int count = 0;

		    try(Connection con = getConnection()){

		        String sql = "SELECT COUNT(*) FROM products";
		        PreparedStatement ps = con.prepareStatement(sql);

		        ResultSet rs = ps.executeQuery();

		        if(rs.next()){
		            count = rs.getInt(1);
		        }

		    }catch(Exception e){
		        e.printStackTrace();
		    }

		    return count;
		}																					
	
}