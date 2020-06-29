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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="\"CompanyUser\"")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class CompanyUser extends Master {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 674131932000213523L;
	
	/**
	 * Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="\"Id\"")
	private long id;
	
	/**
	 * User Id
	 */
	@Column(name="\"UserId\"", unique=true)
	private String userId;
	
	/**
	 * Password
	 */
	@Column(name="\"Password\"")
	private String password;
	
	/**
	 * First Name
	 */
	@Column(name="\"FirstName\"")
	private String firstName;
	
	/**
	 * Last Name
	 */
	@Column(name="\"LastName\"")
	private String lastName;
	
	/**
	 * Email
	 */
	@Column(name="\"Email\"")
	private String email;
	
	/**
	 * Company Id
	 */
	@Column(name="\"CompanyId\"")
	private long companyId;
	
	/**
	 * Role Id
	 */
	@Column(name="\"RoleId\"")
	private long roleId;
	
	/**
	 * Contact Id
	 */
	@Column(name="\"ContactId\"")
	private long contactId;
	
	/**
	 * Company Entity
	 */
	@ManyToOne
	@JoinColumn(name="\"CompanyId\"", insertable = false, updatable = false)
	private Company company;
	
	/**
	 * Contact Entity
	 */
	@OneToOne
	@JoinColumn(name="\"ContactId\"", insertable = false, updatable = false)
	private Contact contact;
	
	/**
	 * Role Entity
	 */
	@ManyToOne
	@JoinColumn(name="\"RoleId\"", insertable = false, updatable = false)
	private Role role;

}
