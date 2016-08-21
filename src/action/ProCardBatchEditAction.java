package action;

import logic.LogicDTO;
import logic.ProCardBatchEditLogic;
import util.CommonUtil;
import util.Contants;
import form.CardForm;

public class ProCardBatchEditAction extends MySuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617947585265284786L;
	private CardForm card;
	private ProCardBatchEditLogic logic;

	public String execute() throws Exception {
		LogicDTO dto = logic.doLogic(card);
		if (dto.isResult()) {
			this.request.getSession().setAttribute("cardbatchlist",
					card.getResultList());
			card.initView(true);
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			card.initView(false);
			return INPUT;
		}
	}

	public void validate() {
		super.validate();
		if (!CommonUtil.isEmpty(card.getChargedate1())
				&& !CommonUtil.isyyyyMMdd(card.getChargedate1())) {
			this.addFieldError("field", getText(Contants.E022));
		}
		if (!CommonUtil.isEmpty(card.getChargedate2())
				&& !CommonUtil.isyyyyMMdd(card.getChargedate2())) {
			this.addFieldError("field", getText(Contants.E022));
		}
		if (!CommonUtil.isEmpty(card.getEnddate1())
				&& !CommonUtil.isyyyyMMdd(card.getEnddate1())) {
			this.addFieldError("field", getText(Contants.E021));
		}
		if (!CommonUtil.isEmpty(card.getEnddate2())
				&& !CommonUtil.isyyyyMMdd(card.getEnddate2())) {
			this.addFieldError("field", getText(Contants.E021));
		}
		if (super.getFieldErrors().size() != 0) {
			card.initView(false);
		} else {
			card.initView(true);
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
	public ProCardBatchEditLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProCardBatchEditLogic logic) {
		this.logic = logic;
	}

}
