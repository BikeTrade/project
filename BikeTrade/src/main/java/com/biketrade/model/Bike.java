package com.biketrade.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    private Long id;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "*Please Select Brand Name")
	private BrandName brand;
	
	@Column(name = "model_name")
	@NotEmpty(message = "*Please Enter Model Name")
	private String modelName;
	
	@Column(name = "km_driven")
	@NotNull(message = "*Please provid the value" )
	private Integer running;
	 
	
	@Column(name = "reg_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	
	@Column(name = "no_of_owner")
	@NotNull(message = "*Please select no of owners")
	private Integer noOfOwner;
	
	@Column(name = "insurance_status")
	@NotNull(message = "*please select Insurance Status")
	private boolean insurance;
	
	@Column(name = "insurance_exp_date")
	@NotNull(message = "*Please provid Insurance Expiry Date" )
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date iExpDate;
	
	@Column(name = "price")
	@Min(10000)
	private Long price;
	
	@Column(name = "contact_no")
	@NotNull(message = "*Please provid the value" )
	private Long contactNo;
	
	@Column(name = "contact_name")
	@NotEmpty(message = "*Please provide a contact name")
	private String contactName;
	
	@Column(name = "address")
	@NotEmpty(message = "*Please provide a user address")
	private String address;
	
	@Column(name = "bike_location")
	@NotEmpty(message = "*Please provide bike location")
	private String bLocation;

	@Enumerated(EnumType.STRING)
	private BikeStatus status;
	

	@Enumerated(EnumType.STRING)
	private BikeState state;
		
	@Column(name = "sold_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date soldDate;
	
	
	@OneToMany( fetch=FetchType.EAGER ,cascade =CascadeType.ALL)
	private List<ImageModel> bikeImages;
	
	@ManyToOne(fetch=FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	 
	
	
	public Bike() {
	
	}

	public Bike(Long id, BrandName brand, String modelName,
			 Integer running, Date regDate, Integer noOfOwner,
			 boolean insurance, Date iExpDate, Long price,
			 Long contactNo, String contactName, String address,
			 String bLocation,Date soldDate) {
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
		this.soldDate=soldDate;
		
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ImageModel> getBikeImages() {
		return bikeImages;
	}


	public void setBikeImages(List<ImageModel> bikeImages) {
		this.bikeImages = bikeImages;
	}


	public BikeStatus getStatus() {
		return status;
	}

	public void setStatus(BikeStatus status) {
		this.status = status;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public BikeState getState() {
		return state;
	}


	public void setState(BikeState state) {
		this.state = state;
	}

	
	
	public Date getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}

	@Override
	public String toString() {
		return "Bike [id=" + id + ", brand=" + brand + ", modelName=" + modelName + ", running=" + running
				+ ", regDate=" + regDate + ", noOfOwner=" + noOfOwner + ", insurance=" + insurance + ", iExpDate="
				+ iExpDate + ", price=" + price + ", contactNo=" + contactNo + ", contactName=" + contactName
				+ ", address=" + address + ", bLocation=" + bLocation + ", status=" + status + ", state=" +state + ",soldDate=" +soldDate+ "]";
	}



}
