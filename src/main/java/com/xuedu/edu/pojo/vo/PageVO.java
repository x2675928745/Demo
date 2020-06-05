package com.xuedu.edu.pojo.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页- VO
 * @author dwen
 *	2018年11月28日 下午11:44:03
 */
@SuppressWarnings("serial")
public class PageVO<T>  implements Serializable{

	private List<T> list;
	/** 总数 */
	private Integer pageSize=0;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	
	
	
}
