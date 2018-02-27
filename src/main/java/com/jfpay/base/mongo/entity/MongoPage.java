package com.jfpay.base.mongo.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * mongodb 分页page
 * @author herion
 * 2015-1-20下午5:27:14
 */
public class MongoPage<E>{
	@JsonProperty("total")
	private long total;
	private List<E> list;
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	
	
}
