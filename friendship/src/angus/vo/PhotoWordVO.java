package angus.vo;

import java.io.Serializable;

public class PhotoWordVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String content;
	private String addDate;
	private int photoId;
	private String photoTitle;
	private int cId;
	private String cName;
	
	public PhotoWordVO()
	{
	}

	public PhotoWordVO(int id, String title, String content, String addDate, int photoId, 
		String photoTitle, int cId, String cName)
	{
		setId(id);
		setTitle(title);
		setContent(content);
		setAddDate(addDate);
		setPhotoId(photoId);
		setPhotoTitle(photoTitle);
		setCId(cId);
		setCName(cName);
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public void setAddDate(String addDate)
	{
		this.addDate = addDate;
	}

	public void setPhotoId(int photoId)
	{
		this.photoId = photoId;
	}

	public void setPhotoTitle(String photoTitle)
	{
		this.photoTitle = photoTitle;
	}

	public void setCId(int cId)
	{
		this.cId = cId;
	}

	public void setCName(String cName)
	{
		this.cName = cName;
	}

	public int getId()
	{
		return this.id;
	}

	public String getTitle()
	{
		return this.title;
	}

	public String getContent()
	{
		return this.content;
	}

	public String getAddDate()
	{
		return this.addDate;
	}

	public int getPhotoId()
	{
		return this.photoId;
	}

	public String getPhotoTitle()
	{
		return this.photoTitle;
	}

	public int getCId()
	{
		return this.cId;
	}

	public String getCName()
	{
		return this.cName;
	}
}
