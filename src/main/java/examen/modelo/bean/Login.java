package examen.modelo.bean;

public class Login {

	private String username;
	private String password;
	private boolean status;
	private boolean admin;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String username, String password, boolean status, boolean admin) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
		this.admin = admin;
	}
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	
}
