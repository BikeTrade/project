package com.biketrade.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bike_interest_users")
public class BikeInterestedUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bike_interested_id")
    private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bike_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Bike bike;

	@OneToOne()
    @JoinColumn(name = "interested_userid")
    private User interestedUser;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private BikeStatus status;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	public User getInterestedUser() {
		return interestedUser;
	}

	public void setInterestedUser(User interestedUser) {
		this.interestedUser = interestedUser;
	}

	public BikeStatus getStatus() {
		return status;
	}

	public void setStatus(BikeStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BikeInterestedUser [id=" + id + ", bike=" + bike + ", interestedUser=" + interestedUser + ", status="
				+ status + "]";
	}
	
	
}
