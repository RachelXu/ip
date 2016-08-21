package action;

import logic.LogicDTO;
import logic.ProCatalogManLogic;
import form.CatalogForm;

public class ProCatalogManAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 378340882595762250L;
	private CatalogForm catalog;
	private ProCatalogManLogic logic;

	public String execute() throws Exception {
		LogicDTO dto = logic.doLogic(catalog);
		if (dto.isResult()) {
			this.addFieldError("field", "新增栏目信息成功！");
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			return INPUT;
		}
	}

	public void validate() {
		super.validate();
		catalog.copy((CatalogForm) this.request.getSession().getAttribute(
				"catalogForm"));
	}

	/**
	 * @return the logic
	 */
	public ProCatalogManLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProCatalogManLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the catalog
	 */
	public CatalogForm getCatalog() {
		return catalog;
	}

	/**
	 * @param catalog
	 *            the catalog to set
	 */
	public void setCatalog(CatalogForm catalog) {
		this.catalog = catalog;
	}

}
