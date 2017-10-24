package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: koubei.marketing.campaign.detail.info.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-08-08 19:55:56
 */
public class KoubeiMarketingCampaignDetailInfoQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7412141246596591812L;

	/** 
	 * 适用门店:门店与门店之间用“,”隔开
	 */
	@ApiField("limit_shops")
	private String limitShops;

	public void setLimitShops(String limitShops) {
		this.limitShops = limitShops;
	}
	public String getLimitShops( ) {
		return this.limitShops;
	}

}
