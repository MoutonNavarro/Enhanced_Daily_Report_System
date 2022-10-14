package actions.views;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * View model that handles input value at the screen and output value about user configure
 */
@Getter //Automatically create getter about all class field (Lombok)
@Setter //Automatically create setter about all class field (Lombok)
@NoArgsConstructor //Automatically create no arguments constructor (Lonbok)
@AllArgsConstructor //Automatically create constructor with arguments that has all class field as argument
public class ConfigureView {

	/**
	 * ID (Employee ID)
	 */
	private Integer id;
	/**
	 * Date Created
	 */
	private LocalDateTime createdAt;
	/**
	 * Date Updated
	 */
	private LocalDateTime updatedAt;

	//visual setting
	/**
	 * Language
	 */
	private String language;

	/**
	 * Language of country
	 */
	private String lang_country;

	/**
	 * Time zone
	 */
	private String time_zone;

	/**
	 * Time zone of area
	 */
	private String time_area;

	/**
	 * Whether is the spring time
	 */
	private byte time_is_spring_time;

	/**
	 * The color theme
	 */
	private String color_theme;

	/**
	 * Whether is disabled JavaScript
	 */
	private boolean disable_js;
	@SuppressWarnings("unused")
	private boolean isDisable_js(){throw new Error("Private method is executed");}
	public boolean getDisable_js() {return disable_js;}


	/**
	 * Reserved
	 */
	private Boolean disable_flash;

	//account setting
	/**
	 * color
	 */
	private String user_color;

	/**
	 * background-color
	 */
	private String user_background;

	/**
	 * Reserved
	 */
	private Boolean user_color_special;
}
