<#assign prj=project["mydogProj"]/>
package ${prj.basePackage}.bean;

import java.io.Serializable;
import java.util.List;

public class PageDataInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
	/**
	 * 当前页
	 */
	private int pageNum;
	/**
	 * 每页多少行
	 */
	private int pageSize;
	/**
	 * 当前页游多少行
	 */
	private int size;
	/**
	 * 总行数
	 */
	private long total;
	/**
	 * 总页数
	 */
	private int pages;
	private List<T> list;

	public PageDataInfo(List<T> data) {
		this.list = data;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}