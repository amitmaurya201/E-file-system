package io.jetprocess.masterdata.model;

public class FileDto {
	
	private String category;
	private String subcategory;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public FileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileDto(String category, String subcategory) {
		super();
		this.category = category;
		this.subcategory = subcategory;
	}

}
