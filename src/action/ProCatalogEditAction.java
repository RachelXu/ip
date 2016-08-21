package action;

import logic.ProCatalogEditLogic;
import form.CatalogForm;

public class ProCatalogEditAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private CatalogForm catalogEdit;
	private ProCatalogEditLogic logic;

	public String execute() throws Exception {
		logic.doLogic(catalogEdit);
		return SUCCESS;

	}

	public void validate() {
		super.validate();
		CatalogForm tempCatalogForm = (CatalogForm) request.getSession()
				.getAttribute("catalogForm");
		catalogEdit.copy(tempCatalogForm);

	}

	/**
	 * @return the logic
	 */
	public ProCatalogEditLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProCatalogEditLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the catalogEdit
	 */
	public CatalogForm getCatalogEdit() {
		return catalogEdit;
	}

	/**
	 * @param catalogEdit
	 *            the catalogEdit to set
	 */
	public void setCatalogEdit(CatalogForm catalogEdit) {
		this.catalogEdit = catalogEdit;
	}

}
