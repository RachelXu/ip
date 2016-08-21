package action;

import logic.LogicDTO;
import logic.ProCtatlogDeleteLogic;
import form.CatalogForm;

public class ProCatalogDeleteAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private String deleteId;
	private ProCtatlogDeleteLogic logic;
	private CatalogForm catalogEdit;

	public String execute() throws Exception {
		LogicDTO dto = logic.doLogic(deleteId);
		if (dto.isResult()) {
			return SUCCESS;
		} else {
			CatalogForm tempCatalogForm = (CatalogForm) request.getSession()
					.getAttribute("catalogForm");
			catalogEdit.copy(tempCatalogForm);
			this.addFieldError("field", getText(dto.getErrorCode()));

			return INPUT;
		}
	}

	/**
	 * @return the deleteId
	 */
	public String getDeleteId() {
		return deleteId;
	}

	/**
	 * @param deleteId
	 *            the deleteId to set
	 */
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}

	/**
	 * @return the logic
	 */
	public ProCtatlogDeleteLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProCtatlogDeleteLogic logic) {
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
