package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 认证初始化
 *
 * @author auto create
 * @since 1.0, 2017-04-24 09:46:23
 */
public class ZhimaCustomerCertificationInitializeModel extends AlipayObject {

	private static final long serialVersionUID = 2829574368414323336L;

	/**
	 * 认证场景码,常用的场景码有:
FACE:人脸认证


签约的协议决定了可以使用那些场景
	 */
	@ApiField("biz_code")
	private String bizCode;

	/**
	 * 扩展业务参数,暂时没有用到,接口预留
	 */
	@ApiField("ext_biz_param")
	private String extBizParam;

	/**
	 * 值为一个json串,必须包含身份类型identity_type,不同的身份类型需要的身份信息不同
当前支持:
身份信息为证件信息identity_type=CERT_INFO:
证件类型为身份证cert_type=IDENTITY_CARD,必要信息cert_name和cert_no

可以选填商户的用户主体principal_id,对应用户在商户端唯一标识,如果商户传了principal_id,后续会为商户提供更强大功能
	 */
	@ApiField("identity_param")
	private String identityParam;

	/**
	 * 芝麻认证产品码,示例值为真实的产品码
	 */
	@ApiField("product_code")
	private String productCode;

	/**
	 * 商户请求的唯一标志，32位长度的字母数字下划线组合。该标识作为对账的关键信息，商户要保证其唯一性.建议:前面几位字符是商户自定义的简称,中间可以使用一段日期,结尾可以使用一个序列
	 */
	@ApiField("transaction_id")
	private String transactionId;

	public String getBizCode() {
		return this.bizCode;
	}
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public String getExtBizParam() {
		return this.extBizParam;
	}
	public void setExtBizParam(String extBizParam) {
		this.extBizParam = extBizParam;
	}

	public String getIdentityParam() {
		return this.identityParam;
	}
	public void setIdentityParam(String identityParam) {
		this.identityParam = identityParam;
	}

	public String getProductCode() {
		return this.productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getTransactionId() {
		return this.transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
