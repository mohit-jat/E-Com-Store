package model;

public class Products {

    private int product_id;
    private String title;
    private String category;
    private String brand;
    private String description;
    private double price;
    private double discountPrice;
    private double rating;
    private int stock;
    private String img;
	
    
    
    
    public Products(int product_id, String title, String category, String brand, String description, double price,
			double discountPrice, double rating, int stock, String img) {
		super();
		this.product_id = product_id;
		this.title = title;
		this.category = category;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.discountPrice = discountPrice;
		this.rating = rating;
		this.stock = stock;
		this.img = img;
	}




	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Products(String title, String category, String brand, String description, double price, double discountPrice,
			double rating, int stock, String img) {
		super();
		this.title = title;
		this.category = category;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.discountPrice = discountPrice;
		this.rating = rating;
		this.stock = stock;
		this.img = img;
	}
	public int getproduct_id() {
		return product_id;
	}
	public void setproduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	@Override
	public String toString() {
		return "projects [product_id=" + product_id + ", title=" + title + ", category=" + category + ", brand=" + brand
				+ ", description=" + description + ", price=" + price + ", discountPrice=" + discountPrice + ", rating="
				+ rating + ", stock=" + stock + ", img=" + img + "]";
	}

  
    
    
    
}