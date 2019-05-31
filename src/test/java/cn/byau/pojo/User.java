package cn.byau.pojo;

public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String createTime;
    private String image;

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private String roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreateTime() {
		return createTime;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", createTime="
				+ createTime + ", image=" + image + ", roleId=" + roleId + "]";
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	

    
}