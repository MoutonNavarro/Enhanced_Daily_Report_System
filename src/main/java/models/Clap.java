package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
	@NamedQuery(name = JpaConst.Q_CLAP_GET_ALL,
		query = JpaConst.Q_CLAP_GET_ALL_DEF),
	@NamedQuery(name = JpaConst.Q_CLAP_COUNT,
		query = JpaConst.Q_CLAP_COUNT_DEF),
	@NamedQuery(name = JpaConst.Q_CLAP_GET_BY_EMP,
		query = JpaConst.Q_CLAP_GET_BY_EMP_DEF),
	@NamedQuery(name = JpaConst.Q_CLAP_GET_BY_REP_AND_EMP,
		query = JpaConst.Q_CLAP_GET_BY_REP_AND_EMP_DEF)
})
@Getter //Automatically create getter about all class fields(Lombok)
@Setter //Automatically create setter about all class fields(Lombok)
@NoArgsConstructor //Automatically create no arguments constructor
@AllArgsConstructor //Automatically create constructor with arguments that has all class fields as arguments
@Entity
public class Clap {
	/**
	 * Clap ID
	 */
	@Id
	@Column(name = JpaConst.CLAP_COL_ID, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * Report ID
	 */
//	@Id
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
