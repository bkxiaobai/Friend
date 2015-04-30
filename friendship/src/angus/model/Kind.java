package angus.model;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class Kind implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String desc;
	private Set<Album> albums = new HashSet<Album>();
	
	public Kind()
	{
	}

	public Kind(String name, String desc)
	{
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

	public void setAlbums(Set<Album> albums){
		this.albums = albums;
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

	public Set<Album> getAlbums(){
		return this.albums;
	}
	
}
