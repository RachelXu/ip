package action;

import logic.LogicDTO;
import logic.PreCardDeleteLogic;
import form.CardForm;

public class PreCardDeleteAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private CardForm cardDelete;
	private String deleteId;
	private PreCardDeleteLogic logic;

	public String execute() throws Exception {
		cardDelete = new CardForm();
		cardDelete.initView(false);
		LogicDTO logicDTO = logic.doLogic(deleteId, cardDelete);
		if (logicDTO.isResult()) {
			return SUCCESS;
		} else {
			this.addActionError(getText(logicDTO.getErrorCode()));
			return INPUT;
		}
	}

	/**
	 * @return the logic
	 */
	public PreCardDeleteLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(PreCardDeleteLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the cardDelete
	 */
	public CardForm getCardDelete() {
		return cardDelete;
	}

	/**
	 * @param cardDelete
	 *            the cardDelete to set
	 */
	public void setCardDelete(CardForm cardDelete) {
		this.cardDelete = cardDelete;
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

}
