package com.alibaba;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
public class EasyNotesApplicationTests  {

	private static final Logger LOG = LoggerFactory.getLogger(EasyNotesApplicationTests.class);

	@Test
	public void contextLoads() {
	}

	@Test
	public void md5(){
		LOG.info(DigestUtils.md5DigestAsHex("123456".getBytes()).toUpperCase());
	}

}
