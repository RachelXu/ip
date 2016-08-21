package form;

import java.io.Serializable;
import java.util.List;

import dao.model.Account;
import dao.model.ProductCard;
import dao.model.ProductSet;
import util.Contants;

public class ProductCardForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7775954600654251028L;
	private ProductCard productCard;
	private List<ProductCard> productCardSet;
	private Integer currentPage;
	private Integer pageCount;
	private Integer resultCount;
	private Boolean resultFlag;
	
	
	public Boolean getResultFlag() {
		return resultFlag;
	}
	public void setResultFlag(Boolean resultFlag) {
		this.resultFlag = resultFlag;
	}
	public ProductCard getProductCard() {
		return productCard;
	}
	public void setProductCard(ProductCard productCard) {
		this.productCard = productCard;
	}
	public List<ProductCard> getProductCardSet() {
		return productCardSet;
	}
	public void setProductCardSet(List<ProductCard> productCardSet) {
		this.productCardSet = productCardSet;
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


}
