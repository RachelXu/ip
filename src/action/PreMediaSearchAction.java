package action;

import logic.PreMediaSearchLogic;
import form.MediaForm;

public class PreMediaSearchAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private MediaForm media;
	private PreMediaSearchLogic logic;

	public String execute() throws Exception {
		media = new MediaForm();
		media.initView(false);
		this.request.getSession().setAttribute("mediaform", media);
		logic.doLogic(media);
		return SUCCESS;
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
	public PreMediaSearchLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(PreMediaSearchLogic logic) {
		this.logic = logic;
	}

}
