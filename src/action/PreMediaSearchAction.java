package action;

import form.ChannelForm;
import logic.PreMediaSearchLogic;

public class PreMediaSearchAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private ChannelForm media;
	private PreMediaSearchLogic logic;

	public String execute() throws Exception {
		media = new ChannelForm();
		media.initView(false);
//		this.request.getSession().setAttribute("mediaform", media);
//		logic.doLogic(media);
		return SUCCESS;
	}



	public ChannelForm getMedia() {
		return media;
	}



	public void setMedia(ChannelForm media) {
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
