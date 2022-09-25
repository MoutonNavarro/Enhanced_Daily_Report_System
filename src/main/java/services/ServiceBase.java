package services;

import javax.persistence.EntityManager;

import utils.DBUtil;

/**
 * Class that do common process relative to DB connection
 */
public class ServiceBase {

	/**
	 * EntityManager instance
	 */
	protected EntityManager em = DBUtil.createEntityManager();

	/**
	 * Close EntityManager
	 */
	public void close() {
		if (em.isOpen()) {
			em.close();
		}
	}
}
