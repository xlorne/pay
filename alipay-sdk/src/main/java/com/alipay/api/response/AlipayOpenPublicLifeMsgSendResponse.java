package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.open.public.life.msg.send response.
 * 
 * @author auto create
 * @since 1.0, 2017-01-11 11:21:11
 */
public class AlipayOpenPublicLifeMsgSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 4549875369342275767L;

	/** 
	 * 生活号消息唯一标识
	 */
	@ApiField("alipay_msg_id")
	private String alipayMsgId;

	public void setAlipayMsgId(String alipayMsgId) {
		this.alipayMsgId = alipayMsgId;
	}
	public String getAlipayMsgId( ) {
		return this.alipayMsgId;
	}

}
