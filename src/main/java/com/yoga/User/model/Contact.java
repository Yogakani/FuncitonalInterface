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
@Table(name="Contact")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Contact extends Master {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 2940937085185995260L;
	
	/**
	 * Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	/**
	 * Address
	 */
	@Column(name="address")
	private String address;
	
	/**
	 * City
	 */
	@Column(name="city")
	private String city;
	
	/**
	 * Country
	 */
	@Column(name="country")
	private String country;
	
	/**
	 * Zip Code
	 */
	@Column(name="zipCode")
	private long zipCode;

}
