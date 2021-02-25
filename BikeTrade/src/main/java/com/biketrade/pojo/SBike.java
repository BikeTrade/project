package com.biketrade.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "bikedekho")
public class SBike {

	public SBike() {
		super();
	}

	public SBike(Long id, String brand, String modelName, Double running, String regDate, Integer noOfOwner,
			Boolean insurance, String iExpDate, Double price, Long contactNo, String contactName, String address,
			String bLocation) {
		super();
		this.id = id;
		this.brand = brand;
		this.modelName = modelName;
		this.running = running;
		this.regDate = regDate;
		this.noOfOwner = noOfOwner;
		this.insurance = insurance;
		this.iExpDate = iExpDate;
		this.price = price;
		this.contactNo = contactNo;
		this.contactName = contactName;
		this.address = address;
		this.bLocation = bLocation;
	}

	@Id
	 @Indexed(name = "id", type = "long")
	 private Long id;
	
	 @Indexed(name = "brand", type = "string")
	 private String brand;
	
	 @Indexed(name = "modelName", type = "string")
	 private String modelName;
	
	 @Indexed(name = "running", type = "double")
	 private Double running;
	
	 @Indexed(name = "regDate", type = "string")
	 private String regDate;
	
	 @Indexed(name = "noOfOwner", type = "int")
	 private Integer noOfOwner;
	 
	 @Indexed(name = "insurance", type = "boolean")
	 private Boolean insurance; 
 
    @Indexed(name = "iExpDate", type = "string")
	private String iExpDate;
	
    @Indexed(name = "price", type = "double")
	private Double price;
	
    @Indexed(name = "contactNo", type = "long")
	private Long contactNo;
	
    @Indexed(name = "contactName", type = "string")
	private String contactName;
	
    @Indexed(name = "address", type = "string")
	private String address;
	
    @Indexed(name = "bLocation", type = "string")
	private String bLocation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Double getRunning() {
		return running;
	}

	public void setRunning(Double running) {
		this.running = running;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Integer getNoOfOwner() {
		return noOfOwner;
	}

	public void setNoOfOwner(Integer noOfOwner) {
		this.noOfOwner = noOfOwner;
	}

	public Boolean getInsurance() {
		return insurance;
	}

	public void setInsurance(Boolean insurance) {
		this.insurance = insurance;
	}

	public String getiExpDate() {
		return iExpDate;
	}

	public void setiExpDate(String iExpDate) {
		this.iExpDate = iExpDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getbLocation() {
		return bLocation;
	}

	public void setbLocation(String bLocation) {
		this.bLocation = bLocation;
	}
}
