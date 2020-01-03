package com.ace.dto.request;

public class UpdateMobileRequest extends DomainRequest {

	private int custId;
	private String mobile;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
