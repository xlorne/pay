package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 测试接口
 *
 * @author auto create
 * @since 1.0, 2017-09-25 09:09:01
 */
public class AlipayOpenWangyanTestDeleteModel extends AlipayObject {

	private static final long serialVersionUID = 1218658143978195539L;

	/**
	 * 1
	 */
	@ApiField("aaa")
	private String aaa;

	/**
	 * 2
	 */
	@ApiField("user_name")
	private String userName;

	public String getAaa() {
		return this.aaa;
	}
	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
