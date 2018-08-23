package darian.entity;

public class Define {
	private Integer user_id;
	private String user_name;
	private String user_img;
	private Integer count;

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getUser_id() {

		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getUser_img() {
		return user_img;
	}

	public Integer getCount() {
		return count;
	}
}
