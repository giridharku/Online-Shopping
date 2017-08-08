package net.giri.onlineshoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    @Column(name = "image_url")
    private String imgUrl;

    @Override
    public String toString() {
	return "Category [name=" + name + ", id=" + id + ", description=" + description + ", imgUrl=" + imgUrl
		+ ", active=" + active + "]";
    }

    @Column(name = "is_active")
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
