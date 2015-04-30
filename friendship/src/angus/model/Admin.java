package angus.model;

import java.io.Serializable;

public class Admin implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String pass;

	public Admin()
	{
	}

	public Admin(String name, String pass)
	{
		setName(name);
		setPass(pass);
	}

	public void setId(int id) {
		this.id = id; 
	}

	public void setName(String name) {
		this.name = name; 
	}

	public void setPass(String pass) {
		this.pass = pass; 
	}


	public int getId() {
		return (this.id); 
	}

	public String getName() {
		return (this.name); 
	}

	public String getPass() {
		return (this.pass); 
	}

}
