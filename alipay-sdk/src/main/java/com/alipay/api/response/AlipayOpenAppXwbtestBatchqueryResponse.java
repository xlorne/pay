package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.open.app.xwbtest.batchquery response.
 * 
 * @author auto create
 * @since 1.0, 2017-08-25 13:03:36
 */
public class AlipayOpenAppXwbtestBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4555915632317513534L;

	/** 
	 * 1
	 */
	@ApiField("xwb")
	private String xwb;

	public void setXwb(String xwb) {
		this.xwb = xwb;
	}
	public String getXwb( ) {
		return this.xwb;
	}

}
