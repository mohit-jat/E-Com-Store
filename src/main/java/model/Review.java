package model;

	
	public class Review {
	    private int userId;
	    private String userName; 
	    private int rating;
	    private String comment;
		public Review() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Review(int userId, String userName, int rating, String comment) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.rating = rating;
			this.comment = comment;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		@Override
		public String toString() {
			return "Review [userId=" + userId + ", userName=" + userName + ", rating=" + rating + ", comment=" + comment
					+ "]";
		}

	
	
	}

					
