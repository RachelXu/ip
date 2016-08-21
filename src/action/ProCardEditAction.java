package action;

import logic.ProCardEditLogic;
import util.CommonUtil;
import util.Contants;
import form.CardForm;

public class ProCardEditAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private CardForm cardEdit;
	private ProCardEditLogic logic;

	public String execute() throws Exception {
		logic.doLogic(cardEdit);
		return SUCCESS;

	}

	public void validate() {
		super.validate();
		if (!CommonUtil.isEmpty(cardEdit.getChargedate())
				&& !CommonUtil.isyyyyMMdd(cardEdit.getChargedate())) {
			this.addFieldError("field", getText(Contants.E022));
		}
		if (!CommonUtil.isEmpty(cardEdit.getEnddate())
				&& !CommonUtil.isyyyyMMdd(cardEdit.getEnddate())) {
			this.addFieldError("field", getText(Contants.E021));
		}
	}

	/**
	 * @return the logic
	 */
	public ProCardEditLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProCardEditLogic logic) {
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
