
package Dao;

import java.sql.*;
import java.util.*;
import model.Products;

public class CartDao {

    public void addToCart(int userId, int productId) {

        try (Connection con = ProductsDao.getConnection()) {

            String check = "SELECT * FROM cart WHERE user_id=? AND product_id=?";
            PreparedStatement ps1 = con.prepareStatement(check);
            ps1.setInt(1, userId);
            ps1.setInt(2, productId);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                String update = "UPDATE cart SET quantity = quantity + 1 WHERE user_id=? AND product_id=?";
                PreparedStatement ps2 = con.prepareStatement(update);
                ps2.setInt(1, userId);
                ps2.setInt(2, productId);
                ps2.executeUpdate();
            } else {
                String insert = "INSERT INTO cart(user_id, product_id, quantity) VALUES(?,?,1)";
                PreparedStatement ps3 = con.prepareStatement(insert);
                ps3.setInt(1, userId);
                ps3.setInt(2, productId);
                ps3.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Products> getCartItems(int userId) {

        List<Products> list = new ArrayList<>();

        try (Connection con = ProductsDao.getConnection()) {

            String query = "SELECT p.*, c.quantity FROM cart c " +
                           "JOIN products p ON c.product_id = p.product_id " +
                           "WHERE c.user_id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Products p = new Products();

                p.setproduct_id(rs.getInt("product_id"));
                p.setTitle(rs.getString("title"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setDiscountPrice(rs.getDouble("discountPrice"));
                p.setImg(rs.getString("img"));

                p.setStock(rs.getInt("quantity"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

 
    
    public void removeFromCart(int userId, int productId) {

        try (Connection con = ProductsDao.getConnection()) {

            String query = "DELETE FROM cart WHERE user_id=? AND product_id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, userId);
            ps.setInt(2, productId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

