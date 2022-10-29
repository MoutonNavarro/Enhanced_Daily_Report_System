package services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import actions.views.ConfigureConverter;
import actions.views.ConfigureView;
import colors.ColorNameEnum;
import constants.LanguageClassConst;
import models.Configure;
import models.validators.ConfigureValidator;

/**
 * Class that do process relative to operation to configuration table
 */
public final class ConfigureService extends ServiceBase implements AutoCloseable{


	/**
	 * Return acquired data with Employee ID as condition as ConfigureView's instance
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
	 * @param lang For localize based on LanguageClassConst enum object
	 * @return Error list that occurred validating and updating
	 */
	public List<String> update(ConfigureView cv, LanguageClassConst lang) {
		//Do validation
		List<String> errors = ConfigureValidator.validate(cv, lang);

		if (errors.size() == 0) {
			//Set current time at date updated
			LocalDateTime ldt = LocalDateTime.now();
			cv.setUpdatedAt(ldt);
			if (ColorNameEnum.getByName(cv.getUser_color()) == null) {
				cv.setUser_color(ColorNameEnum.getByCode(cv.getUser_color()).getName());
			}
			{
				LanguageClassConst lcc = LanguageClassConst.getByLanguageName(cv.getLanguage());
				cv.setLanguage(lcc.getLanguageCode());
				cv.setLang_country(lcc.getLanguageCountry());
			}

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
