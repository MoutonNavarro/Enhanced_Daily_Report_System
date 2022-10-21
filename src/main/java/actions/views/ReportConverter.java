package actions.views;

import java.util.ArrayList;
import java.util.List;

import colors.ColorNameEnum;
import models.Report;
import services.ConfigureService;

/**
 * Class that mutual convert a report data's DTO model and View model
 */
public class ReportConverter {

	/**
	 * Create instance of DTO model based on instance of View model
	 * @param rv ReportView instance
	 * @return Report instance
	 * @throws NullPointerException In case null as ReportView argument
	 */
	public static Report toModel(ReportView rv) {
		return new Report(rv.getId(),	EmployeeConverter.toModel(rv.getEmployee()),
			rv.getReportDate(),	rv.getTitle(),	rv.getContent(),
			rv.getCreatedAt(),	rv.getUpdatedAt());
	}

	/**
	 * Create instance of View model based on instance of DTO model
	 * @param r Report instance
	 * @return ReportView instance
	 */
	public static ReportView toView(Report r) {

		if (r == null) {
			return null;
		}
		try (ConfigureService cs = new ConfigureService();){
			ConfigureView cv = null;
			if (null == (cv = cs.findOne(r.getEmployee().getId()))){
				cv = ConfigureView.DEFAULT_CV_VIEW;
			}
			ColorNameEnum nullCheck = null;
			if (null != (nullCheck = ColorNameEnum.getByName(cv.getUser_color()))) {
				cv.setUser_color(nullCheck.getCode());
			}
			return new ReportView(r.getId(), EmployeeConverter.toView(r.getEmployee()),
				r.getReportDate(),	r.getTitle(),	r.getContent(),
				r.getCreatedAt(),	r.getUpdatedAt(), cv, null);
		}
	}

	/**
	 * Create a list of View models based on the list of DTO models
	 * @param list DTO models list
	 * @return View models list
	 */
	public static List<ReportView> toViewList(List<Report> list){
		List<ReportView> evs = new ArrayList<>();

		for (Report r : list) {
			evs.add(toView(r));
		}

		return evs;
	}

	/**
	 * Copy all View model's field content to DTO model's field
	 * @param r DTO model (copy to)
	 * @param rv View model (copy from)
	 */
	public static void copyViewToModel(Report r, ReportView rv) {
		r.setId(rv.getId());	r.setEmployee(EmployeeConverter.toModel(rv.getEmployee()));
		r.setReportDate(rv.getReportDate());	r.setTitle(rv.getTitle());
		r.setContent(rv.getContent());	r.setCreatedAt(rv.getCreatedAt());
		r.setUpdatedAt(rv.getUpdatedAt());
	}
}
