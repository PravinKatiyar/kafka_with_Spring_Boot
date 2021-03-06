package com.pravin.apachekafkaorder.broker.message;

public class PromotionMessage {
	private String promotionCode;

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	@Override
	public String toString() {
		return "PromotionMessage [promotionCode=" + promotionCode + "]";
	}

	public PromotionMessage(String promotionCode) {
		super();
		this.promotionCode = promotionCode;
	}

	public PromotionMessage() {
		super();
	}

}
