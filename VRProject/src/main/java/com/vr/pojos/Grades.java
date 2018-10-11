package com.vr.pojos;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "grades")
@XmlAccessorType(XmlAccessType.FIELD)

public class Grades {
	int gId;
	int mcId;
	String gName;
	String gDetails;
	String status;
	java.util.Date lastModified;

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public int getMcId() {
		return mcId;
	}

	public void setMcId(int mcId) {
		this.mcId = mcId;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgDetails() {
		return gDetails;
	}

	public void setgDetails(String gDetails) {
		this.gDetails = gDetails;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gDetails == null) ? 0 : gDetails.hashCode());
		result = prime * result + gId;
		result = prime * result + ((gName == null) ? 0 : gName.hashCode());
		result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + mcId;
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
		Grades other = (Grades) obj;
		if (gDetails == null) {
			if (other.gDetails != null)
				return false;
		} else if (!gDetails.equals(other.gDetails))
			return false;
		if (gId != other.gId)
			return false;
		if (gName == null) {
			if (other.gName != null)
				return false;
		} else if (!gName.equals(other.gName))
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (mcId != other.mcId)
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
		return "Grades [gId=" + gId + ", mcId=" + mcId + ", gName=" + gName + ", gDetails=" + gDetails + ", status="
				+ status + ", lastModified=" + lastModified + "]";
	}

	public Grades(int gId, int mcId, String gName, String gDetails, String status, Date lastModified) {
		super();
		this.gId = gId;
		this.mcId = mcId;
		this.gName = gName;
		this.gDetails = gDetails;
		this.status = status;
		this.lastModified = lastModified;
	}

	public Grades() {
		super();
	}

	public Grades(int mcId, String gName, String gDetails, String status, Date lastModified) {
		super();
		this.mcId = mcId;
		this.gName = gName;
		this.gDetails = gDetails;
		this.status = status;
		this.lastModified = lastModified;
	}

}
