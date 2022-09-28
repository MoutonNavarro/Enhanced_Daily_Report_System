package actions.views;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * View model that handles screen's input value / output value about report information
 */
@Getter //Automatically create getter about all class field (Lombok)
@Setter //Automatically create setter about all class field (Lombok)
@NoArgsConstructor //Automatically create no arguments constructer (Lombok)
@AllArgsConstructor //Automatically create constructer with arguments that has all class field as argument (Lombok)
public class ReportView {

	/**
	 * ID
	 */
	private Integer id;

	/**
	 * Employee whose registered the report
	 */
	private EmployeeView employee;

	/**
	 * Date indicate when the report is
	 */
	private LocalDate reportDate;

	/**
	 * Report's title
	 */
	private String title;

	/**
	 * Content of the report
	 */
	private String content;

	/**
	 * Date registered
	 */
	private LocalDateTime createdAt;

	/**
	 * Date updated
	 */
	private LocalDateTime updatedAt;
}
