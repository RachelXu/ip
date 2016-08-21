package batch;

import org.quartz.JobExecutionException;

import dao.UserDAOplus;

public class UserChargingBatch {
	private UserDAOplus dao;

	public void doBatch() throws JobExecutionException {
		dao.userChargingBatch();
		dao.userStopBatch();
	}

	/**
	 * @return the dao
	 */
	public UserDAOplus getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(UserDAOplus dao) {
		this.dao = dao;
	}

}