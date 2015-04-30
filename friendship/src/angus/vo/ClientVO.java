package angus.vo;

import java.io.Serializable;

public class ClientVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String pass;
	private boolean sex;
	private String mail;
	private String qq;

	public ClientVO()
	{
	}

	public ClientVO(int id, String name, String pass, boolean sex, String mail, String qq)
	{
		setId(id);
		setName(name);
		setPass(pass);
		setSex(sex);
		setMail(mail);
		setQq(qq);
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

	public void setSex(boolean sex) {
		this.sex = sex; 
	}

	public void setMail(String mail) {
		this.mail = mail; 
	}

	public void setQq(String qq) {
		this.qq = qq; 
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

	public boolean getSex() {
		return (this.sex); 
	}

	public String getMail() {
		return (this.mail); 
	}

	public String getQq() {
		return (this.qq); 
	}


}
