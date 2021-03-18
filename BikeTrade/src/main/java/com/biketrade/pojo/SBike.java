package com.biketrade.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.biketrade.model.Bike;

@SolrDocument(collection = "biketrade")
public class SBike {
	 @Id
	 @Indexed(name = "id", type = "int")
	 private Long id;
	
	 @Indexed(name = "brand", type = "string")
	 private String brand;
	
	 @Indexed(name = "modelName", type = "string")
	 private String modelName;
	
	 @Indexed(name = "running", type = "integer")
	 private Integer running;
	
	 @Indexed(name = "regDate", type = "string")
	 private String regDate;
	
	 @Indexed(name = "noOfOwner", type = "int")
	 private Integer noOfOwner;
	 
	 @Indexed(name = "insurance", type = "boolean")
	 private Boolean insurance; 
 
    @Indexed(name = "iExpDate", type = "string")
	private String iExpDate;
	
    @Indexed(name = "price", type = "long")
	private Long price;
    
    @Indexed(name = "kmRange", type = "string")
  	private String kmRange;
    
    @Indexed(name = "priceRange", type = "string")
  	private String priceRange;
    
    @Indexed(name = "contactNo", type = "long")
	private Long contactNo;
	
    @Indexed(name = "contactName", type = "string")
	private String contactName;
	
    @Indexed(name = "address", type = "string")
	private String address;
	
    @Indexed(name = "bLocation", type = "string")
	private String bLocation;
    
    @Indexed(name="frontImg", type="string")
    private String frontImg;
    
    @Indexed(name="backImg", type="string")
    private String backImg;
    
    @Indexed(name="leftImg", type="string")
    private String leftImg;
    
    @Indexed(name="rightImg", type="string")
    private String rightImg;
    
    @Indexed(name="frontImgType", type="string")
    private String frontImgType;
    
    @Indexed(name="backImgType", type="string")
    private String backImgType;
    
    @Indexed(name="leftImgType", type="string")
    private String leftImgType;
    
    @Indexed(name="rightImgType", type="string")
    private String rightImgType;

    //Constructor
    public SBike() {
		super();
	}
    
    public SBike(Long id) {
	  this.id=id;
	}
 
    public SBike(Long id, String brand, String modelName, Integer running, String regDate, Integer noOfOwner,
			Boolean insurance, String iExpDate, Long price, Long contactNo, String contactName, String address,
			String bLocation) {
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
	
	String getFormattedDate(Date date){
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    return formatter.format(date);
	}
	
	public SBike(Bike bike) {
		this.id = bike.getId();
		this.brand = bike.getBrand().toString();
		this.modelName = bike.getModelName();
		this.running = bike.getRunning();
		this.regDate = getFormattedDate(bike.getRegDate());
		this.noOfOwner = bike.getNoOfOwner();
		this.insurance = bike.isInsurance();
		this.iExpDate = getFormattedDate(bike.getiExpDate());
		this.price = bike.getPrice();
		this.contactNo = bike.getContactNo();
		this.contactName = bike.getContactName();
		this.address = bike.getAddress();
		this.bLocation = bike.getbLocation();
		
        try {
        	byte[] frontImg = Base64.encodeBase64(bike.getBikeImages().get(0).getPicByte());
			this.frontImg=new String(frontImg, "UTF-8");
			this.frontImgType = bike.getBikeImages().get(0).getType();
        	}
        catch (Exception e) {
				this.frontImg= StringUtils.EMPTY;
				this.frontImgType = StringUtils.EMPTY;
			}
		
		try {	
			byte[] backImg = Base64.encodeBase64(bike.getBikeImages().get(1).getPicByte());
			this.backImg=new String(backImg, "UTF-8");
			this.backImgType = bike.getBikeImages().get(1).getType();
			}
		catch (Exception e) {
			this.backImg= StringUtils.EMPTY;
			this.backImgType = StringUtils.EMPTY;
			}
			
		try {	
			byte[] leftImg = Base64.encodeBase64(bike.getBikeImages().get(2).getPicByte());
			this.leftImg=new String(leftImg, "UTF-8");
			this.leftImgType = bike.getBikeImages().get(2).getType();
			}
		catch (Exception e) {
			this.leftImg= StringUtils.EMPTY;
			this.leftImgType = StringUtils.EMPTY;
			}
		try {	
			byte[] rightImg = Base64.encodeBase64(bike.getBikeImages().get(3).getPicByte());
			this.rightImg=new String(rightImg, "UTF-8");
			this.rightImgType = bike.getBikeImages().get(3).getType();			
			} 
		catch (Exception  e) {			 
			this.rightImg= StringUtils.EMPTY;
			this.rightImgType = StringUtils.EMPTY;
		}        
        this.kmRange = getKmRangeFacet(running);
        this.priceRange = getPriceRangeFacet(price);
	}
	
	private String getPriceRangeFacet(Long price){
		if(price <= 20000)
			return "1_to_20000";
		else if(price > 20000 && price <= 50000)
			return "20000_to_50000";
		else if(price > 50000 && price <= 75000)
			return "50000_to_75000";
		else
			return "75000_more";
	}
	
	
	private String getKmRangeFacet(Integer running){
		if(running <= 5000)
			return "1_to_5000";
		else if(running > 5000 && running <= 25000)
			return "5000_to_25000";
		else if(running > 25000 && running <= 50000)
			return "25000_to_50000";
		else
			return "50000_more";
	}
	

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

 	public Integer getRunning() {
		return running;
	}

	public void setRunning(Integer running) {
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

	public String getFrontImg() {
		return frontImg;
	}

	public void setFrontImg(String frontImg) {
		this.frontImg = frontImg;
	}

	public String getBackImg() {
		return backImg;
	}

	public void setBackImg(String backImg) {
		this.backImg = backImg;
	}

	public String getLeftImg() {
		return leftImg;
	}

	public void setLeftImg(String leftImg) {
		this.leftImg = leftImg;
	}

	public String getRightImg() {
		return rightImg;
	}

	public void setRightImg(String rightImg) {
		this.rightImg = rightImg;
	}

	public String getFrontImgType() {
		return frontImgType;
	}

	public void setFrontImgType(String frontImgType) {
		this.frontImgType = frontImgType;
	}

	public String getBackImgType() {
		return backImgType;
	}

	public void setBackImgType(String backImgType) {
		this.backImgType = backImgType;
	}

	public String getLeftImgType() {
		return leftImgType;
	}

	public void setLeftImgType(String leftImgType) {
		this.leftImgType = leftImgType;
	}

	public String getRightImgType() {
		return rightImgType;
	}

	public void setRightImgType(String rightImgType) {
		this.rightImgType = rightImgType;
	}
	
	public String getKmRange() {
		return kmRange;
	}

	public void setKmRange(String kmRange) {
		this.kmRange = kmRange;
	}

	public String getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	@Override
	public String toString() {
		return "SBike [id=" + id + ", brand=" + brand + ", modelName=" + modelName + ", price=" + price + "]";
	}	
}
