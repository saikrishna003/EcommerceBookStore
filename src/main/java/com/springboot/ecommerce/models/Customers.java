package com.springboot.ecommerce.models;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Customers")
public class Customers {
	
	@Id
	@Field("_id")
	private ObjectId _id;
	
	@Field("customer_id")
	@Indexed(unique = true)
	@NotNull
	private Integer customerId;
	
	@NotBlank
	private String name;
	private String address;
	private String city;
	private String state;
	private Integer zipcode;
	private String country;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + ", country=" + country + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, city, country, customerId, name, state, zipcode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customers other = (Customers) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(name, other.name) && Objects.equals(state, other.state)
				&& Objects.equals(zipcode, other.zipcode);
	}
	
	
	
}
