package com.vr.pojos;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "materialcategories")
@XmlAccessorType(XmlAccessType.FIELD)

public class MaterialCategories {
	int mcId;
	int clientId;
	String mcName;
	String mcDetails;
	String mcPic;
	String status;
	java.util.Date lastModified;

	public int getMcId() {
		return mcId;
	}

	public void setMcId(int mcId) {
		this.mcId = mcId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getMcName() {
		return mcName;
	}

	public void setMcName(String mcName) {
		this.mcName = mcName;
	}

	public String getMcDetails() {
		return mcDetails;
	}

	public void setMcDetails(String mcDetails) {
		this.mcDetails = mcDetails;
	}

	public String getMcPic() {
		return mcPic;
	}

	public void setMcPic(String mcPic) {
		this.mcPic = mcPic;
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
		result = prime * result + clientId;
		result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + ((mcDetails == null) ? 0 : mcDetails.hashCode());
		result = prime * result + mcId;
		result = prime * result + ((mcName == null) ? 0 : mcName.hashCode());
		result = prime * result + ((mcPic == null) ? 0 : mcPic.hashCode());
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
		MaterialCategories other = (MaterialCategories) obj;
		if (clientId != other.clientId)
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (mcDetails == null) {
			if (other.mcDetails != null)
				return false;
		} else if (!mcDetails.equals(other.mcDetails))
			return false;
		if (mcId != other.mcId)
			return false;
		if (mcName == null) {
			if (other.mcName != null)
				return false;
		} else if (!mcName.equals(other.mcName))
			return false;
		if (mcPic == null) {
			if (other.mcPic != null)
				return false;
		} else if (!mcPic.equals(other.mcPic))
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
		return "MaterialCategories [mcId=" + mcId + ", clientId=" + clientId + ", mcName=" + mcName + ", mcDetails="
				+ mcDetails + ", mcPic=" + mcPic + ", status=" + status + ", lastModified=" + lastModified + "]";
	}

	public MaterialCategories(int mcId, int clientId, String mcName, String mcDetails, String mcPic, String status,
			Date lastModified) {
		super();
		this.mcId = mcId;
		this.clientId = clientId;
		this.mcName = mcName;
		this.mcDetails = mcDetails;
		this.mcPic = mcPic;
		this.status = status;
		this.lastModified = lastModified;
	}

	public MaterialCategories(int clientId, String mcName, String mcDetails, String mcPic, String status,
			Date lastModified) {
		super();
		this.clientId = clientId;
		this.mcName = mcName;
		this.mcDetails = mcDetails;
		this.mcPic = mcPic;
		this.status = status;
		this.lastModified = lastModified;
	}

	public MaterialCategories() {
		super();
	}

	public MaterialCategories(int clientId, String mcName, String mcDetails, String mcPic, String status) {
		super();
		this.clientId = clientId;
		this.mcName = mcName;
		this.mcDetails = mcDetails;
		this.mcPic = mcPic;
		this.status = status;
	}

}
