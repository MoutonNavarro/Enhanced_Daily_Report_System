package actions.views;

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
	 * color
	 */
	private String color;

	/**
	 * background-color
	 */
	private String backgroundColor;

	/**
	 * Language
	 */
	private String language;

	/**
	 * Time zone
	 */
	private String timezone;
}
