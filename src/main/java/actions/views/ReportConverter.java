package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Report;

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

		return new ReportView(r.getId(), EmployeeConverter.toView(r.getEmployee()),
			r.getReportDate(),	r.getTitle(),	r.getContent(),
			r.getCreatedAt().plusHours(9),	r.getUpdatedAt().plusHours(9));	//Set UTC+09:00 for view(temporary)
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
		r.setContent(rv.getContent());
		r.setCreatedAt(rv.getCreatedAt().minusHours(9));	r.setUpdatedAt(rv.getUpdatedAt());
	}
}
