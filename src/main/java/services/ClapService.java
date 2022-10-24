package services;

import java.util.ArrayList;
import java.util.List;

import constants.JpaConst;
import constants.LanguageClassConst;
import constants.MessageConst;
import models.Clap;

public final class ClapService extends ServiceBase implements AutoCloseable{

//	/**
//	 * Create one data based on the configure update detail entered from the screen and update configuration table
//	 * @param cv Configure's registration detail entered from the screen
//	 * @return Error list that occurred validating and updating
//	 */
//	public List<String> update(Clap c) {
//		//[Locked] We must implements the other type of reactions
//		//Do validation
//		List<String> errors = ClapValidator.validate(c);
//
//		if (errors.size() == 0) {
//			updateInternal(c.getReport_id(), c.getEmployee_id(), c.getReaction());
//		}
//
//		//Returns errors occurred at the validation (No errors then empty list)
//		return errors;
//	}


	/**
	 * Search clap with both report ID and employee ID as condition, then create new reaction if not found it.
	 * @param rep_id Report ID
	 * @param emp_id Employee ID
	 * @param reaction Type of reaction
	 * @param lang For localize based on LanguageClassConst enum object
	 * @return List of the errors occurred at validation or already exists the reaction
	 */
	public List<String> doReaction(int rep_id, int emp_id, int reaction, LanguageClassConst lang) {
		List<String> errors = new ArrayList<>();
		List<Clap> claps = em.createNamedQuery(JpaConst.Q_CLAP_GET_BY_REP_AND_EMP, Clap.class)
			.setParameter(JpaConst.JPQL_PARM_EMPLOYEE, emp_id)
			.setParameter(JpaConst.JPQL_PARM_REPORT, rep_id).getResultList();
		if (claps.size() > 0) {
			errors.add(MessageConst.E_ALREADY_CLAPPED.getMessage(lang));
		}
		//[Locked] We must implements the other type of reaction
		if (errors.size() == 0) {
			createInternal(new Clap(null, rep_id, emp_id, reaction));
		}


		return errors;
	}

	/**
	 * Search clap with both report ID and employee ID as condition, then delete the reaction if found it.
	 * @param rep_id Report ID
	 * @param emp_id Employee ID
	 * @param lang For localize based on LanguageClassConst enum object
	 * @return List of the errors occurred at validation or already exists the reaction
	 */
	public List<String> undoReaction(int rep_id, int emp_id, LanguageClassConst lang) {
		List<String> errors = new ArrayList<>();
		List<Clap> claps = em.createNamedQuery(JpaConst.Q_CLAP_GET_BY_REP_AND_EMP, Clap.class)
			.setParameter(JpaConst.JPQL_PARM_EMPLOYEE, emp_id)
			.setParameter(JpaConst.JPQL_PARM_REPORT, rep_id).getResultList();
		if (claps.size() == 0) {
			errors.add(MessageConst.E_ALREADY_UNDID_CLAP.getMessage(lang));
		}
		//[Locked] We must implements the other type of reaction
		if (errors.size() == 0) {
			dredInternal(rep_id, emp_id);
		}


		return errors;
	}

	/**
	 * Returns claps with report ID
	 * @param rep_id Report ID
	 * @return List of the claps
	 */
	public List<Clap> getClapsAllByReport(int rep_id){
		return em.createNamedQuery(JpaConst.Q_CLAP_GET_ALL, Clap.class)
			.setParameter(JpaConst.JPQL_PARM_REPORT, rep_id).getResultList();
	}

	/**
	 * Returns number of claps with report ID
	 * @param rep_id Report ID
	 * @return Number of claps at the report
	 */
	public long countAllByReport(int rep_id){
		return (long)em.createNamedQuery(JpaConst.Q_CLAP_COUNT, Long.class)
			.setParameter(JpaConst.JPQL_PARM_REPORT, rep_id).getSingleResult();
	}

	public boolean isEmployeeReactedTheReport(int rep_id, int emp_id) {	//I thought it: we should make it have object type value as it's arguments
		return em.createNamedQuery(JpaConst.Q_CLAP_GET_BY_REP_AND_EMP, Clap.class)
			.setParameter(JpaConst.JPQL_PARM_REPORT, rep_id)
			.setParameter(JpaConst.JPQL_PARM_EMPLOYEE, emp_id).getResultList().size() != 0;
	}

	/**
	 * Acquires one data with ID as condition
	 * @param ID
	 * @return Instance of acquired data
	 */
	private Clap findOneInternal(int rep_id, int emp_id) {
		return em.createNamedQuery(JpaConst.Q_CLAP_GET_BY_REP_AND_EMP, Clap.class)
			.setParameter(JpaConst.JPQL_PARM_EMPLOYEE, emp_id)
			.setParameter(JpaConst.JPQL_PARM_REPORT, rep_id).getSingleResult();
	}

	/**
	 * Register one reaction data
	 * @param clap Configure data
	 */
	private void createInternal(Clap clap) {
		em.getTransaction().begin();
		em.persist(clap);
		em.getTransaction().commit();
	}

	/**
	 * Remove one reaction data
	 * @param clap Configure data
	 */
	private void dredInternal(int rep_id, int emp_id) {
		em.getTransaction().begin();
		Clap c = findOneInternal(rep_id, emp_id);
		em.remove(c);
//		c.setReaction(0);
		em.getTransaction().commit();
	}

	//[Locked] We must implements other type of reactions
//	/**
//	 * Update the reaction data
//	 * @param rep_id Report ID
//	 * @param emp_id Employee ID
//	 * @param reaction Reaction data
//	 */
//	private void updateInternal(int rep_id, int emp_id, int reaction) {
//		em.getTransaction().begin();
//		Clap c = findOneInternal(rep_id, emp_id);
//		c.setReaction(reaction);
//		em.getTransaction().commit();
//	}


}
