package com.pravin.apachekafkastorage.broker.message;

public class PromotionMessage {
	private String messageCode;

	public PromotionMessage(String messageCode) {
		super();
		this.messageCode = messageCode;
	}

	public PromotionMessage() {
		super();
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}


	@Override
	public String toString() {
		return "PromotionMessage [messageCode=" + messageCode + "]";
	}
	

}
