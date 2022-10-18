package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * reaction data's DTO model
 */
@Table(name = JpaConst.TABLE_CLAP)
@Getter //Automatically create getter about all class fields(Lombok)
@Setter //Automatically create setter about all class fields(Lombok)
@NoArgsConstructor //Automatically create no arguments constructor
@AllArgsConstructor //Automatically create constructor with arguments that has all class fields as arguments
@Entity
public class Clap {
	/**
	 * Report ID
	 */
	@Id
	@Column(name = JpaConst.CLAP_COL_REP, nullable = false)
	private Integer report_id;
	/**
	 * Employee ID
	 */
	@Column(name = JpaConst.CLAP_COL_EMP, nullable = false)
	private Integer employee_id;
	/**
	 * Reaction type(reserved)
	 */
	@Column(name = JpaConst.CLAP_COL_REACT, nullable = false)
	private Integer reaction;

}
