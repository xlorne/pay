package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.eco.edu.kt.billing.modify response.
 * 
 * @author auto create
 * @since 1.0, 2017-08-03 10:58:19
 */
public class AlipayEcoEduKtBillingModifyResponse extends AlipayResponse {

	private static final long serialVersionUID = 2411357576891169294L;

	/** 
	 * 如果成功，返回Y
	 */
	@ApiField("status")
	private String status;

	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus( ) {
		return this.status;
	}

}
