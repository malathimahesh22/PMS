
package com.pms.gateway.services.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * A container class to store and retrieve informations from database tables.
 * This include token details with token expire time limit range.
 *
 */

@Entity
@Table(name = "SDS_TOKEN_DTLS")
@Data
public class TokenDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6576324953564602096L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	@GenericGenerator(name = "increment",strategy="increment")	
	@Column(name = "STD_TOKEN_ID")
	private Integer tokenId;

	@Column(name = "STD_USER_ID")
	private Integer userId;

	@Column(name = "STD_TOKEN")
	private String token;

	@Column(name = "STD_IS_REMEMBER")
	private Integer isRemember;

	@Column(name = "STD_DEVICE_TYPE")
	private String devicetype;

	@Column(name = "STD_CLIENT_IP")
	private String clientIp;

	@Column(name =	 "STD_TOKEN_EXPIRY_TIME")
	private LocalDateTime tokenExpiryTime;
	
	@Column(name = "SCD_CREATED_BY")
	private String creadtedBy;
	
	@Column(name = "SCD_CREATED_DATE")
	private LocalDateTime creadtedDate;

	
	@Column(name = "SCD_UPDATED_BY")
	private String updatedBy;

	@Column(name = "SCD_UPDATED_DATE")
	private LocalDateTime updatedDate;
	

}
