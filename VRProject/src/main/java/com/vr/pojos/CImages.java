package com.vr.pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Cimage")
@XmlAccessorType(XmlAccessType.FIELD)

public class CImages {

	int ciId;
	int caId;
	String image;

	public CImages() {
		super();
	}

	public CImages(int ciId, int caId, String image) {
		super();
		this.ciId = ciId;
		this.caId = caId;
		this.image = image;
	}

	public CImages(int caId, String image) {
		super();
		this.caId = caId;
		this.image = image;
	}

	public int getCiId() {
		return ciId;
	}

	public void setCiId(int ciId) {
		this.ciId = ciId;
	}

	public int getCaId() {
		return caId;
	}

	public void setCaId(int caId) {
		this.caId = caId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + caId;
		result = prime * result + ciId;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
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
		CImages other = (CImages) obj;
		if (caId != other.caId)
			return false;
		if (ciId != other.ciId)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cimage [ciId=" + ciId + ", caId=" + caId + ", image=" + image + "]";
	}

}
