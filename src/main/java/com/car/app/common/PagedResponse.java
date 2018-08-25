package com.car.app.common;

public class PagedResponse<T> extends ListResponse<T> {

    private static final long serialVersionUID = 1L;

    private int currentPage;

    private int pageSize;

    private long total;

    private long totalPage;

    public void setPageInfo(long total, int pageIndex, int pageSize) {
        this.setTotal(total);
        this.setPageSize(pageSize);
        this.setCurrentPage(pageIndex);
        if (total == 0) {
            this.setTotalPage(0);
        } else {
            this.setTotalPage( total / pageSize + (total % pageSize == 0 ? 0 : 1));
        }
    }

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

}
