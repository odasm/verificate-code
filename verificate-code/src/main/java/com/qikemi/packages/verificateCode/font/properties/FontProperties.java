package com.qikemi.packages.verificateCode.font.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * Create Date: 2014年10月5日 下午11:05:20
 * Author XieXianbin<a.b@hotmail.com>
 * Source Repositories Address: <https://github.com/qikemi/open-wechat-sdk>
 */
public class FontProperties {
	private Logger logger = Logger.getLogger(FontProperties.class);
	public static Properties fontProperties;
	public static String FONT_NAME = "FONT_NAME";
	
	public static Properties getFontProperties() {
		if(null == fontProperties){
			FontProperties properties = new FontProperties();
			fontProperties = properties.getProperties();
		}
		return fontProperties;
	}
	
	private Properties getProperties(){
		// 系统发布路径 
//		String systemPath = this.getClass().getResource("/font.properties").getFile(); 
		try {
	        InputStream in = this.getClass().getResourceAsStream("/font.properties");  
			// 加载属性文件
			Properties properties = new Properties();
			properties.load(in);
			in.close();
			return properties;
		} catch (FileNotFoundException e) {
			logger.warn("FileNotFoundException: ->" + e.getMessage());
		} catch (IOException e) {
			logger.warn("IOException: ->" + e.getMessage());
		}
		return null;
	}
}
