package action;

import logic.LogicDTO;
import logic.PreMediaApproveLogic;
import form.MediaForm;

public class PreMediaApproveAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private MediaForm media;
	private PreMediaApproveLogic logic;

	public String execute() throws Exception {
		media = new MediaForm();
		LogicDTO dto = logic.doLogic(media, "1");
		if (dto.isResult()) {
			this.request.getSession().setAttribute("mediaapprovelist",
					media.getResultList());
			media.setResultFlag(true);
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			media.setResultFlag(false);
			return INPUT;
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
	public PreMediaApproveLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(PreMediaApproveLogic logic) {
		this.logic = logic;
	}

}
