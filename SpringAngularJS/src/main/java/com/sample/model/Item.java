package com.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

	@JsonProperty
	private int inventory_item_id;
	
	@JsonProperty
	private int organization_id;
	
	@JsonProperty
	private String item_num;
	
	@JsonProperty
	private String description;
	
	@JsonProperty
	private String primary_uom_code;
	
	@JsonProperty
	private String inventory_item_status_code;

	public int getInventory_item_id() {
		return inventory_item_id;
	}

	public void setInventory_item_id(int inventory_item_id) {
		this.inventory_item_id = inventory_item_id;
	}

	public int getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(int organization_id) {
		this.organization_id = organization_id;
	}

	public String getItem_num() {
		return item_num;
	}

	public void setItem_num(String item_num) {
		this.item_num = item_num;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrimary_uom_code() {
		return primary_uom_code;
	}

	public void setPrimary_uom_code(String primary_uom_code) {
		this.primary_uom_code = primary_uom_code;
	}

	public String getInventory_item_status_code() {
		return inventory_item_status_code;
	}

	public void setInventory_item_status_code(String inventory_item_status_code) {
		this.inventory_item_status_code = inventory_item_status_code;
	}

}
