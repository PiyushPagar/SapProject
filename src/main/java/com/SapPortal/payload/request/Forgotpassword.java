package com.SapPortal.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Forgotpassword {
	
	  @NotBlank
	    @Size(min = 6, max = 40)
	    private String password;
	  
	  @Size(max = 50)
	    private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
