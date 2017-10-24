package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.marketing.card.activateform.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-03-13 15:28:02
 */
public class AlipayMarketingCardActivateformQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 8743648472183891853L;

	/** 
	 * 表单提交信息各个字段的值JSON数组

默认通用表单字段名称可选值如下：
OPEN_FORM_FIELD_MOBILE – 手机号
OPEN_FORM_FIELD_GENDER – 性别
OPEN_FORM_FIELD_NAME – 姓名
OPEN_FORM_FIELD_BIRTHDAY – 生日
OPEN_FORM_FIELD_IDCARD – 身份证
OPEN_FORM_FIELD_EMAIL – 邮箱
OPEN_FORM_FIELD_ADDRESS – 地址
	 */
	@ApiField("infos")
	private String infos;

	public void setInfos(String infos) {
		this.infos = infos;
	}
	public String getInfos( ) {
		return this.infos;
	}

}
