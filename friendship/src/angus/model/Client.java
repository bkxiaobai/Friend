package angus.model;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class Client implements Serializable
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
	private Set<Album> albums = new HashSet<Album>();
	private Set<AlbumWord> albumWords = new HashSet<AlbumWord>();
	private Set<PhotoWord> photoWords = new HashSet<PhotoWord>();
	
	public Client()
	{
	}

	public Client(String name, String pass, boolean sex, String mail, String qq)
	{
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
	
	public void setSex(boolean sex){
		this.sex = sex;
	}

	public void setMail(String mail) {
		this.mail = mail; 
	}

	public void setQq(String qq) {
		this.qq = qq; 
	}

	public void setAlbums(Set<Album> albums){
		this.albums = albums;
	}

	public void setAlbumWords(Set<AlbumWord> albumWords){
		this.albumWords = albumWords;
	}

	public void setPhotoWords(Set<PhotoWord> photoWords){
		this.photoWords = photoWords;
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

	public boolean getSex(){
		return this.sex;
	}

	public String getMail() {
		return (this.mail); 
	}

	public String getQq() {
		return (this.qq); 
	}

	public Set<Album> getAlbums(){
		return this.albums;
	}

	public Set<AlbumWord> getAlbumWords(){
		return this.albumWords;
	}

	public Set<PhotoWord> getPhotoWords(){
		return this.photoWords;
	}


}
