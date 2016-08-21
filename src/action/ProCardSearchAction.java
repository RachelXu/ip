package action;

import logic.LogicDTO;
import logic.ProCardSearchLogic;
import util.CommonUtil;
import util.Contants;
import form.CardForm;

public class ProCardSearchAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 378340882595762250L;
	private CardForm card;
	private ProCardSearchLogic logic;
	private String pageString;

	public String execute() throws Exception {
		if (CommonUtil.isEmpty(card.getCurrentPage())
				|| card.getCurrentPage() < 1) {
			card.setCurrentPage(1);
		}
		if (!CommonUtil.isEmpty(pageString)) {
			if (Contants.PRIV.equals(pageString)) {
				card.setCurrentPage(card.getCurrentPage() - 1);
			}
			if (Contants.NEXT.equals(pageString)) {
				card.setCurrentPage(card.getCurrentPage() + 1);
			}
		}
		LogicDTO dto = logic.doLogic(card);
		if (dto.isResult()) {
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
	public ProCardSearchLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProCardSearchLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the pageString
	 */
	public String getPageString() {
		return pageString;
	}

	/**
	 * @param pageString
	 *            the pageString to set
	 */
	public void setPageString(String pageString) {
		this.pageString = pageString;
	}

}
