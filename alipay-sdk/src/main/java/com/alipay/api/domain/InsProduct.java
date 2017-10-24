package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

/**
 * 保险产品
 *
 * @author auto create
 * @since 1.0, 2017-02-13 16:04:45
 */
public class InsProduct extends AlipayObject {

	private static final long serialVersionUID = 6392382467682884473L;

	/**
	 * 险种列表
	 */
	@ApiField("coverages")
	private InsProdCoverage coverages;

	/**
	 * 是否标准产品
	 */
	@ApiField("is_sp")
	private Boolean isSp;

	/**
	 * 保险机构;当产品为标准产品时该值为空
	 */
	@ApiField("merchant")
	private InsMerchant merchant;

	/**
	 * 产品编码;由蚂蚁保险平台分配,商户通过该产品编码投保特定的保险产品
	 */
	@ApiField("prod_code")
	private String prodCode;

	/**
	 * 产品描述
	 */
	@ApiField("prod_desc")
	private String prodDesc;

	/**
	 * 产品名称
	 */
	@ApiField("prod_name")
	private String prodName;

	/**
	 * 产品版本号
	 */
	@ApiField("prod_version")
	private String prodVersion;

	/**
	 * 资源项
	 */
	@ApiListField("resources")
	@ApiField("ins_prod_resource")
	private List<InsProdResource> resources;

	/**
	 * 产品简称
	 */
	@ApiField("short_name")
	private String shortName;

	/**
	 * 标准产品编码;标准产品是不同保险公司同一类型产品的一种抽象
	 */
	@ApiField("sp_code")
	private String spCode;

	/**
	 * 标记列表
	 */
	@ApiListField("tags")
	@ApiField("ins_prod_tag")
	private List<InsProdTag> tags;

	public InsProdCoverage getCoverages() {
		return this.coverages;
	}
	public void setCoverages(InsProdCoverage coverages) {
		this.coverages = coverages;
	}

	public Boolean getIsSp() {
		return this.isSp;
	}
	public void setIsSp(Boolean isSp) {
		this.isSp = isSp;
	}

	public InsMerchant getMerchant() {
		return this.merchant;
	}
	public void setMerchant(InsMerchant merchant) {
		this.merchant = merchant;
	}

	public String getProdCode() {
		return this.prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdDesc() {
		return this.prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getProdName() {
		return this.prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdVersion() {
		return this.prodVersion;
	}
	public void setProdVersion(String prodVersion) {
		this.prodVersion = prodVersion;
	}

	public List<InsProdResource> getResources() {
		return this.resources;
	}
	public void setResources(List<InsProdResource> resources) {
		this.resources = resources;
	}

	public String getShortName() {
		return this.shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getSpCode() {
		return this.spCode;
	}
	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}

	public List<InsProdTag> getTags() {
		return this.tags;
	}
	public void setTags(List<InsProdTag> tags) {
		this.tags = tags;
	}

}
