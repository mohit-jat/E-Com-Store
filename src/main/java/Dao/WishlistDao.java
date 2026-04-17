package Dao;


	import java.sql.*;
	import java.util.*;
	import model.projects;

	public class WishlistDao {

	    public void addToWishlist(int userId, int productId) {

	        try (Connection con = ProductsDao.getConnection()) {

	            String query = "INSERT INTO wishlist(user_id, product_id) VALUES(?,?)";
	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setInt(1, userId);
	            ps.setInt(2, productId);

	            ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	  
	    
	    public List<projects> getWishlist(int userId) {

	        List<projects> list = new ArrayList<>();

	        try (Connection con = ProductsDao.getConnection()) {

	            String query = "SELECT p.* FROM wishlist w " +
	                           "JOIN products p ON w.product_id = p.product_id " +
	                           "WHERE w.user_id=?";

	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setInt(1, userId);

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

	    public void removeFromWishlist(int userId, int productId) {

	        try (Connection con = ProductsDao.getConnection()) {

	            String query = "DELETE FROM wishlist WHERE user_id=? AND product_id=?";
	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setInt(1, userId);
	            ps.setInt(2, productId);

	            ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

