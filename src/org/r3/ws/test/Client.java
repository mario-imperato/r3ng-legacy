package org.r3.ws.test;

import org.bson.types.ObjectId;
import org.r3.db.utils.ObjectID_Serializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;



public class Client {
	
	private ObjectId id;
	private Integer studentid;
	
	@JsonSerialize(using=ObjectID_Serializer.class) 
	public ObjectId getId() {
		if(id == null){
			return id = new ObjectId();
		}
		return id;
	}
	
	@JsonSerialize(using=ObjectID_Serializer.class) 
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public Integer getStudentid() {
		return studentid;
	}
 
	public void setStudentid(Integer name) {
		this.studentid = name;
	}
 
	public Client(ObjectId anOid, Integer aStudentId)
	{
		setId(anOid);
		setStudentid(aStudentId);
	}
}
