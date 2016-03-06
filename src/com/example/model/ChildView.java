package com.example.model;

/**
 * ChildView类，瀑布流中的子项
 * @author Xu
 */
public class ChildView {

	private int id;
	private int resourseId;
	private String imgUrl;
	private String text;
	private int imageWidth;
	private int imageHeight;

	public void setId(int id) {
		this.id = id;
	}

	public void setImage(int resourceId) {
		this.resourseId = resourceId;
	}

	public void setImage(int resourceId, int imageWidth, int imageHeight) {
		this.resourseId = resourceId;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}
	
	public void setImageUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public void setImageUrl(String imgUrl, int imageWidth, int imageHeight) {
		this.imgUrl = imgUrl;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public int getImage() {
		return resourseId;
	}

	public String getImageUrl() {
		return imgUrl;
	}

	public String getText() {
		return text;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}
}
