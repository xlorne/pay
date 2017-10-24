package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.marketing.campaign.discount.budget.append response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-08 12:53:50
 */
public class AlipayMarketingCampaignDiscountBudgetAppendResponse extends AlipayResponse {

	private static final long serialVersionUID = 4338274293144115841L;

	/** 
	 * 预算ID
	 */
	@ApiField("budget_id")
	private String budgetId;

	public void setBudgetId(String budgetId) {
		this.budgetId = budgetId;
	}
	public String getBudgetId( ) {
		return this.budgetId;
	}

}
