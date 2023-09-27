package sweng2023.sweng;

import java.io.Serializable;

public class Utente implements Serializable{
	private String email;
	private String password;
	
	public Utente(String username, String password) {
		this.email = username;
		this.password = password;
	}
	
	public void destroy() {
		this.email= null;
		this.password = null;
	}
	
	// Getter for the email property
    public String getEmail() {
        return this.email;
    }

    // Setter for the email property
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
}
