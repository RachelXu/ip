package action;

import logic.ProCardBatchInsertLogic;
import util.CommonUtil;
import util.Contants;
import form.CardForm;

public class ProCardBatchInsertAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private CardForm card;
	private ProCardBatchInsertLogic logic;

	public String execute() throws Exception {
		logic.doLogic(card);
		return SUCCESS;
	}

	public void validate() {
		super.validate();
		if (CommonUtil.isEmpty(card.getService())) {
			this.addFieldError("field", getText(Contants.E049));
		}
		if (CommonUtil.isEmpty(card.getEnddate())
				|| !CommonUtil.isyyyyMMdd(card.getEnddate())) {
			this.addFieldError("field", getText(Contants.E021));
		}
		CardForm tempForm = (CardForm) this.request.getSession().getAttribute(
				"cardform");
		card.copy(tempForm);
	}

	/**
	 * @return the card
	 */
	public CardForm getCard() {
		return card;
	}

	/**
	 * @param card
	 *            the card to set
	 */
	public void setCard(CardForm card) {
		this.card = card;
	}

	/**
	 * @return the logic
	 */
	public ProCardBatchInsertLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProCardBatchInsertLogic logic) {
		this.logic = logic;
	}

}
