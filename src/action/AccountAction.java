package action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import dao.model.Account;
import dao.model.ProductSet;
import form.AccountForm;
import logic.AccountLogic;
import logic.LogicDTO;
import logic.ProductLogic;
import util.CommonUtil;
import util.Contants;

public class AccountAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private AccountForm account;
	private ProductLogic productLogic;
	private AccountLogic accLogic;
	private String pageString;
	private String productId;
	private String itemId;
	private String itemIds;
	private String opType;
	private List<ProductSet> products = new ArrayList<ProductSet>();


	public String search() {
		if (account == null) {
			initView(false);
			return SUCCESS;
		} else {
			if (CommonUtil.isEmpty(account.getCurrentPage()) || account.getCurrentPage() < 1) {
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
	}

	public String del(){
		
		accLogic.delete(this.itemId);
		if (CommonUtil.isEmpty(account.getCurrentPage()) || account.getCurrentPage() < 1) {
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
	
	public String update(){
		if (account == null) {
			//GET request is pre update
			account = new AccountForm();
			this.itemId = request.getParameter("itemId");
			
			Account acc = accLogic.loadAccount(this.itemId);
			if (acc != null) {
				account.setAccount(acc);			
			} else {
				this.itemId = request.getParameter("itemId");
			}
			return SUCCESS;
		} else {
			//Post request is update
			Account existAcc = accLogic.loadAccount(account.getAccount().getAccountId());
			existAcc.setState(account.getAccount().getState());
			accLogic.updateAccount(existAcc);
			this.addActionMessage("Update Success");
			return SUCCESS;
		}
		
		
	}
	
	public String assignProduct(){
		if (opType == null) {
			//GET request is pre execute
			account = new AccountForm();
			itemIds = request.getParameter("accIds");
			opType = request.getParameter("type");
			
			this.products = productLogic.getAllProductSet();			
			return SUCCESS;
		} else {
			//Post request is execute
			if (opType.equalsIgnoreCase("Add")){
				accLogic.assignProduct(Arrays.asList(itemIds.split("\\;")), Arrays.asList(productId.split("\\, ")), new Date());
			} else {
				accLogic.reduceProduct(Arrays.asList(itemIds.split("\\;")), Arrays.asList(productId.split("\\, ")));
			}
			this.products = productLogic.getAllProductSet();	
			this.addActionMessage("Update Success");
			return SUCCESS;
		}
	}
	public String add() throws Exception {
		if (account == null) {
			initView(false);
			return SUCCESS;
		} else {
			//Post request is update
			accLogic.saveAccount(new Account(account.getAccount().getAccountId(), account.getAccount().getState()));
			this.addActionMessage("Save Success");
			return SUCCESS;
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

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemIds() {
		return itemIds;
	}

	public void setItemIds(String itemIds) {
		this.itemIds = itemIds;
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}
	

}
