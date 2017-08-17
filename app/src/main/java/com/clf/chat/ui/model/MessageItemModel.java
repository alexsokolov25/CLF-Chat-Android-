package com.clf.chat.ui.model;

public class MessageItemModel {
	
	String avatar_link;
	String subject;
	String time;
	String message;
	String group_ids;

	public String getAvatar_link() {
		return avatar_link;
	}

	public void setAvatar_link(String avatar_link) {
		this.avatar_link = avatar_link;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getGroup_ids() {
		return group_ids;
	}

	public void setGroup_ids(String group_ids) {
		this.group_ids = group_ids;
	}
}
