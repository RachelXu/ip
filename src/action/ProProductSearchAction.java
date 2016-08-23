package action;

import form.ProductForm;
import util.CommonUtil;
import util.Contants;

public class ProProductSearchAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 378340882595762250L;
	private ProductForm product;
//	private ProProductSearchLogic logic;
	private String pageString;

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
		ProductForm tempForm = (ProductForm) this.request.getSession()
				.getAttribute("productform");
		product.copy(tempForm);
		product.initView(true);
		return SUCCESS;
		
//		LogicDTO dto = logic.doLogic(media);
//		if (dto.isResult()) {
//			media.initView(true);
//			return SUCCESS;
//		} else {
//			this.addFieldError("field", getText(dto.getErrorCode()));
//			media.initView(false);
//			return INPUT;
//		}
	}

	public ProductForm getMedia() {
		return product;
	}

	public void setMedia(ProductForm media) {
		this.product = media;
	}

	public String getPageString() {
		return pageString;
	}

	public void setPageString(String pageString) {
		this.pageString = pageString;
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
