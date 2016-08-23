package action;

import form.ProductForm;

public class PreProductSearchAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private ProductForm product;

	public String execute() throws Exception {
		product = new ProductForm();
		product.initView(false);
		return SUCCESS;
	}

	public ProductForm getProduct() {
		return product;
	}

	public void setProduct(ProductForm product) {
		this.product = product;
	}


}
