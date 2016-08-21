package batch;

import org.quartz.JobExecutionException;

import dao.CardDAOplus;

public class CardInvalidBatch {
	private CardDAOplus dao;

	public void doBatch() throws JobExecutionException {
		dao.cardInvalidBatch();
	}

	/**
	 * @return the dao
	 */
	public CardDAOplus getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(CardDAOplus dao) {
		this.dao = dao;
	}

}