package action;

import form.ProductForm;
import logic.LogicDTO;
import logic.ProductSetLogic;
import util.CommonUtil;
import util.Contants;

public class ProProductSearchAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 378340882595762250L;
	private ProductForm product;
	private ProductSetLogic logic;
	private String pageString;
	private String itemId;

	public String execute() throws Exception {
		if (CommonUtil.isEmpty(product.getCurrentPage())
				|| product.getCurrentPage() < 1) {
			product.setCurrentPage(1);
		}
		if (!CommonUtil.isEmpty(pageString)) {
			if (Contants.PRIV.equals(pageString)) {
				product.setCurrentPage(product.getCurrentPage() - 1);
			}
			if (Contants.NEXT.equals(pageString)) {
				product.setCurrentPage(product.getCurrentPage() + 1);
			}
		}
		
		LogicDTO dto = logic.search(product);
		if (dto.isResult()) {
			product.initView(true);
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			product.initView(false);
			return INPUT;
		}
		
	}
	
	public String del() throws Exception {
		if (CommonUtil.isEmpty(product.getCurrentPage())
				|| product.getCurrentPage() < 1) {
			product.setCurrentPage(1);
		}
		if (!CommonUtil.isEmpty(pageString)) {
			if (Contants.PRIV.equals(pageString)) {
				product.setCurrentPage(product.getCurrentPage() - 1);
			}
			if (Contants.NEXT.equals(pageString)) {
				product.setCurrentPage(product.getCurrentPage() + 1);
			}
		}
		
		logic.delete(itemId);
		LogicDTO dto = logic.search(product);
		if (dto.isResult()) {
			product.initView(true);
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			product.initView(false);
			return INPUT;
		}
		
	}

	public String update() {
		System.out.println("update :" + itemId);
		
		return SUCCESS;
	}
	
	public ProductForm getProduct() {
		return product;
	}

	public void setProduct(ProductForm product) {
		this.product = product;
	}

	public ProductSetLogic getLogic() {
		return logic;
	}

	public void setLogic(ProductSetLogic logic) {
		this.logic = logic;
	}

	public String getPageString() {
		return pageString;
	}

	public void setPageString(String pageString) {
		this.pageString = pageString;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}





//	public void validate() {
//		super.validate();
//		if (!CommonUtil.isEmpty(media.getYear1())
//				&& !CommonUtil.isNumber(media.getYear1())) {
//			this.addFieldError("field", getText(Contants.E028));
//		}
//		if (!CommonUtil.isEmpty(media.getYear2())
//				&& !CommonUtil.isNumber(media.getYear2())) {
//			this.addFieldError("field", getText(Contants.E028));
//		}
//		MediaForm tempForm = (MediaForm) this.request.getSession()
//				.getAttribute("mediaform");
//		media.copy(tempForm);
//	}


}
