package action;

import logic.LogicDTO;
import logic.PreCardEditLogic;
import form.CardForm;

public class PreCardEditAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private CardForm cardEdit;
	private String editId;
	private PreCardEditLogic logic;

	public String execute() throws Exception {
		cardEdit = new CardForm();
		cardEdit.initView(false);
		LogicDTO logicDTO = logic.doLogic(editId, cardEdit);
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
	 * @return the logic
	 */
	public PreCardEditLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(PreCardEditLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the cardEdit
	 */
	public CardForm getCardEdit() {
		return cardEdit;
	}

	/**
	 * @param cardEdit
	 *            the cardEdit to set
	 */
	public void setCardEdit(CardForm cardEdit) {
		this.cardEdit = cardEdit;
	}

}
