package com.qikemi.packages.verificateCode.font;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.qikemi.packages.verificateCode.font.properties.FontProperties;

/**
 * 从字体文件获取字体 Create Date: 2014年10月5日 下午11:02:47 Author
 * XieXianbin<a.b@hotmail.com> Source Repositories Address:
 * <https://github.com/qikemi/verificate-code>
 */
public class TtfFont {

	/**
	 * @param fontFileName
	 * @param fontSize
	 * @return
	 */
	private Font loadFont(String fontFileName, float fontSize) {
		try {
			 File file = new File(fontFileName);
			// FileInputStream in = new FileInputStream(file);
			// Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, in);
			// Font dynamicFontPt = dynamicFont.deriveFont(fontSize);
			// in.close();
			 FileInputStream fileInputStream = new FileInputStream(file);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
			Font dynamicFontPt = Font.createFont(Font.TRUETYPE_FONT, bufferedInputStream);
			dynamicFontPt = dynamicFontPt.deriveFont(Font.BOLD, fontSize);
			return dynamicFontPt;
		} catch (Exception e) {
			e.printStackTrace();
			return new Font("Arial", Font.PLAIN, (int) fontSize);
		}
	}

	/**
	 * 从ttf文件获取字体
	 * 
	 * @return
	 */
	public Font getFont(Integer fontSize) {
		Properties p = FontProperties.getFontProperties();
		String fontName = (String) p.get(FontProperties.FONT_NAME);
		String resourcesPath = this.getClass().getResource("/" + fontName)
				.getFile();
		Font font = loadFont(resourcesPath, fontSize);
		return font;
	}
}
