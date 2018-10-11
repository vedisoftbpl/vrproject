package com.vr.pojos;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "matapp")
@XmlAccessorType(XmlAccessType.FIELD)


public class MatApp {
int maId;
int mId;
int aId;
public int getMaId() {
	return maId;
}
public void setMaId(int maId) {
	this.maId = maId;
}
public int getmId() {
	return mId;
}
public void setmId(int mId) {
	this.mId = mId;
}
public int getaId() {
	return aId;
}
public void setaId(int aId) {
	this.aId = aId;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + aId;
	result = prime * result + mId;
	result = prime * result + maId;
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
	MatApp other = (MatApp) obj;
	if (aId != other.aId)
		return false;
	if (mId != other.mId)
		return false;
	if (maId != other.maId)
		return false;
	return true;
}
@Override
public String toString() {
	return "MatApp [maId=" + maId + ", mId=" + mId + ", aId=" + aId + "]";
}
public MatApp(int maId, int mId, int aId) {
	super();
	this.maId = maId;
	this.mId = mId;
	this.aId = aId;
}
public MatApp() {
	super();
}
public MatApp(int mId, int aId) {
	super();
	this.mId = mId;
	this.aId = aId;
}


}
