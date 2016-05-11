package com.sample.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Customer {
	@JsonProperty
	private int customer_id;

	@JsonProperty
	private String customer_num;

	@JsonProperty
	private String customer_name;

	@JsonProperty
	private String customer_status;

	@JsonProperty
	private String customer_type;

	@JsonProperty
	private String customer_class_code;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(String customer_num) {
		this.customer_num = customer_num;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_status() {
		return customer_status;
	}

	public void setCustomer_status(String customer_status) {
		this.customer_status = customer_status;
	}

	public String getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}

	public String getCustomer_class_code() {
		return customer_class_code;
	}

	public void setCustomer_class_code(String customer_class_code) {
		this.customer_class_code = customer_class_code;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_num=" + customer_num + ", customer_name="
				+ customer_name + ", customer_status=" + customer_status + ", customer_type=" + customer_type
				+ ", customer_class_code=" + customer_class_code + "]";
	}

}
