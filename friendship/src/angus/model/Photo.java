package angus.model;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class Photo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String desc;
	private long times;
	private String picUrl;
	private String bigPicUrl;
	private String smallPicUrl;
	private String upDate;
	private boolean cover;
	private Album album;
	private Set<PhotoWord> photoWords = new HashSet<PhotoWord>();
    
	public Photo()
	{
	}

	public Photo(String title, String desc, long times, String picUrl, String bigPicUrl, String smallPicUrl, 
		String upDate, Album album)
	{
		setTitle(title);
		setDesc(desc);
		setTimes(times);
		setPicUrl(picUrl);
		setBigPicUrl(bigPicUrl);
		setSmallPicUrl(smallPicUrl);
		setUpDate(upDate);
		setAlbum(album);
		setPhotoWords(photoWords);
	}

	public void setId(int id) {
		this.id = id; 
	}

	public void setTitle(String title) {
		this.title = title; 
	}

	public void setDesc(String desc) {
		this.desc = desc; 
	}

	public void setTimes(long times) {
		this.times = times; 
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl; 
	}

	public void setBigPicUrl(String bigPicUrl) {
		this.bigPicUrl = bigPicUrl; 
	}

	public void setSmallPicUrl(String smallPicUrl) {
		this.smallPicUrl = smallPicUrl; 
	}

	public void setUpDate(String upDate) {
		this.upDate = upDate; 
	}

	public void setCover(boolean cover){
		this.cover = cover;
	}

	public void setAlbum(Album album) {
		this.album = album; 
	}

	public void setPhotoWords(Set<PhotoWord> photoWords){
		this.photoWords = photoWords;
	}

	public int getId() {
		return (this.id); 
	}

	public String getTitle() {
		return (this.title); 
	}

	public String getDesc() {
		return (this.desc); 
	}

	public long getTimes() {
		return (this.times); 
	}

	public String getPicUrl() {
		return (this.picUrl); 
	}

	public String getBigPicUrl() {
		return (this.bigPicUrl); 
	}

	public String getSmallPicUrl() {
		return (this.smallPicUrl); 
	}

	public String getUpDate() {
		return (this.upDate); 
	}

	public boolean getCover(){
		return this.cover;
	}

	public Album getAlbum() {
		return (this.album); 
	}

	public Set<PhotoWord> getPhotoWords(){
		return this.photoWords;
	}
}
