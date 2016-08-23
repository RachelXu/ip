package form;

import java.io.Serializable;
import java.util.List;

import dao.model.Product;

public class ProductForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7775954600654251028L;
	private List<Product> products;
	private Product product;
	private boolean resultFlag;
	private Integer currentPage;
	private Integer pageCount;
	private Integer resultCount;

	public void initView(boolean resultFlag) {
		this.resultFlag = resultFlag;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getResultCount() {
		return resultCount;
	}

	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}

	public boolean isResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(boolean resultFlag) {
		this.resultFlag = resultFlag;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


}
