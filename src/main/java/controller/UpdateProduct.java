package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Products;

import java.io.File;
import java.io.IOException;

import Dao.ProductsDao;

@WebServlet("/UpdateProduct")
@MultipartConfig
public class UpdateProduct extends HttpServlet {

    public UpdateProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Products p = new Products();

        int id = Integer.parseInt(request.getParameter("id"));

        p.setproduct_id(id);
        p.setTitle(request.getParameter("title"));
        p.setCategory(request.getParameter("category"));
        p.setBrand(request.getParameter("brand"));
        p.setDescription(request.getParameter("description"));
        p.setPrice(Double.parseDouble(request.getParameter("price")));
        p.setDiscountPrice(Double.parseDouble(request.getParameter("discountPrice")));
        p.setRating(Double.parseDouble(request.getParameter("rating")));
        p.setStock(Integer.parseInt(request.getParameter("stock")));

        Part filePart = request.getPart("img");

        String fileName = filePart.getSubmittedFileName();

        if(fileName != null && !fileName.isEmpty()) {

            String uploadPath = getServletContext().getRealPath("") + File.separator + "files";

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir();

            filePart.write(uploadPath + File.separator + fileName);

            p.setImg(fileName);

        } else {
            ProductsDao dao = new ProductsDao();
            Products old = dao.getProductById(id);
            p.setImg(old.getImg());
        }

       ProductsDao dao = new ProductsDao();
        dao.updateProduct(p);

        response.sendRedirect("ShowProducts");
    }
}