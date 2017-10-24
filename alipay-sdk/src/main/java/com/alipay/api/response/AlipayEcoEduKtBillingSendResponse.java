package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.eco.edu.kt.billing.send response.
 * 
 * @author auto create
 * @since 1.0, 2017-08-03 10:58:34
 */
public class AlipayEcoEduKtBillingSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 7877993541534815235L;

	/** 
	 * 支付宝－中小学－教育缴费的账单号
	 */
	@ApiField("order_no")
	private String orderNo;

	/** 
	 * 支付宝-中小学-教育缴费生成的学生唯一编号
	 */
	@ApiField("student_no")
	private String studentNo;

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderNo( ) {
		return this.orderNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentNo( ) {
		return this.studentNo;
	}

}
