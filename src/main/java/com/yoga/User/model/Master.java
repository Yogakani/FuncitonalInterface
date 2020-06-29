/**
 * 
 */
package com.yoga.User.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@MappedSuperclass
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Master implements Serializable {
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = -2136423396418703932L;

	/**
	 * Created By
	 */
	@Column(name="\"CreatedBy\"")
	private long createdBy;
	
	/**
	 * Edited By
	 */
	@Column(name="\"EditedBy\"")
	private long editedBy;
	
	/**
	 * Create Date
	 */
	@Column(name="\"CreateDate\"")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	/**
	 * Modified Date
	 */
	@Column(name="\"ModifiedDate\"")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

}
