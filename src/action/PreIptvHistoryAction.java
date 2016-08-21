package action;

import java.util.ArrayList;
import java.util.List;

import logic.PreIptvHistoryLogic;
import dao.Iptvsoftware;

public class PreIptvHistoryAction extends MySuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -592930974756071310L;
	private boolean showResultFlag;
	private List<Iptvsoftware> resultList;
	private PreIptvHistoryLogic logic;

	public String execute() throws Exception {
		resultList = new ArrayList<Iptvsoftware>();
		logic.doLogic(resultList);
		if (resultList.size() == 0) {
			showResultFlag = false;
		} else {
			showResultFlag = true;
		}
		return SUCCESS;
	}

	/**
	 * @return the showResultFlag
	 */
	public boolean isShowResultFlag() {
		return showResultFlag;
	}

	/**
	 * @param showResultFlag
	 *            the showResultFlag to set
	 */
	public void setShowResultFlag(boolean showResultFlag) {
		this.showResultFlag = showResultFlag;
	}

	/**
	 * @return the resultList
	 */
	public List<Iptvsoftware> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList
	 *            the resultList to set
	 */
	public void setResultList(List<Iptvsoftware> resultList) {
		this.resultList = resultList;
	}

	/**
	 * @return the logic
	 */
	public PreIptvHistoryLogic getLogic() {
		return logic;
	}

	/**
	 * @param logic
	 *            the logic to set
	 */
	public void setLogic(PreIptvHistoryLogic logic) {
		this.logic = logic;
	}

}
