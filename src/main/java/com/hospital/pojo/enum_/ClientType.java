package com.hospital.pojo.enum_;

/**
 * 客户端类型 枚举
 * 
 * @author wxd
 *
 */
public enum ClientType {
	ATM("ATM", "自助终端"), YD("YD", "12508"), LT("LT", "114");
	private String code;
	private String info;

	ClientType(String code, String info) {
		this.code = code;
		this.info = info;
	}

	public String getCode() {
		return code;
	}

	public String getInfo() {
		return info;
	}

	@Override
	public String toString() {
		return "[" + code + "，" + info + "]";
	}
}
