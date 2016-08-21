package action;

import logic.LogicDTO;
import logic.PreMediaApproveLogic;
import logic.ProMediaApproveLogic;
import util.CommonUtil;
import util.Contants;
import form.MediaForm;

public class ProMediaApproveAction extends MySuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617947585265284786L;
	private MediaForm media;
	private ProMediaApproveLogic logic;
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
			sublogic.doLogic(media, "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.validate();
		// 用户是否未选任何数据
		if (approveCkeck == null) {
			this.addFieldError("field", getText(Contants.E014));
		}
		// 有效日期是否是合法时间
		if (CommonUtil.isEmpty(media.getEndDate())
				|| !CommonUtil.isyyyyMMdd(media.getEndDate())) {
			this.addFieldError("field", getText(Contants.E044));
		}
		// 有效日期是否小于当天
		if (!CommonUtil.isGreaterThanToday((media.getEndDate()))) {
			this.addFieldError("field", getText(Contants.E045));
		}
		// 用户为选择服务类型
		if (CommonUtil.isEmpty(media.getServiceType())) {
			this.addFieldError("field", getText(Contants.E046));
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
	public ProMediaApproveLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProMediaApproveLogic logic) {
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
