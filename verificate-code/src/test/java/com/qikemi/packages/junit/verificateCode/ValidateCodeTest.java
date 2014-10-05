package com.qikemi.packages.junit.verificateCode;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.qikemi.packages.verificateCode.ValidateCodeCreator;
import com.qikemi.packages.verificateCode.bean.ValidateCode;

public class ValidateCodeTest {
	
	private Logger log = Logger.getLogger(ValidateCode.class);

	@Test
	public void t1() {
		ValidateCode vCode = new ValidateCode(120,40,5,0);
		try {
			ValidateCodeCreator vcc = new ValidateCodeCreator();
			vcc.createCode(vCode);
			log.info(vCode.getCode());
			String path="H:/"+new Date().getTime()+".png";
			log.info("-->"+path);
			vcc.write(path);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

}
