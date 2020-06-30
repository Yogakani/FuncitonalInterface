/**
 * 
 */
package com.yoga.User.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Company")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Company extends Master {
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = -7384887867757788911L;

	/**
	 * Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	/**
	 * Name
	 */
	@Column(name="companyName")
	private String name;
	
	/**
	 * Registration Number
	 */
	@Column(name="companyCode", unique=true)
	private String companyCode;
	
	/**
	 * Logo
	 */
	@Column(name="logo")
	private String logo;
	
	/**
	 * Company Id
	 */
	@Column(name="contactId")
	private long contactId;
	
	@OneToOne
	@JoinColumn(name="contactId", insertable = false, updatable = false)
	private Contact contact;
}
