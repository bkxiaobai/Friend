package angus.vo;

import java.io.Serializable;

public class KindVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String desc;

	public KindVO()
	{	
	}

	public KindVO(int id, String name, String desc)
	{
		setId(id);
		setName(name);
		setDesc(desc);
	}

	public void setId(int id) {
		this.id = id; 
	}

	public void setName(String name) {
		this.name = name; 
	}

	public void setDesc(String desc) {
		this.desc = desc; 
	}

	public int getId() {
		return (this.id); 
	}

	public String getName() {
		return (this.name); 
	}

	public String getDesc() {
		return (this.desc); 
	}
}
