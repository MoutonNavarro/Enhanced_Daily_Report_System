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
public class ClapView {
	/**
	 * Clap ID
	 */
	private Integer id;
	/**
	 * Report ID
	 */
	private Integer report_id;
	/**
	 * Employee ID
	 */
	private Integer employee_id;
	/**
	 * Reaction type(reserved)
	 */
	private Integer reaction;
}
