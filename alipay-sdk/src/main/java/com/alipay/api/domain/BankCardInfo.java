package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 银行卡信息
 *
 * @author auto create
 * @since 1.0, 2017-06-14 19:53:52
 */
public class BankCardInfo extends AlipayObject {

	private static final long serialVersionUID = 8821438857772125987L;

	/**
	 * 银行卡持卡人姓名
	 */
	@ApiField("card_name")
	private String cardName;

	/**
	 * 银行卡号
	 */
	@ApiField("card_no")
	private String cardNo;

	public String getCardName() {
		return this.cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNo() {
		return this.cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
