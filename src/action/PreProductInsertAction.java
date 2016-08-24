package action;

import form.ProductForm;

public class PreProductInsertAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private ProductForm product;
//	private PreProductSearchLogic logic;

	public String execute() throws Exception {
		product = new ProductForm();
		product.setResultFlag(false);
//		logic.doLogic(product);
		return SUCCESS;
	}

	public ProductForm getProduct() {
		return product;
	}

	public void setProduct(ProductForm product) {
		this.product = product;
	}


}
