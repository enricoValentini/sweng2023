package sweng2023.sweng;

public class Utente {
	private String username;
	private String password;
	
	public Utente(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void destroy() {
		this.username = null;
		this.password = null;
	}
}
