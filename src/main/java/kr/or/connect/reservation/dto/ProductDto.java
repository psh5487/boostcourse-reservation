package kr.or.connect.reservation.dto;

import java.util.Date;

public class ProductDto {
	private int id;
	private int category_id;
	private String description;
	private String content;
	private String place_name;
	private String save_file_name;
	
	private String event;
	private Date create_date;
	private Date modify_date;
	private String type;
	
	
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSave_file_name() {
		return save_file_name;
	}
	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}
	
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", category_id=" + category_id + ", description=" + description + ", content="
				+ content + ", place_name=" + place_name + ", save_file_name=" + save_file_name + ", event=" + event
				+ ", create_date=" + create_date + ", modify_date=" + modify_date + ", type=" + type + "]";
	}
	
}
