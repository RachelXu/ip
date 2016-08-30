package action;

import dao.model.ProductSet;
import form.ProductForm;
import logic.LogicDTO;
import logic.ProductLogic;
import util.CommonUtil;
import util.Contants;
import util.Contents;

public class ProductAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 378340882595762250L;
	private ProductForm product;
	private ProductLogic logic;
	private String pageString;
	private String itemId;
	private String opType;

	public String preSearch() throws Exception {
		product = new ProductForm();
		product.initView(false);
		opType = Contents.OP_TYPE_SEARCH;
		return SUCCESS;
	}
	
	public String search() throws Exception {
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

	
	public String preAdd() throws Exception {
		product = new ProductForm();
		product.setResultFlag(false);
		opType = Contents.OP_TYPE_ADD;
		return SUCCESS;
	}
	
	public String add() {
		if (CommonUtil.isEmpty(product.getProduct().getProductId()) || CommonUtil.isEmpty(product.getProduct().getProductName())) {
			this.addFieldError("field", getText(Contants.E001));
			
			return INPUT;
		}
		logic.create(product);
		this.addActionMessage("Add Success");
		
		return SUCCESS;
	}

	public String preUpdate() {
		
		ProductSet productItem = logic.getProductSetById(itemId);
		if (productItem != null) {
			product.setProduct(productItem);
			opType = Contents.OP_TYPE_UPDATE;
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	
	public String update() {
		if (CommonUtil.isEmpty(product.getProduct().getProductName())) {
			this.addFieldError("field", getText(Contants.E001));
			
			return INPUT;
		}
		logic.update(product);
		this.addActionMessage("Update Success");
		
		return SUCCESS;
		
	}
	
	public ProductForm getProduct() {
		return product;
	}

	public void setProduct(ProductForm product) {
		this.product = product;
	}

	public ProductLogic getLogic() {
		return logic;
	}

	public void setLogic(ProductLogic logic) {
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

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
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
