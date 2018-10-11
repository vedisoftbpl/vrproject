package com.vr.pojos;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Cmaterials")
@XmlAccessorType(XmlAccessType.FIELD)
public class CMaterials {

	int cmId;
	int caId;
	int mId;

	public CMaterials() {
		super();
	}

	public CMaterials(int cmId, int caId, int mId) {
		super();
		this.cmId = cmId;
		this.caId = caId;
		this.mId = mId;
	}

	public CMaterials(int caId, int mId) {
		super();
		this.caId = caId;
		this.mId = mId;
	}

	public int getCmId() {
		return cmId;
	}

	public void setCmId(int cmId) {
		this.cmId = cmId;
	}

	public int getCaId() {
		return caId;
	}

	public void setCaId(int caId) {
		this.caId = caId;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + caId;
		result = prime * result + cmId;
		result = prime * result + mId;
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
		CMaterials other = (CMaterials) obj;
		if (caId != other.caId)
			return false;
		if (cmId != other.cmId)
			return false;
		if (mId != other.mId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cmaterials [cmId=" + cmId + ", caId=" + caId + ", mId=" + mId + "]";
	}

}
