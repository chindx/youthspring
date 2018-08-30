package com.chindx.youth.config;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * 书属性
 * 
 * @author Administrator
 *
 */
@Component
@ConfigurationProperties(prefix = "demo.book") // 前缀
@Validated // 验证
public class BookComponent {

	/**
	 * 书名
	 */
	@NotEmpty // 不能为空
	@Value("${demo.book.name}")
	private String name;
	/**
	 * 作者
	 */
	@NotNull // 不能为空
	@Value("${demo.book.writer}")
	private String wtring;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWtring() {
		return wtring;
	}

	public void setWtring(String wtring) {
		this.wtring = wtring;
	}

}
