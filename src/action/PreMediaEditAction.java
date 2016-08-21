package action;

import logic.LogicDTO;
import logic.PreMediaDeleteLogic;
import form.MediaForm;

public class PreMediaEditAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private MediaForm media;
	private String editId;
	private PreMediaDeleteLogic logic;

	public String execute() throws Exception {
		media = new MediaForm();
		MediaForm tempForm = (MediaForm) this.request.getSession()
				.getAttribute("mediaform");
		media.copy(tempForm);
		LogicDTO logicDTO = logic.doLogic(editId, media);
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
	 * @return the editId
	 */
	public String getEditId() {
		return editId;
	}

	/**
	 * @param editId
	 *            the editId to set
	 */
	public void setEditId(String editId) {
		this.editId = editId;
	}

}
