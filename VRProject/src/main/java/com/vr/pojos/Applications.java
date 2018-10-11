package com.vr.pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Application")
@XmlAccessorType(XmlAccessType.FIELD)

public class Applications {

	int aId;
	String aName;

	public Applications() {
		super();
	}

	public Applications(int aId) {
		super();
		this.aId = aId;
	}

	public Applications(int aId, String aName) {
		super();
		this.aId = aId;
		this.aName = aName;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aId;
		result = prime * result + ((aName == null) ? 0 : aName.hashCode());
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
		Applications other = (Applications) obj;
		if (aId != other.aId)
			return false;
		if (aName == null) {
			if (other.aName != null)
				return false;
		} else if (!aName.equals(other.aName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Application [aId=" + aId + ", aName=" + aName + "]";
	}

}
