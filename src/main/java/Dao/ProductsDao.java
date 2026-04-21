package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Review;
import model.Products;

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

	  public int addProduct(Products p) {

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
	          
	  public List<Products> getAllProducts() {
		    List<Products> list = new ArrayList<>();

		    try (Connection con = getConnection();
		         PreparedStatement ps = con.prepareStatement("SELECT * FROM products")) {

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            Products p = new Products();

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
	  
	  public Products getProductById(int id) {
		    Products p = null;

		    try (Connection con = getConnection();
		         PreparedStatement ps = con.prepareStatement(
		             "SELECT * FROM products WHERE product_id=?")) {

		        ps.setInt(1, id);
		        ResultSet rs = ps.executeQuery();

		        if (rs.next()) {
		            p = new Products();

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
	
	  
	  
	  public int updateProduct(Products p) {
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
	  
	  public List<Products> searchProductsExtended(String key) {

		    List<Products> list = new ArrayList<>();

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

		                Products p = new Products();

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
	                 
	  public List<Products> getElectronicsProducts() {

		    List<Products> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Electronics'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	Products p = new Products();

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
	  
	  
	  
	  public List<Products> getFashionProducts() {

		    List<Products> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Fashion'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	Products p = new Products();

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
	  
	  
	  public List<Products> getBeautyProducts() {

		    List<Products> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Beauty'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	Products p = new Products();

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
	  
	  
	  
	  public List<Products> getHomeProducts() {

		    List<Products> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Home'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            Products p = new Products();

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
	  

	  public List<Products> getLaptopProducts() {

		    List<Products> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Laptops'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            Products p = new Products();

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
	  
	  
	  public List<Products> getMobileProducts() {

		    List<Products> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Mobiles'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            Products p = new Products();

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
	  
	  
	  
	  public List<Products> getSportsProducts() {

		    List<Products> list = new ArrayList<>();

		    try (Connection con = getConnection()) {

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products WHERE category = 'Sports'"
		        );

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            Products p = new Products();

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
	  
	
	  
	  public List<Products> sortByPriceHigh() {

		    List<Products> list = new ArrayList<>();
		    String query = "SELECT * FROM products ORDER BY price DESC";

		    try {
		        Connection con = getConnection();
		        PreparedStatement st = con.prepareStatement(query);
		        ResultSet rs = st.executeQuery();

		        while (rs.next()) {
		        	Products p = new Products();

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
	  
	  
	  
	  public List<Products> sortByRating() {

		    List<Products> list = new ArrayList<>();
		    String query = "SELECT * FROM products ORDER BY rating DESC";

		    try {
		        Connection con = getConnection();
		        PreparedStatement st = con.prepareStatement(query);
		        ResultSet rs = st.executeQuery();

		        while (rs.next()) {
		        	Products p = new Products();

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
	
	   
	  
	  public List<Products> sortByNewest() {

		    List<Products> list = new ArrayList<>();
		    String query = "SELECT * FROM products ORDER BY porduct_id DESC";

		    
		    try(    Connection con = getConnection();
		        PreparedStatement st = con.prepareStatement(query)){
		        ResultSet rs = st.executeQuery();

		        while (rs.next()) {
		        	Products p = new Products();

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
	  
	  public List<Products> sortByPriceLow() {

		    List<Products> list = new ArrayList<>();
		    String query = "SELECT * FROM products ORDER BY price ASC";

		    
		    try(Connection con = getConnection();
		        PreparedStatement st = con.prepareStatement(query)){
		        ResultSet rs = st.executeQuery();

		        while (rs.next()) {

		            Products p = new Products();

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

	  public List<Products> getProductsWithOffset(int offset) {

		    List<Products> list = new ArrayList<>();

		    
		    try(Connection con = getConnection();

		        PreparedStatement ps = con.prepareStatement(
		            "SELECT * FROM products LIMIT 21 OFFSET ?"
		        )){

		        ps.setInt(1, offset);

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {

		            Products p = new Products();

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
	  
	  
	  public boolean addReview(int pid, int uid, int rating, String msg) {
	      boolean f = false;
	      String q = "insert into reviews(product_id, user_id, rating, comment) values(?,?,?,?)";
	      try (Connection con = getConnection(); 
	           PreparedStatement ps = con.prepareStatement(q)) {
	          ps.setInt(1, pid);
	          ps.setInt(2, uid);
	          ps.setInt(3, rating);
	          ps.setString(4, msg);
	          if (ps.executeUpdate() == 1) f = true;
	      } catch (Exception e) { e.printStackTrace(); }
	      return f;
	  }

	  public List<Review> getReviewsByProduct(int pid) {
		    List<Review> list = new ArrayList<>();
		    
		    String q = "SELECT r.*, u.name FROM reviews r JOIN users u ON r.user_id = u.user_id WHERE r.product_id=? ORDER BY r.id DESC";
		    
		    try (Connection con = getConnection(); 
		         PreparedStatement ps = con.prepareStatement(q)) {
		        ps.setInt(1, pid);
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		            Review r = new Review();
		            r.setUserName(rs.getString("name"));
		            r.setRating(rs.getInt("rating"));
		            r.setComment(rs.getString("comment"));
		            list.add(r);
		        }
		    } catch (Exception e) { 
		        e.printStackTrace(); 
		    }
		    return list;
		}
	  
	  public boolean updateProductAverageRating(int pid) {
		    boolean f = false;
		    try (Connection con = getConnection()) {		        String q1 = "SELECT AVG(rating) as avg_rate FROM reviews WHERE product_id=?";
		        PreparedStatement ps1 = con.prepareStatement(q1);
		        ps1.setInt(1, pid);
		        ResultSet rs = ps1.executeQuery();
		        
		        if (rs.next()) {
		            double avg = rs.getDouble("avg_rate");
		            
		            String q2 = "UPDATE products SET rating=? WHERE product_id=?";
		            PreparedStatement ps2 = con.prepareStatement(q2);
		            ps2.setDouble(1, avg);
		            ps2.setInt(2, pid);
		            
		            if (ps2.executeUpdate() == 1) {
		                f = true;
		            }
		        }
		    } catch (Exception e) { e.printStackTrace(); }
		    return f;
		}
	  
	  
}