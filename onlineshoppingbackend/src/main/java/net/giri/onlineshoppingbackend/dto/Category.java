package net.giri.onlineshoppingbackend.dto;

public class Category {

    private String name;
    private long id;

    private String description;

    private String imgUrl;

    private boolean active = true;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getImgUrl() {
	return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
	this.imgUrl = imgUrl;
    }

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

}
