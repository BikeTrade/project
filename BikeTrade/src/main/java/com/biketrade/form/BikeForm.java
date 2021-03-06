package com.biketrade.form;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.biketrade.model.BikeStatus;
import com.biketrade.model.BrandName;

public class BikeForm {
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "*Please Select Brand Name")
	private BrandName brand;
	
	@NotEmpty(message = "*Please Enter Model Name")
	private String modelName;
	
	@NotNull(message = "*Please provid the value" )
	private Integer running;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	
	@NotNull(message = "*Please select no of owners")
	private Integer noOfOwner;
	
	@NotNull(message = "*please select Insurance Status")
	private boolean insurance;
	
	@NotNull(message = "*Please provid Insurance Expiry Date" )
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date iExpDate;
	
	@Min(10000)
	private Long price;
	
	@NotNull(message = "*Please provid the contact number" )
	private Long contactNo;
	
	@NotEmpty(message = "*Please provide a contact name")
	private String contactName;

	@NotEmpty(message = "*Please provide a user address")
	private String address;
	
	@NotEmpty(message = "*Please provide bike location")
	private String bLocation;
	
	@Enumerated(EnumType.STRING)
	private BikeStatus status;

	private MultipartFile leftImage;
	private MultipartFile rightImage;
	private MultipartFile frontImage;
	private MultipartFile backImage;

	public BikeForm() {
		super();
	}

	public BikeForm(BrandName brand, String modelName, Integer running, Date regDate, Integer noOfOwner, boolean insurance,
			Date iExpDate, Long price, Long contactNo, String contactName, String address, String bLocation,
			MultipartFile leftImage, MultipartFile rightImage, MultipartFile frontImage, MultipartFile backImage) {
		super();
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
		this.leftImage = leftImage;
		this.rightImage = rightImage;
		this.frontImage = frontImage;
		this.backImage = backImage;
	}

	public void setBrand( BrandName brand) {
		this.brand = brand;
	}
	public  BrandName getBrand() {
		return brand;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Integer getRunning() {
		return running;
	}

	public void setRunning(Integer running) {
		this.running = running;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Integer getNoOfOwner() {
		return noOfOwner;
	}

	public void setNoOfOwner(Integer noOfOwner) {
		this.noOfOwner = noOfOwner;
	}

	public boolean isInsurance() {
		return insurance;
	}

	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}

	public Date getiExpDate() {
		return iExpDate;
	}

	public void setiExpDate(Date iExpDate) {
		this.iExpDate = iExpDate;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
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

	public MultipartFile getLeftImage() {
		return leftImage;
	}

	public void setLeftImage(MultipartFile leftImage) {
		this.leftImage = leftImage;
	}

	public MultipartFile getRightImage() {
		return rightImage;
	}

	public void setRightImage(MultipartFile rightImage) {
		this.rightImage = rightImage;
	}

	public MultipartFile getFrontImage() {
		return frontImage;
	}

	public void setFrontImage(MultipartFile frontImage) {
		this.frontImage = frontImage;
	}

	public MultipartFile getBackImage() {
		return backImage;
	}

	public void setBackImage(MultipartFile backImage) {
		this.backImage = backImage;
	}

	
	public BikeStatus getStatus() {
		return status;
	}

	public void setStatus(BikeStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BikeForm [brand=" + brand + ", modelName=" + modelName + ", running=" + running + ", regDate=" + regDate
				+ ", noOfOwner=" + noOfOwner + ", insurance=" + insurance + ", iExpDate=" + iExpDate + ", price="
				+ price + ", contactNo=" + contactNo + ", contactName=" + contactName + ", address=" + address
				+ ", bLocation=" + bLocation + ", leftImage=" + leftImage + ", rightImage=" + rightImage
				+ ", frontImage=" + frontImage + ", backImage=" + backImage + "]";
	}
	
	
	
}
