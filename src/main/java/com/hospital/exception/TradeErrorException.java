package com.hospital.exception;

/**
 * 交易失败异常类
 * @author wxd
 *
 */
public class TradeErrorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String errorContent;

	public TradeErrorException(String resultContent) {
		super(resultContent);
		this.errorContent = resultContent;
	}

	public String getErrorContent() {
		return this.errorContent;
	}
}
