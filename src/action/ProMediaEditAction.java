package action;

import logic.ProMediaEditLogic;
import util.CommonUtil;
import util.Contants;
import form.MediaForm;

public class ProMediaEditAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875306436871318474L;
	private MediaForm media;
	private ProMediaEditLogic logic;

	public String execute() throws Exception {
		logic.doLogic(media);
		return SUCCESS;

	}

	public void validate() {
		super.validate();
		if (!CommonUtil.isEmpty(media.getYear())
				&& !CommonUtil.isNumber(media.getYear())) {
			this.addFieldError("field", getText(Contants.E028));
		}
		MediaForm tempForm = (MediaForm) this.request.getSession()
				.getAttribute("mediaform");
		media.copy(tempForm);
	}

	/**
	 * @return the logic
	 */
	public ProMediaEditLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProMediaEditLogic logic) {
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

}
