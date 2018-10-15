package com.vr.pojos;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sessions")
@XmlAccessorType(XmlAccessType.FIELD)

public class Sessions {
	int sessId;
	int cId;
	java.util.Date sDateTime;
	java.util.Date eDateTime;

	public int getSessId() {
		return sessId;
	}

	public void setSessId(int sessId) {
		this.sessId = sessId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public java.util.Date getsDateTime() {
		return sDateTime;
	}

	public void setsDateTime(java.util.Date sDateTime) {
		this.sDateTime = sDateTime;
	}

	public java.util.Date geteDateTime() {
		return eDateTime;
	}

	public void seteDateTime(java.util.Date eDateTime) {
		this.eDateTime = eDateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cId;
		result = prime * result + ((eDateTime == null) ? 0 : eDateTime.hashCode());
		result = prime * result + ((sDateTime == null) ? 0 : sDateTime.hashCode());
		result = prime * result + sessId;
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
		Sessions other = (Sessions) obj;
		if (cId != other.cId)
			return false;
		if (eDateTime == null) {
			if (other.eDateTime != null)
				return false;
		} else if (!eDateTime.equals(other.eDateTime))
			return false;
		if (sDateTime == null) {
			if (other.sDateTime != null)
				return false;
		} else if (!sDateTime.equals(other.sDateTime))
			return false;
		if (sessId != other.sessId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sessions [sessId=" + sessId + ", cId=" + cId + ", sDateTime=" + sDateTime + ", eDateTime=" + eDateTime
				+ "]";
	}

	public Sessions(int sessId, int cId, Date sDateTime, Date eDateTime) {
		super();
		this.sessId = sessId;
		this.cId = cId;
		this.sDateTime = sDateTime;
		this.eDateTime = eDateTime;
	}

	public Sessions(int cId, Date sDateTime, Date eDateTime) {
		super();
		this.cId = cId;
		this.sDateTime = sDateTime;
		this.eDateTime = eDateTime;
	}

	public Sessions() {
		super();
	}
 
}
