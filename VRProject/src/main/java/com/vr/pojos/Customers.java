package com.vr.pojos;

import java.util.Date;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Customers")
@XmlAccessorType(XmlAccessType.FIELD)

public class Customers {

	int cId;
	int sId;
	String name;
	String address;
	String city;
	String mobile;
	String email;
	Date lastVisit;
	String Status;

	public Customers(int sId, String name, String address, String city, String mobile, String email, Date lastVisit,
			String status) {
		super();
		this.sId = sId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.mobile = mobile;
		this.email = email;
		this.lastVisit = lastVisit;
		Status = status;
	}

	public Customers() {
		super();
	}

	public Customers(int cId, int sId, String name, String address, String city, String mobile, String email,
			Date lastVisit, String status) {
		super();
		this.cId = cId;
		this.sId = sId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.mobile = mobile;
		this.email = email;
		this.lastVisit = lastVisit;
		Status = status;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + cId;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((lastVisit == null) ? 0 : lastVisit.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sId;
		return result;
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
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cId != other.cId)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (lastVisit == null) {
			if (other.lastVisit != null)
				return false;
		} else if (!lastVisit.equals(other.lastVisit))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sId != other.sId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customers [cId=" + cId + ", sId=" + sId + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", mobile=" + mobile + ", email=" + email + ", lastVisit=" + lastVisit + ", Status=" + Status + "]";
	}

}
