package com.aaa.util;

public class Message {
 private int state;
 private String message;
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Message(int state, String message) {
	super();
	this.state = state;
	this.message = message;
}
public Message() {
	super();
}
 
}
