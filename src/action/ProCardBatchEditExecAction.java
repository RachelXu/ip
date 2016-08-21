package action;

import java.util.List;

import logic.LogicDTO;
import logic.ProCardBatchEditExecLogic;
import util.CommonUtil;
import util.Contants;
import form.CardDetil;
import form.CardForm;

public class ProCardBatchEditExecAction extends MySuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617947585265284786L;
	private CardForm card;
	private CardForm cardBatchEdit;
	private ProCardBatchEditExecLogic logic;

	public String execute() throws Exception {
		List<CardDetil> cardDetilList = (List<CardDetil>) this.request
				.getSession().getAttribute("cardbatchlist");
		card.setResultList(cardDetilList);
		LogicDTO dto = logic.doLogic(cardBatchEdit, cardDetilList);
		this.request.getSession().removeAttribute("cardbatchlist");
		if (dto.isResult()) {
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			return INPUT;
		}
	}

	public void validate() {
		super.validate();
		if (!CommonUtil.isEmpty(cardBatchEdit.getChargedate())
				&& !CommonUtil.isyyyyMMdd(cardBatchEdit.getChargedate())) {
			this.addFieldError("field", getText(Contants.E022));
		}
		if (!CommonUtil.isEmpty(cardBatchEdit.getEnddate())
				&& !CommonUtil.isyyyyMMdd(cardBatchEdit.getEnddate())) {
			this.addFieldError("field", getText(Contants.E021));
		}
		card.initView(true);
		card.setResultList((List<CardDetil>) this.request.getSession()
				.getAttribute("cardbatchlist"));

	}

	/**
	 * @return the logic
	 */
	public ProCardBatchEditExecLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProCardBatchEditExecLogic logic) {
		this.logic = logic;
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
	 * @return the cardBatchEdit
	 */
	public CardForm getCardBatchEdit() {
		return cardBatchEdit;
	}

	/**
	 * @param cardBatchEdit
	 *            the cardBatchEdit to set
	 */
	public void setCardBatchEdit(CardForm cardBatchEdit) {
		this.cardBatchEdit = cardBatchEdit;
	}

}
