package model;

public class OrderDetails {

    private int orderId;
    private int userId;
    private int productId;
    private String title;
    private String category;
    private String img;
    private String returnStatus;
    private int quantity;
    private double price;
    private String address;
    private String paymentType;
    private String orderDate;
    private String status;

    
    
             
    
    public OrderDetails(int orderId, int userId, int productId, String title, String category, String img, int quantity,
			double price, String address, String paymentType, String orderDate, String status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.title = title;
		this.category = category;
		this.img = img;
		this.quantity = quantity;
		this.price = price;
		this.address = address;
		this.paymentType = paymentType;
		this.orderDate = orderDate;
		this.status = status;
	}
    
	public OrderDetails(int userId, int productId, String title, String category, String img, int quantity,
			double price, String address, String paymentType, String orderDate, String status) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.title = title;
		this.category = category;
		this.img = img;
		this.quantity = quantity;
		this.price = price;
		this.address = address;
		this.paymentType = paymentType;
		this.orderDate = orderDate;
		this.status = status;
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
              return orderId; 
             }
    public void setOrderId(int orderId) {
              this.orderId = orderId;
              }

    public int getUserId() {
              return userId; 
             }
    public void setUserId(int userId) {
              this.userId = userId;
              }

    public int getProductId() {
              return productId; 
             }
    public void setProductId(int productId) { 
             this.productId = productId;
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

    public String getImg() {
              return img; 
             }
    public void setImg(String img) {
              this.img = img;
              }

    public int getQuantity() {
           return quantity;
           }
    public void setQuantity(int quantity) {
           this.quantity = quantity;
           }

    public double getPrice() { 
          return price; 
          }
    public void setPrice(double price) { 
          this.price = price; 
          }

    public String getAddress() { 
          return address;
           }
    public void setAddress(String address) { 
          this.address = address;
           }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }
    public String getPaymentType() {
           return paymentType;
           }
    public void setPaymentType(String paymentType) {
           this.paymentType = paymentType;
           }

    public String getOrderDate() {
           return orderDate; 
          }
    public void setOrderDate(String orderDate) { 
          this.orderDate = orderDate; 
          }

    public String getStatus() { 
          return status;
           }
    public void setStatus(String status) {
           this.status = status; 
          }

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", userId=" + userId + ", productId=" + productId + ", title="
				+ title + ", category=" + category + ", img=" + img + ", returnStatus=" + returnStatus + ", quantity="
				+ quantity + ", price=" + price + ", address=" + address + ", paymentType=" + paymentType
				+ ", orderDate=" + orderDate + ", status=" + status + "]";
	}
}	