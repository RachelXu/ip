package batch;

import org.quartz.JobExecutionException;

import dao.MediaDescDAOplus;

public class MediaBatch {
	private MediaDescDAOplus dao;

	public void doBatch() throws JobExecutionException {
		dao.deleteNightBatch();
	}

	/**
	 * @return the dao
	 */
	public MediaDescDAOplus getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(MediaDescDAOplus dao) {
		this.dao = dao;
	}

}