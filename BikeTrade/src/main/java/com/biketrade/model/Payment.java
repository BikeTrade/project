package com.biketrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String payeeName;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_mode")
	private PaymentMode mode;

	private double amount;

	@OneToOne
	@JoinColumn(name = "bike_id")
	private Bike bike;

	public Payment() {

		// TODO Auto-generated constructor stub
	}

	public Payment(Integer id, String payeeName, PaymentMode mode, double amount) {
		super();
		this.id = id;
		this.payeeName = payeeName;
		this.mode = mode;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", payeeName=" + payeeName + "mode=" + mode + ", " + "amount=" + amount + "]";
	}

}
