package controller;

import java.io.File;
import java.io.IOException;

import Dao.ProductsDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Products;


@WebServlet("/Add-Products")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, 
    maxFileSize = 1024 * 1024 * 5,     
    maxRequestSize = 1024 * 1024 * 10  
)
public class AddProduct extends HttpServlet {
	
    public AddProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		  
		  
		  request.getRequestDispatcher("Add-Products.jsp").forward(request, response);
		  
	  }
	  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
            String title = request.getParameter("title");
            String category = request.getParameter("category");
            String brand = request.getParameter("brand");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            double discountPrice = Double.parseDouble(request.getParameter("discountPrice"));
            double rating = Double.parseDouble(request.getParameter("rating"));
            int stock = Integer.parseInt(request.getParameter("stock"));

            Part filePart = request.getPart("img");
            String fileName = filePart.getSubmittedFileName();

            String path = "C:\\Users\\LHC\\Documents\\newproject\\E-Com\\src\\main\\webapp\\files\\";
            filePart.write(path + File.separator + fileName);
            

            Products prod = new Products();
            prod.setTitle(title);
            prod.setCategory(category);
            prod.setBrand(brand);
            prod.setDescription(description);
            prod.setPrice(price);
            prod.setDiscountPrice(discountPrice);
            prod.setRating(rating);
            prod.setStock(stock);
            prod.setImg(fileName); 

            ProductsDao dao = new ProductsDao();
           int i = dao.addProduct(prod);

           if(i!=0) {

        	   request.getRequestDispatcher("Index.jsp").forward(request, response);
           }  
        	   else
        	   {
            	   
        	request.getRequestDispatcher("Add-Products.jsp").forward(request, response);

           }
           
           
    }
    }
