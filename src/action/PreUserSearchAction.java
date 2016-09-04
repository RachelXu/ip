package action;

import java.util.ArrayList;
import java.util.List;

import dao.model.ProductSet;
import form.AccountForm;
import logic.AccountLogic;
import logic.LogicDTO;
import logic.ProductLogic;
import util.CommonUtil;
import util.Contants;

public class PreUserSearchAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private AccountForm account;
	private ProductLogic productLogic;
	private AccountLogic accLogic;
	private String pageString;
	private String productId;
	
	private List<ProductSet> products = new ArrayList<ProductSet>();

	public String execute() throws Exception {
		initView(false);
		return SUCCESS;
	}

	public String search() {
		if (CommonUtil.isEmpty(account.getCurrentPage())
				|| account.getCurrentPage() < 1) {
			account.setCurrentPage(1);
		}
		if (!CommonUtil.isEmpty(pageString)) {
			if (Contants.PRIV.equals(pageString)) {
				account.setCurrentPage(account.getCurrentPage() - 1);
			}
			if (Contants.NEXT.equals(pageString)) {
				account.setCurrentPage(account.getCurrentPage() + 1);
			}
		}
		LogicDTO dto = accLogic.search(account, this.productId);
		if (dto.isResult()) {
			initView(true);
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			initView(false);
			return INPUT;
		}
		
	}

	private void initView(boolean resultFlag) {
		if (account == null) account = new AccountForm();
		
		this.products = productLogic.getAllProductSet();
		account.initView(resultFlag);
	}
	public AccountForm getAccount() {
		return account;
	}

	public void setAccount(AccountForm account) {
		this.account = account;
	}

	public ProductLogic getProductLogic() {
		return productLogic;
	}

	public void setProductLogic(ProductLogic productLogic) {
		this.productLogic = productLogic;
	}

	public AccountLogic getAccLogic() {
		return accLogic;
	}

	public void setAccLogic(AccountLogic accLogic) {
		this.accLogic = accLogic;
	}

	public String getPageString() {
		return pageString;
	}

	public void setPageString(String pageString) {
		this.pageString = pageString;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public List<ProductSet> getProducts() {
		return products;
	}

	public void setProducts(List<ProductSet> products) {
		this.products = products;
	}
	

}
