package services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import actions.views.ConfigureConverter;
import actions.views.ConfigureView;
import models.Configure;
import models.validators.ConfigureValidator;

public class ConfigureService extends ServiceBase {


	/**
	 * Return acquired data with ID as condition as EmployeeView's instance
	 * @param id
	 * @return Acquired instance (the ID's instance does not found then null)
	 */
	public ConfigureView findOne(int id) {
		Configure c = em.find(Configure.class, id);
		return ConfigureConverter.toView(c);
	}

	/**
	 * Create one data based on the configure update detail entered from the screen and update configuration table
	 * @param cv Configure's registration detail entered from the screen
	 * @return Error list that occurred validating and updating
	 */
	public List<String> update(ConfigureView cv) {
		//Do validation
		List<String> errors = ConfigureValidator.validate(cv);

		if (errors.size() == 0) {
			//Set current time at date updated
			LocalDateTime ldt = LocalDateTime.now();
			cv.setUpdatedAt(ldt);

			updateInternal(cv);
		}

		//Returns errors occurred at the validation (No errors then empty list)
		return errors;
	}

//	/**
//	 * Acquire one data with Employee ID as condition, and return it as Configure's instance
//	 * @param id
//	 * @return Acquired data's instance
//	 */
//	private Configure findOneInternal(int id) {
//		Configure c = em.find(Configure.class, id);
//		return c;
//	}

	/**
	 * Create one data based on input content of the configuration from screen, and register at the report table
	 * @param cv Registration content of the configuration
	 * @return List of the errors occurred at validation
	 */
	public List<String> create(ConfigureView cv){
		List<String> errors = new ArrayList<>();
		createInternal(cv);

		//Returns errors occurred at validation (No errors then empty list)
		return errors;
	}

	/**
	 * Acquires one data with ID as condition
	 * @param ID
	 * @return Instance of acquired data
	 */
	private Configure findOneInternal(int id) {
		return em.find(Configure.class, id);
	}

	/**
	 * Register one configure data
	 * @param cv Configure data
	 */
	private void createInternal(ConfigureView cv) {
		em.getTransaction().begin();
		em.persist(ConfigureConverter.toModel(cv));
		em.getTransaction().commit();
	}

	/**
	 * Update the configuration data
	 * @param cv Configure data
	 */
	private void updateInternal(ConfigureView cv) {
		em.getTransaction().begin();
		Configure c = findOneInternal(cv.getId());
		ConfigureConverter.copyViewToModel(c, cv);
		em.getTransaction().commit();
	}


}
