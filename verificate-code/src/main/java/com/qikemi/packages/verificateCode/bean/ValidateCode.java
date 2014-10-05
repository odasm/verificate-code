package com.qikemi.packages.verificateCode.bean;

/**
 * Validate Code Bean  
 * 
 * Create Date: 2014年10月5日 下午3:01:58
 * Author XieXianbin<a.b@hotmail.com>
 * Source Repositories Address: <https://github.com/qikemi/verificate-code>
 */
public class ValidateCode {
	
	// width 
	private int width = 160;
	// height 
	private int height = 40;
	// code count 
	private int codeCount = 5;
	// 验证码干扰线数
	private int lineCount = 150;
	// 验证码
	private String code = null;
	
	private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N',  'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z',  '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**              constructor                   **/
	public  ValidateCode() {}
	
	/**
	 * 
	 * @param width
	 * @param height
	 */
	public  ValidateCode(int width,int height) {
		this.width=width;
		this.height=height;
	}
	
	/**
	 * 
	 * @param width
	 * @param height
	 * @param codeCount
	 * @param lineCount
	 */
	public  ValidateCode(int width,int height,int codeCount,int lineCount) {
		this.width=width;
		this.height=height;
		this.codeCount=codeCount;
		this.lineCount=lineCount;
	}

	/**              getters and setters                   **/
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getCodeCount() {
		return codeCount;
	}

	public void setCodeCount(int codeCount) {
		this.codeCount = codeCount;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public char[] getCodeSequence() {
		return codeSequence;
	}

	public void setCodeSequence(char[] codeSequence) {
		this.codeSequence = codeSequence;
	}

}
