package action;

import logic.LogicDTO;
import logic.PreMediaDeleteLogic;
import form.MediaForm;

public class PreMediaDeleteAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private MediaForm media;
	private String deleteId;
	private PreMediaDeleteLogic logic;

	public String execute() throws Exception {
		media = new MediaForm();
		MediaForm tempForm = (MediaForm) this.request.getSession()
				.getAttribute("mediaform");
		media.copy(tempForm);
		LogicDTO logicDTO = logic.doLogic(deleteId, media);
		if (logicDTO.isResult()) {
			return SUCCESS;
		} else {
			this.addActionError(getText(logicDTO.getErrorCode()));
			return INPUT;
		}
	}

	/**
	 * @return the logic
	 */
	public PreMediaDeleteLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(PreMediaDeleteLogic logic) {
		this.logic = logic;
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
	 * @return the deleteId
	 */
	public String getDeleteId() {
		return deleteId;
	}

	/**
	 * @param deleteId
	 *            the deleteId to set
	 */
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}

}
