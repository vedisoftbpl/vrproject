package com.vr.pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Capplication")
@XmlAccessorType(XmlAccessType.FIELD)

public class CApplications {

	int caId;
	int sessId;
	int cId;
	int aId;

	public CApplications(int sessId, int cId, int aId, int aidNo) {
		super();
		this.sessId = sessId;
		this.cId = cId;
		this.aId = aId;
		this.aidNo = aidNo;
	}

	int aidNo;

	public CApplications() {
		super();
	}

	public CApplications(int caId, int sessId, int cId, int aId, int aidNo) {
		super();
		this.caId = caId;
		this.sessId = sessId;
		this.cId = cId;
		this.aId = aId;
		this.aidNo = aidNo;
	}

	public int getCaId() {
		return caId;
	}

	public void setCaId(int caId) {
		this.caId = caId;
	}

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

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public int getAidNo() {
		return aidNo;
	}

	public void setAidNo(int aidNo) {
		this.aidNo = aidNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aId;
		result = prime * result + aidNo;
		result = prime * result + cId;
		result = prime * result + caId;
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
		CApplications other = (CApplications) obj;
		if (aId != other.aId)
			return false;
		if (aidNo != other.aidNo)
			return false;
		if (cId != other.cId)
			return false;
		if (caId != other.caId)
			return false;
		if (sessId != other.sessId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Capplication [caId=" + caId + ", sessId=" + sessId + ", cId=" + cId + ", aId=" + aId + ", aidNo="
				+ aidNo + "]";
	}

}
