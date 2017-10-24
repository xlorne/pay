package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 菜品诊断类型列表对象
 *
 * @author auto create
 * @since 1.0, 2017-10-11 09:56:07
 */
public class ItemDiagnoseType extends AlipayObject {

	private static final long serialVersionUID = 4466166829282729771L;

	/**
	 * 类型
	 */
	@ApiField("item_diagnose")
	private String itemDiagnose;

	/**
	 * 对类型的描述
	 */
	@ApiField("item_diagnose_desc")
	private String itemDiagnoseDesc;

	public String getItemDiagnose() {
		return this.itemDiagnose;
	}
	public void setItemDiagnose(String itemDiagnose) {
		this.itemDiagnose = itemDiagnose;
	}

	public String getItemDiagnoseDesc() {
		return this.itemDiagnoseDesc;
	}
	public void setItemDiagnoseDesc(String itemDiagnoseDesc) {
		this.itemDiagnoseDesc = itemDiagnoseDesc;
	}

}
