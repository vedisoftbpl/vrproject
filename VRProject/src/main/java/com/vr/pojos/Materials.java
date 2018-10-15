package com.vr.pojos;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "materials")
@XmlAccessorType(XmlAccessType.FIELD)

public class Materials {
	int mId;
	int mcId;
	int gId;
	int aId;
	int code;
	String mName;
	String image;
	String image3d;
	String status;
	java.util.Date lastModified;
	int priority;

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public int getMcId() {
		return mcId;
	}

	public void setMcId(int mcId) {
		this.mcId = mcId;
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage3d() {
		return image3d;
	}

	public void setImage3d(String image3d) {
		this.image3d = image3d;
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aId;
		result = prime * result + code;
		result = prime * result + gId;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((image3d == null) ? 0 : image3d.hashCode());
		result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + mId;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + mcId;
		result = prime * result + priority;
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
		Materials other = (Materials) obj;
		if (aId != other.aId)
			return false;
		if (code != other.code)
			return false;
		if (gId != other.gId)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (image3d == null) {
			if (other.image3d != null)
				return false;
		} else if (!image3d.equals(other.image3d))
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (mId != other.mId)
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (mcId != other.mcId)
			return false;
		if (priority != other.priority)
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
		return "Materials [mId=" + mId + ", mcId=" + mcId + ", gId=" + gId + ", aId=" + aId + ", code=" + code
				+ ", mName=" + mName + ", image=" + image + ", image3d=" + image3d + ", status=" + status
				+ ", lastModified=" + lastModified + ", priority=" + priority + "]";
	}

	public Materials(int mId, int mcId, int gId, int aId, int code, String mName, String image, String image3d,
			String status, Date lastModified, int priority) {
		super();
		this.mId = mId;
		this.mcId = mcId;
		this.gId = gId;
		this.aId = aId;
		this.code = code;
		this.mName = mName;
		this.image = image;
		this.image3d = image3d;
		this.status = status;
		this.lastModified = lastModified;
		this.priority = priority;
	}

	public Materials(int mcId, int gId, int aId, int code, String mName, String image, String image3d, String status,
			Date lastModified, int priority) {
		super();
		this.mcId = mcId;
		this.gId = gId;
		this.aId = aId;
		this.code = code;
		this.mName = mName;
		this.image = image;
		this.image3d = image3d;
		this.status = status;
		this.lastModified = lastModified;
		this.priority = priority;
	}

	public Materials() {
		super();
	}

	public Materials(int mcId, int gId, int aId, int code, String mName, String image, String image3d, String status,
			int priority) {
		super();
		this.mcId = mcId;
		this.gId = gId;
		this.aId = aId;
		this.code = code;
		this.mName = mName;
		this.image = image;
		this.image3d = image3d;
		this.status = status;
		this.priority = priority;
	}

}
