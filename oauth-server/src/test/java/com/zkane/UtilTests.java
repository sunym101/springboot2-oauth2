package com.zkane;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: 594781919@qq.com
 * @date: 2018/4/24
 */
public class UtilTests {
	@Test
	public void jasyptTest() {
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		// application.yml配置的jasypt.encryptor.password
		encryptor.setPassword("abc123");
		// 对root进行加密操作
		System.out.println(encryptor.encrypt("root"));
		// 进行解密操作
		System.out.println(encryptor.decrypt("ddc3gpYHXk8o2a9TSXh9Yg=="));
	}

	/**
	 * BCryptPasswordEncoder 加密
	 */
	@Test
	public void BCryptPasswordEncoderTest() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String content = "secret";
		String head = "{bcrypt}";
		String encode = encoder.encode(content);
		System.out.println("BCryptPasswordEncoderTest: [" + content + "] => [" + head + encode + "]");
	}
}
