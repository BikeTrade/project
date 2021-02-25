package com.biketrade.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bike_for_sale")
public class Bike {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bike_id")
    private int id;
	
	@Column(name = "brand")
	@NotEmpty(message = "*Please Select Brand Name")
	private String brand;
	
	@Column(name = "model_name")
	@NotEmpty(message = "*Please Enter Model Name")
	private String modelName;
	
	@Column(name = "km_driven")
	@NotEmpty(message = "*Please Enter Running in Km")
	private double running;
	
	@Column(name = "reg_date")
	@NotEmpty(message = "*Please provide a Registration Date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	
	@Column(name = "no_of_owner")
	@NotEmpty(message = "*Please select no of owners")
	private int noOfOwner;
	
	@Column(name = "insurance_status")
	@NotEmpty(message = "*please select Insurance Status")
	private boolean insurance;
	
	@Column(name = "insurance_exp_date")
	@NotEmpty(message = "*Please provid Insurance Expiry Date" )
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date iExpDate;
	
	@Column(name = "price")
	@NotEmpty(message = "*Please provide price")
	private double price;
	
	@Column(name = "contact_no")
	@NotEmpty(message = "*Please provide a contact number")
	private long contactNo;
	
	@Column(name = "contact_name")
	@NotEmpty(message = "*Please provide a contact name")
	private String contactName;
	
	@Column(name = "address")
	@NotEmpty(message = "*Please provide a user address")
	private String address;
	
	@Column(name = "bike_location")
	@NotEmpty(message = "*Please provide bike location")
	private String bLocation;

	//Create non-parameterized constructor	
	public Bike() {
	
	}

	//Create Parameterized constructor
	public Bike(@NotEmpty(message = "*Please Select Brand Name") String brand,
			@NotEmpty(message = "*Please Enter Model Name") String modelName,
			@NotEmpty(message = "*Please Enter Running in Km") double running,
			@NotEmpty(message = "*Please provide a Registration Date") Date regDate,
			@NotEmpty(message = "*Please select no of owners") int noOfOwner,
			@NotEmpty(message = "*please select Insurance Status") boolean insurance,
			@NotEmpty(message = "*Please provid Insurance Expiry Date") Date iExpDate,
			@NotEmpty(message = "*Please provide price") double price,
			@NotEmpty(message = "*Please provide a contact number") long contactNo,
			@NotEmpty(message = "*Please provide a contact name") String contactName,
			@NotEmpty(message = "*Please provide a user address") String address,
			@NotEmpty(message = "*Please provide bike location") String bLocation) {
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
	}

	//Add all setters and getters
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

	public double getRunning() {
		return running;
	}

	public void setRunning(double running) {
		this.running = running;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getNoOfOwner() {
		return noOfOwner;
	}

	public void setNoOfOwner(int noOfOwner) {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
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

	//add toString Method
	@Override
	public String toString() {
		return "Bike [brand=" + brand + ", modelName=" + modelName + ", running=" + running + ", regDate=" + regDate
				+ ", noOfOwner=" + noOfOwner + ", insurance=" + insurance + ", iExpDate=" + iExpDate + ", price="
				+ price + ", contactNo=" + contactNo + ", contactName=" + contactName + ", address=" + address
				+ ", bLocation=" + bLocation + "]";
	}
	
	
}
