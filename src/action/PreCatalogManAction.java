package action;

import logic.LogicDTO;
import logic.PreCatalogManLogic;
import form.CatalogForm;

public class PreCatalogManAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 378340882595762250L;
	private CatalogForm catalog;
	private PreCatalogManLogic logic;

	public String execute() throws Exception {
		catalog = new CatalogForm();
		LogicDTO dto = logic.doLogic(catalog);
		request.getSession().setAttribute("catalogForm", catalog);
		if (dto.isResult()) {
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			return INPUT;
		}
	}

	/**
	 * @return the logic
	 */
	public PreCatalogManLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(PreCatalogManLogic logic) {
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
