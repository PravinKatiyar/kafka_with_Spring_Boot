package com.pravin.apachekafkaorder.request;

public class PromotionRequest {
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

	public PromotionRequest(String promotionCode) {
		super();
		this.promotionCode = promotionCode;
	}

	public PromotionRequest() {
		super();
	}

}
