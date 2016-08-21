package action;

import logic.PreCardBatchInsertLogic;
import form.CardForm;

public class PreCardBatchInsertAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private CardForm card;
	private PreCardBatchInsertLogic logic;

	public String execute() throws Exception {
		card = new CardForm();
		card.initView(false);
		logic.doLogic(card);
		this.request.getSession().setAttribute("cardform", card);
		return SUCCESS;
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
	public PreCardBatchInsertLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(PreCardBatchInsertLogic logic) {
		this.logic = logic;
	}

}
