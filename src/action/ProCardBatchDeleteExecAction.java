package action;

import java.util.List;

import logic.LogicDTO;
import logic.ProCardBatchDeleteExecLogic;
import util.Contants;
import form.CardDetil;
import form.CardForm;

public class ProCardBatchDeleteExecAction extends MySuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617947585265284786L;
	private CardForm card;
	private ProCardBatchDeleteExecLogic logic;
	private String[] deleteCkeck;

	public String execute() throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		if (deleteCkeck == null) {
			this.addFieldError("field", getText(Contants.E014));
			card.initView(true);
			card.setResultList((List<CardDetil>) this.request.getSession()
					.getAttribute("cardbatchlist"));
			return INPUT;
		} else {
			dto = logic.doLogic(deleteCkeck);
		}
		if (dto.isResult()) {
			card.initView(true);
			card.setResultList((List<CardDetil>) this.request.getSession()
					.getAttribute("cardbatchlist"));
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			card.initView(true);
			card.setResultList((List<CardDetil>) this.request.getSession()
					.getAttribute("cardbatchlist"));
			return INPUT;
		}
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
	public ProCardBatchDeleteExecLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProCardBatchDeleteExecLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the deleteCkeck
	 */
	public String[] getDeleteCkeck() {
		return deleteCkeck;
	}

	/**
	 * @param deleteCkeck
	 *            the deleteCkeck to set
	 */
	public void setDeleteCkeck(String[] deleteCkeck) {
		this.deleteCkeck = deleteCkeck;
	}

}
