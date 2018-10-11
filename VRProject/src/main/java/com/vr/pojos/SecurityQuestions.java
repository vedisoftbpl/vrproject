package com.vr.pojos;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "securityquestions")
@XmlAccessorType(XmlAccessType.FIELD)


public class SecurityQuestions {
int sqId;
String question;
String answer;
int cuId;
public int getSqId() {
	return sqId;
}
public void setSqId(int sqId) {
	this.sqId = sqId;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public int getCuId() {
	return cuId;
}
public void setCuId(int cuId) {
	this.cuId = cuId;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((answer == null) ? 0 : answer.hashCode());
	result = prime * result + cuId;
	result = prime * result + ((question == null) ? 0 : question.hashCode());
	result = prime * result + sqId;
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
	SecurityQuestions other = (SecurityQuestions) obj;
	if (answer == null) {
		if (other.answer != null)
			return false;
	} else if (!answer.equals(other.answer))
		return false;
	if (cuId != other.cuId)
		return false;
	if (question == null) {
		if (other.question != null)
			return false;
	} else if (!question.equals(other.question))
		return false;
	if (sqId != other.sqId)
		return false;
	return true;
}
@Override
public String toString() {
	return "SecurityQuestions [sqId=" + sqId + ", question=" + question + ", answer=" + answer + ", cuId=" + cuId + "]";
}
public SecurityQuestions(int sqId, String question, String answer, int cuId) {
	super();
	this.sqId = sqId;
	this.question = question;
	this.answer = answer;
	this.cuId = cuId;
}
public SecurityQuestions(String question, String answer, int cuId) {
	super();
	this.question = question;
	this.answer = answer;
	this.cuId = cuId;
}
public SecurityQuestions() {
	super();
}

}
