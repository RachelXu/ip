package action;

import form.CardForm;

public class PreCardDownloadAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4638370260049093287L;

	private CardForm card;

	public String execute() throws Exception {
		card = new CardForm();
		card.initView(false);
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

}
