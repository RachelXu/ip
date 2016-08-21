package action;

import logic.LogicDTO;
import logic.PreMediaApproveLogic;
import logic.ProMediaDisApproveLogic;
import util.Contants;
import form.MediaForm;

public class ProMediaDisApproveAction extends MySuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617947585265284786L;
	private MediaForm media;
	private ProMediaDisApproveLogic logic;
	private PreMediaApproveLogic sublogic;
	private String[] approveCkeck;

	public String execute() throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);

		dto = logic.doLogic(media, approveCkeck);
		if (dto.isResult()) {
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			return INPUT;
		}
	}

	public void validate() {
		media.setResultFlag(true);
		try {
			sublogic.doLogic(media, "2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.validate();
		// 用户是否未选任何数据
		if (approveCkeck == null) {
			this.addFieldError("field", getText(Contants.E014));
		}
	}

	/**
	 * @return the media
	 */
	public MediaForm getMedia() {
		return media;
	}

	/**
	 * @param media
	 *            the media to set
	 */
	public void setMedia(MediaForm media) {
		this.media = media;
	}

	/**
	 * @return the logic
	 */
	public ProMediaDisApproveLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProMediaDisApproveLogic logic) {
		this.logic = logic;
	}

	/**
	 * @return the approveCkeck
	 */
	public String[] getApproveCkeck() {
		return approveCkeck;
	}

	/**
	 * @param approveCkeck
	 *            the approveCkeck to set
	 */
	public void setApproveCkeck(String[] approveCkeck) {
		this.approveCkeck = approveCkeck;
	}

	/**
	 * @return the sublogic
	 */
	public PreMediaApproveLogic getSublogic() {
		return sublogic;
	}

	/**
	 * @param sublogic
	 *            the sublogic to set
	 */
	public void setSublogic(PreMediaApproveLogic sublogic) {
		this.sublogic = sublogic;
	}

}
