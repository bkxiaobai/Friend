package angus.model;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class Album implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String desc;
	private String createDate;
	private long times;
	private Client client;
	private Kind kind;
	private Set<AlbumWord> albumWords = new HashSet<AlbumWord>();
	private Set<Photo> photos = new HashSet<Photo>();

	public Album()
	{
	}

	public Album(String name, String desc, String createDate, long times, Client client, Kind kind)
	{
		setName(name);
		setDesc(desc);
		setCreateDate(createDate);
		setTimes(times);
		setClient(client);
		setKind(kind);
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

	public void setCreateDate(String createDate) {
		this.createDate = createDate; 
	}

	public void setTimes(long times) {
		this.times = times; 
	}

	public void setClient(Client client) {
		this.client = client; 
	}

	public void setKind(Kind kind) {
		this.kind = kind; 
	}

	public void setAlbumWords(Set<AlbumWord> albumWords){
		this.albumWords = albumWords;
	}

	public void setPhotos(Set<Photo> photos){
		this.photos = photos;
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

	public String getCreateDate() {
		return (this.createDate); 
	}

	public long getTimes() {
		return (this.times); 
	}

	public Client getClient() {
		return (this.client); 
	}

	public Kind getKind() {
		return (this.kind); 
	}

	public Set<AlbumWord> getAlbumWords(){
		return this.albumWords;
	}

	public Set<Photo> getPhotos(){
		return this.photos;
	}
}
