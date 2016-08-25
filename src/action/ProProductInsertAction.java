package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import form.ProductForm;
import logic.LogicDTO;
import logic.ProProductInsertLogic;
import util.CommonUtil;
import util.Contants;

public class ProProductInsertAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 378340882595762250L;
	private ProductForm product;
	private ProProductInsertLogic logic;
	private String pageString;
	private boolean showError;

	public String execute() throws Exception {
		ProductForm tempForm = (ProductForm) this.request.getSession()
				.getAttribute("productform");
		product.copy(tempForm);
		// 上传单个链接的情况
		LogicDTO dto = null;
		dto = logic.doLogic(product);
		return SUCCESS;
	}

	public void validate() {
		super.validate();
//		if (!CommonUtil.isEmpty(product.)
//				&& !CommonUtil.isNumber(product.getYear())) {
//			this.addFieldError("field", getText(Contants.E028));
//		}
//		ProductForm tempForm = (MediaForm) this.request.getSession()
//				.getAttribute("mediaform");
//		product.copy(tempForm);
	}

	public ProductForm getProduct() {
		return product;
	}

	public void setProduct(ProductForm product) {
		this.product = product;
	}

	public ProProductInsertLogic getLogic() {
		return logic;
	}

	public void setLogic(ProProductInsertLogic logic) {
		this.logic = logic;
	}

	public String getPageString() {
		return pageString;
	}

	public void setPageString(String pageString) {
		this.pageString = pageString;
	}

	public boolean isShowError() {
		return showError;
	}

	public void setShowError(boolean showError) {
		this.showError = showError;
	}



}
