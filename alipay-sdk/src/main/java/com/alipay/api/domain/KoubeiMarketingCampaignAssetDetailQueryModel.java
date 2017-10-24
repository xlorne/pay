package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 查询资产的详情信息
 *
 * @author auto create
 * @since 1.0, 2017-08-08 19:56:04
 */
public class KoubeiMarketingCampaignAssetDetailQueryModel extends AlipayObject {

	private static final long serialVersionUID = 1122516316476491829L;

	/**
	 * 用户资产id，配合《用户口碑优惠资产查询接口》使用，返回券资产信息列表中的asset_id则为传递的入参值。
	 */
	@ApiField("asset_id")
	private String assetId;

	/**
	 * 资产类型(VOUCHER:券资产)  配合《用户口碑优惠资产查询接口》使用，返回券资产详情信息，则对应VOUCHER类型
	 */
	@ApiField("asset_type")
	private String assetType;

	public String getAssetId() {
		return this.assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getAssetType() {
		return this.assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

}
