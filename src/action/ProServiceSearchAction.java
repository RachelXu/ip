package action;

import logic.LogicDTO;
import logic.ProServiceSearchLogic;
import util.CommonUtil;
import util.Contants;
import form.ServiceForm;

public class ProServiceSearchAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 378340882595762250L;
	private ServiceForm service;
	private ProServiceSearchLogic logic;
	private String pageString;

	public String execute() throws Exception {
		if (CommonUtil.isEmpty(service.getCurrentPage())
				|| service.getCurrentPage() < 1) {
			service.setCurrentPage(1);
		}
		if (!CommonUtil.isEmpty(pageString)) {
			if (Contants.PRIV.equals(pageString)) {
				service.setCurrentPage(service.getCurrentPage() - 1);
			}
			if (Contants.NEXT.equals(pageString)) {
				service.setCurrentPage(service.getCurrentPage() + 1);
			}
		}
		LogicDTO dto = logic.doLogic(service);
		if (dto.isResult()) {
			service.setResultFlag(true);
			return SUCCESS;
		} else {
			this.addFieldError("field", getText(dto.getErrorCode()));
			service.setResultFlag(false);
			return INPUT;
		}
	}

	/**
	 * @return the service
	 */
	public ServiceForm getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(ServiceForm service) {
		this.service = service;
	}

	/**
	 * @return the logic
	 */
	public ProServiceSearchLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(ProServiceSearchLogic logic) {
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
