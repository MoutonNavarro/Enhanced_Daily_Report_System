package actions.views;

import models.Configure;

/**
 * Class that mutual converts the configuration data's DTO model and View model
 */
public class ConfigureConverter {
	/**
	 * Create DTO model's instance from View model's instance
	 * @param cv ConfigureView's instance
	 * @return Configure's instance
	 * @throws NullPointerException In case that null argument
	 */
	public static Configure toModel(ConfigureView cv) {
		return new Configure(cv.getId(),	cv.getCreatedAt(),	cv.getUpdatedAt(),
				cv.getLanguage(), cv.getLang_country(),
				cv.getTime_zone(),	cv.getTime_area(), cv.getTime_is_spring_time(),
				cv.getColor_theme(), cv.getDisable_js(), cv.getDisable_flash(),
				cv.getUser_color(),	cv.getUser_background(), cv.getUser_color_special());
	}

	/**
	 * Create View model's instance from DTO model's instance
	 * @param c Configure's instance
	 * @return ConfigureView's instance
	 */
	public static ConfigureView toView(Configure c) {

		if (c == null) {
			return null;
		}

		return new ConfigureView(c.getId(),	c.getCreatedAt(),	c.getUpdatedAt(),
			c.getLanguage(), c.getLang_country(),
			c.getTime_zone(),	c.getTime_area(), c.getTime_is_spring_time(),
			c.getColor_theme(), c.getDisable_js(), c.getDisable_flash(),
			c.getUser_color(),	c.getUser_background(), c.getUser_color_special());
	}

	/**
	 * Copy all field's content of View model to DTO model's field
	 * @param c DTO model (copy to)
	 * @param cv View model (copy from)
	 */
	public static void copyViewToModel(Configure c, ConfigureView cv) {
		c.setId(cv.getId());	c.setCreatedAt(cv.getCreatedAt());	c.setUpdatedAt(cv.getUpdatedAt());
		c.setLanguage(cv.getLanguage());	c.setLang_country(cv.getLang_country());
		c.setTime_zone(cv.getTime_zone());	c.setTime_area(cv.getTime_area());
		c.setTime_is_spring_time(cv.getTime_is_spring_time());	c.setColor_theme(cv.getColor_theme());
		c.setDisable_js(cv.getDisable_js());	c.setDisable_flash(cv.getDisable_flash());
		c.setUser_color(cv.getUser_color());	c.setUser_background(cv.getUser_background());
		c.setUser_color_special(cv.getUser_color_special());

	}

}
