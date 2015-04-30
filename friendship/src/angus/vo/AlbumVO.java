package angus.vo;

import java.io.Serializable;

public class AlbumVO implements Serializable
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
	private int ownreId;
	private String owner;
	private int kindId;
	private String kindName;
	private int coverId;
	private String coverUrl;

	public AlbumVO()
	{
	}

	public AlbumVO(int id, String name, String desc, String createDate, long times, int ownreId, String owner, 
		int kindId, String kindName, int coverId, String coverUrl)
	{
		setId(id);
		setName(name);
		setDesc(desc);
		setCreateDate(createDate);
		setTimes(times);
		setOwnreId(ownreId);
		setOwner(owner);
		setKindId(kindId);
		setKindName(kindName);
		setCoverId(coverId);
		setCoverUrl(coverUrl);
	}

	public AlbumVO(int id, String name, String desc, String createDate, long times, int ownreId, String owner, 
		int kindId, String kindName)
	{
		setId(id);
		setName(name);
		setDesc(desc);
		setCreateDate(createDate);
		setTimes(times);
		setOwnreId(ownreId);
		setOwner(owner);
		setKindId(kindId);
		setKindName(kindName);
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

	public void setOwnreId(int ownreId) {
		this.ownreId = ownreId; 
	}

	public void setOwner(String owner) {
		this.owner = owner; 
	}

	public void setKindId(int kindId) {
		this.kindId = kindId; 
	}

	public void setKindName(String kindName) {
		this.kindName = kindName; 
	}

	public void setCoverId(int coverId) {
		this.coverId = coverId; 
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl; 
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

	public int getOwnreId() {
		return (this.ownreId); 
	}

	public String getOwner() {
		return (this.owner); 
	}

	public int getKindId() {
		return (this.kindId); 
	}

	public String getKindName() {
		return (this.kindName); 
	}

	public int getCoverId() {
		return (this.coverId); 
	}

	public String getCoverUrl() {
		return (this.coverUrl); 
	}


}
