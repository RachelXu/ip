package action;

import logic.LogicDTO;
import logic.ProMediaSearchLogic;
import util.CommonUtil;
import util.Contants;
import form.MediaForm;

public class ProMediaSearchAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 378340882595762250L;
	private MediaForm media;
	private ProMediaSearchLogic logic;
	private String pageString;

	public String execute() throws Exception {
		if (CommonUtil.isEmpty(media.getCurrentPage())
				|| media.getCurrentPage() < 1) {
			media.setCurrentPage(1);
		}
		if (!CommonUtil.isEmpty(pageString)) {
			if (Contants.PRIV.equals(pageString)) {
				media.setCurrentPage(media.getCurrentPage() - 1);
			}
			if (Contants.NEXT.equals(pageString)) {
				media.setCurrentPage(media.getCurrentPage() + 1);
			}
		}
		MediaForm tempForm = (MediaForm) this.request.getSession()
				.getAttribute("mediaform");
		media.copy(tempForm);
		LogicDTO dto = logic.doLogic(media);
		if (dto.isResult()) {
			media.initView(true);
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			media.initView(false);
			return INPUT;
		}
	}

	public void validate() {
		super.validate();
		if (!CommonUtil.isEmpty(media.getYear1())
				&& !CommonUtil.isNumber(media.getYear1())) {
			this.addFieldError("field", getText(Contants.E028));
		}
		if (!CommonUtil.isEmpty(media.getYear2())
				&& !CommonUtil.isNumber(media.getYear2())) {
			this.addFieldError("field", getText(Contants.E028));
		}
		MediaForm tempForm = (MediaForm) this.request.getSession()
				.getAttribute("mediaform");
		media.copy(tempForm);
	}

	/**
	 * @return the logic
	 */
	public ProMediaSearchLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProMediaSearchLogic logic) {
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
