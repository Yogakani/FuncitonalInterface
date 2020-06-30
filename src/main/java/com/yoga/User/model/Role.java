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
import javax.persistence.Table;


@Entity
@Table(name="Role")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Role extends Master {
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = 911181746188808664L;

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
	@Column(name="roleName")
	private String name;
}
