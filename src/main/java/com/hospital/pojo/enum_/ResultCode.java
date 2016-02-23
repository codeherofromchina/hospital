package com.hospital.pojo.enum_;

/**
 * 返回是否操作成功标识枚举
 * 
 * @author wxd
 *
 */
public enum ResultCode {
	SUCCESS(true, "0"), FAILURE(false, "1");
	private boolean result;
	private String code;

	ResultCode(boolean result, String code) {
		this.result = result;
		this.code = code;
	}

	public static ResultCode getResultCode(String code) {
		return ResultCode.SUCCESS.code.equals(code) ? ResultCode.SUCCESS : ResultCode.FAILURE;
	}

	public boolean getResult() {
		return this.result;
	}

}
