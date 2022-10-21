package actions.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.Clap;
import services.EmployeeService;

/**
 * View model that handles input value at the screen and output value about user configure
 */
@Getter //Automatically create getter about all class field (Lombok)
@Setter //Automatically create setter about all class field (Lombok)
@NoArgsConstructor //Automatically create no arguments constructor (Lonbok)
@AllArgsConstructor //Automatically create constructor with arguments that has all class field as argument
public class ClappedEmployeeView {
	/**
	 * Employee Name
	 */
	private String employee_name;
	/**
	 * Employee ID
	 */
	private Integer employee_id;
	/**
	 * Reaction type(reserved/unused)
	 */
	private Integer reaction;
	/**
	 * Employee Foreground color(reserved/unused)
	 */
	private String employee_color;

	/**
	 * Convert from clap list to View model
	 * @param cl Clap list
	 * @return ClappedEmployeeView instance's list
	 * @throws ServletException
	 * @throws IOException
	 */
	public static List<ClappedEmployeeView> toList(List<Clap> cl) throws ServletException, IOException{
		List<ClappedEmployeeView> list = new ArrayList<>(cl.size());
		EmployeeService es = null;
		try {
			es = new EmployeeService();
			ClappedEmployeeView cev = null;
			for(Clap clap : cl) {
				cev = new ClappedEmployeeView(es.findOne(clap.getEmployee_id()).getName(), clap.getReport_id(), clap.getReaction(), null);
				list.add(cev);
			}
		}finally {
			es.close();
		}

		return list;
	}
}
