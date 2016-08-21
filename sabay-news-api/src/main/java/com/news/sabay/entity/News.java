package com.news.sabay.entity;

public class News{
	private String image;
	private String link;
	private String text;
	private String title;
	private String date;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "News [image=" + image + ", link=" + link + ", text=" + text + ", title=" + title + ", date=" + date
				+ "]";
	}	
}