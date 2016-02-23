package com.hospital.pojo.enum_;

/**
 * �ͻ������� ö��
 * 
 * @author wxd
 *
 */
public enum ClientType {
	ATM("ATM", "�����ն�"), YD("YD", "12508"), LT("LT", "114");
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
		return "[" + code + "��" + info + "]";
	}
}
