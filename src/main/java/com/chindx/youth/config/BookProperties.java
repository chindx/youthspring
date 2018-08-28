package com.chindx.youth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BookProperties {
	
	@Value(value = "${demo.book.name}")
	private String name;
	@Value(value = "${demo.book.writer}")
	private String writer;
	
	public BookProperties() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}	
}
