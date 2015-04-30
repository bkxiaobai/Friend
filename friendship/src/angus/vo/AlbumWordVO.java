package angus.vo;

public class AlbumWordVO {
	
	private int id;
	private String title;
	private String content;
	private String addDate;
	private int albumId;
	private String albumTitle;
	private int cId;
	private String cName;
	
	public AlbumWordVO()
	{
	}

	public AlbumWordVO(int id, String title, String content, String addDate, int albumId, 
		String albumTitle, int cId, String cName)
	{
		setId(id);
		setTitle(title);
		setContent(content);
		setAddDate(addDate);
		setAlbumId(albumId);
		setAlbumTitle(albumTitle);
		setCId(cId);
		setCName(cName);
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public int getCId() {
		return cId;
	}

	public void setCId(int id) {
		cId = id;
	}

	public String getCName() {
		return cName;
	}

	public void setCName(String name) {
		cName = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
