package angus.model;

import java.io.Serializable;

public class PhotoWord implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String content;
	private String addDate;
	private Photo photo;
	private Client client;

	public PhotoWord()
	{
	}

	public PhotoWord(String title, String content, String addDate, Photo photo, Client client)
	{
		setTitle(title);
		setContent(content);
		setAddDate(addDate);
		setPhoto(photo);
		setClient(client);
	}

	public void setId(int id) {
		this.id = id; 
	}

	public void setTitle(String title) {
		this.title = title; 
	}

	public void setContent(String content) {
		this.content = content; 
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate; 
	}

	public void setPhoto(Photo photo) {
		this.photo = photo; 
	}

	public void setClient(Client client) {
		this.client = client; 
	}

	public int getId() {
		return (this.id); 
	}

	public String getTitle() {
		return (this.title); 
	}

	public String getContent() {
		return (this.content); 
	}

	public String getAddDate() {
		return (this.addDate); 
	}

	public Photo getPhoto() {
		return (this.photo); 
	}

	public Client getClient() {
		return (this.client); 
	}
}
