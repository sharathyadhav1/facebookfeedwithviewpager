package info.androidhive.listviewfeed.data;

import java.util.ArrayList;

public class FeedItem {
	private int id;
	private String name, status, image, profilePic, timeStamp, url,videourl;
	private ArrayList<imageItem> imageArray;
	

	

	public ArrayList<imageItem> getImageArray() {
		return imageArray;
	}

	public void setImageArray(ArrayList<imageItem> imageArray) {
		this.imageArray = imageArray;
	}

	public FeedItem() {
	}

	public FeedItem(int id, String name, String image, String status,
			String profilePic, String timeStamp, String url,String videourl,ArrayList<imageItem> imageArray) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.status = status;
		this.profilePic = profilePic;
		this.timeStamp = timeStamp;
		this.url = url;
		this.videourl = videourl;
		this.imageArray=imageArray;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImge() {
		return image;
	}

	public void setImge(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getVideourl() {
		return videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
}
