package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: zhima.customer.certification.certify response.
 * 
 * @author auto create
 * @since 1.0, 2017-05-04 18:48:21
 */
public class ZhimaCustomerCertificationCertifyResponse extends AlipayResponse {

	private static final long serialVersionUID = 6392158525749562797L;

	/** 
	 * 一次认证的唯一标识,在商户调用认证初始化接口的时候获取,认证完成返回的biz_no和请求的一致
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 如果认证没有通过会显示失败原因,如果需要详细的失败原因请使用认证查询接口
	 */
	@ApiField("failed_reason")
	private String failedReason;

	/** 
	 * 认证是否通过,通过为true,不通过为false
	 */
	@ApiField("passed")
	private String passed;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setFailedReason(String failedReason) {
		this.failedReason = failedReason;
	}
	public String getFailedReason( ) {
		return this.failedReason;
	}

	public void setPassed(String passed) {
		this.passed = passed;
	}
	public String getPassed( ) {
		return this.passed;
	}

}
