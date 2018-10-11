package com.vr.pojos;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Clientusers")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientUsers {

	int cuId;
	int clientId;
	String email;
	String password;
	String person;
	String designation;
	String status;

	public ClientUsers() {
		super();
	}

	public ClientUsers(int clientId, String email, String password, String person, String designation, String status) {
		super();
		this.clientId = clientId;
		this.email = email;
		this.password = password;
		this.person = person;
		this.designation = designation;
		this.status = status;
	}

	public ClientUsers(int cuId, int clientId, String email, String password, String person, String designation,
			String status) {
		super();
		this.cuId = cuId;
		this.clientId = clientId;
		this.email = email;
		this.password = password;
		this.person = person;
		this.designation = designation;
		this.status = status;
	}

	public int getCuId() {
		return cuId;
	}

	public void setCuId(int cuId) {
		this.cuId = cuId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clientId;
		result = prime * result + cuId;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ClientUsers other = (ClientUsers) obj;
		if (clientId != other.clientId)
			return false;
		if (cuId != other.cuId)
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Clientusers [cuId=" + cuId + ", clientId=" + clientId + ", email=" + email + ", password=" + password
				+ ", person=" + person + ", designation=" + designation + ", status=" + status + "]";
	}

}
