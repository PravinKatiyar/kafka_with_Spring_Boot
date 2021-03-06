package com.pravin.apachekafkastorage.broker.message;

public class DiscountMessage {
	private String messageCode;

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public DiscountMessage(String messageCode) {
		super();
		this.messageCode = messageCode;
	}

	public DiscountMessage() {
		super();
	}

	@Override
	public String toString() {
		return "DiscountMessage [messageCode=" + messageCode + "]";
	}
}