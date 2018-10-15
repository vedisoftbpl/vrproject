package com.vr.pojos;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sites")
@XmlAccessorType(XmlAccessType.FIELD)

public class Sites {
	int sId;
	int instId;
	java.util.Date instDate;
	java.util.Date validUpto;
	String siteName;
	String address;
	String city;
	String state;
	String country;
	String pin;
	String website;
	String email;
	String contactPerson;
	String designation;
	String mobile;
	String contactEmail;
	String status;
	java.util.Date lastModified;
	java.util.Date lastSyn;

	public Sites(int sId, int instId, String siteName, String address, String city, String state, String country,
			String pin, String website, String email, String contactPerson, String designation, String mobile,
			String contactEmail, String status) {
		super();
		this.sId = sId;
		this.instId = instId;
		this.siteName = siteName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
		this.website = website;
		this.email = email;
		this.contactPerson = contactPerson;
		this.designation = designation;
		this.mobile = mobile;
		this.contactEmail = contactEmail;
		this.status = status;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getInstId() {
		return instId;
	}

	public void setInstId(int instId) {
		this.instId = instId;
	}

	public java.util.Date getInstDate() {
		return instDate;
	}

	public void setInstDate(java.util.Date instDate) {
		this.instDate = instDate;
	}

	public java.util.Date getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(java.util.Date validUpto) {
		this.validUpto = validUpto;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.util.Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(java.util.Date lastModified) {
		this.lastModified = lastModified;
	}

	public java.util.Date getLastSyn() {
		return lastSyn;
	}

	public void setLastSyn(java.util.Date lastSyn) {
		this.lastSyn = lastSyn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((contactEmail == null) ? 0 : contactEmail.hashCode());
		result = prime * result + ((contactPerson == null) ? 0 : contactPerson.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((instDate == null) ? 0 : instDate.hashCode());
		result = prime * result + instId;
		result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + ((lastSyn == null) ? 0 : lastSyn.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((pin == null) ? 0 : pin.hashCode());
		result = prime * result + sId;
		result = prime * result + ((siteName == null) ? 0 : siteName.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((validUpto == null) ? 0 : validUpto.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
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
		Sites other = (Sites) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (contactEmail == null) {
			if (other.contactEmail != null)
				return false;
		} else if (!contactEmail.equals(other.contactEmail))
			return false;
		if (contactPerson == null) {
			if (other.contactPerson != null)
				return false;
		} else if (!contactPerson.equals(other.contactPerson))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (instDate == null) {
			if (other.instDate != null)
				return false;
		} else if (!instDate.equals(other.instDate))
			return false;
		if (instId != other.instId)
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (lastSyn == null) {
			if (other.lastSyn != null)
				return false;
		} else if (!lastSyn.equals(other.lastSyn))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (pin == null) {
			if (other.pin != null)
				return false;
		} else if (!pin.equals(other.pin))
			return false;
		if (sId != other.sId)
			return false;
		if (siteName == null) {
			if (other.siteName != null)
				return false;
		} else if (!siteName.equals(other.siteName))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (validUpto == null) {
			if (other.validUpto != null)
				return false;
		} else if (!validUpto.equals(other.validUpto))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sites [sId=" + sId + ", instId=" + instId + ", instDate=" + instDate + ", validUpto=" + validUpto
				+ ", siteName=" + siteName + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pin=" + pin + ", website=" + website + ", email=" + email
				+ ", contactPerson=" + contactPerson + ", designation=" + designation + ", mobile=" + mobile
				+ ", contactEmail=" + contactEmail + ", status=" + status + ", lastModified=" + lastModified
				+ ", lastSyn=" + lastSyn + "]";
	}

	public Sites(int sId, int instId, Date instDate, Date validUpto, String siteName, String address, String city,
			String state, String country, String pin, String website, String email, String contactPerson,
			String designation, String mobile, String contactEmail, String status, Date lastModified, Date lastSyn) {
		super();
		this.sId = sId;
		this.instId = instId;
		this.instDate = instDate;
		this.validUpto = validUpto;
		this.siteName = siteName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
		this.website = website;
		this.email = email;
		this.contactPerson = contactPerson;
		this.designation = designation;
		this.mobile = mobile;
		this.contactEmail = contactEmail;
		this.status = status;
		this.lastModified = lastModified;
		this.lastSyn = lastSyn;
	}

	public Sites() {
		super();
	}

	public Sites(int instId, Date instDate, Date validUpto, String siteName, String address, String city, String state,
			String country, String pin, String website, String email, String contactPerson, String designation,
			String mobile, String contactEmail, String status, Date lastModified, Date lastSyn) {
		super();
		this.instId = instId;
		this.instDate = instDate;
		this.validUpto = validUpto;
		this.siteName = siteName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
		this.website = website;
		this.email = email;
		this.contactPerson = contactPerson;
		this.designation = designation;
		this.mobile = mobile;
		this.contactEmail = contactEmail;
		this.status = status;
		this.lastModified = lastModified;
		this.lastSyn = lastSyn;
	}

	public Sites(int instId, Date instDate, Date validUpto, String siteName, String address, String city, String state,
			String country, String pin, String website, String email, String contactPerson, String designation,
			String mobile, String contactEmail, String status) {
		super();
		this.instId = instId;
		this.instDate = instDate;
		this.validUpto = validUpto;
		this.siteName = siteName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
		this.website = website;
		this.email = email;
		this.contactPerson = contactPerson;
		this.designation = designation;
		this.mobile = mobile;
		this.contactEmail = contactEmail;
		this.status = status;
	}

	public Sites(int instId, String siteName, String address, String city, String state, String country, String pin,
			String website, String email, String contactPerson, String designation, String mobile, String contactEmail,
			String status) {
		super();
		this.instId = instId;
		this.siteName = siteName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
		this.website = website;
		this.email = email;
		this.contactPerson = contactPerson;
		this.designation = designation;
		this.mobile = mobile;
		this.contactEmail = contactEmail;
		this.status = status;
	}
	

}
