package action;

import logic.LogicDTO;
import logic.PreCatalogEditLogic;
import form.CatalogForm;

public class PreCatalogEditAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private CatalogForm catalogEdit;
	private String editId;
	private PreCatalogEditLogic logic;

	public String execute() throws Exception {
		catalogEdit = new CatalogForm();
		LogicDTO logicDTO = logic.doLogic(editId, catalogEdit);
		CatalogForm tempCatalogForm = (CatalogForm) request.getSession()
				.getAttribute("catalogForm");
		catalogEdit.copy(tempCatalogForm);
		if (logicDTO.isResult()) {
			return SUCCESS;
		} else {
			this.addActionError(getText(logicDTO.getErrorCode()));
			return INPUT;
		}
	}

	/**
	 * @return the editId
	 */
	public String getEditId() {
		return editId;
	}

	/**
	 * @param editId
	 *            the editId to set
	 */
	public void setEditId(String editId) {
		this.editId = editId;
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

	/**
	 * @return the logic
	 */
	public PreCatalogEditLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(PreCatalogEditLogic logic) {
		this.logic = logic;
	}

}
