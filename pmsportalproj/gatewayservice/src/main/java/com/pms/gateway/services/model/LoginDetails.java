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

@Data
@Entity
@Table(name="UDS_USR_LOGIN_DTLS")
public class LoginDetails implements Serializable {
	
	private static final long serialVersionUID = -8302863140489934703L;

	@Id
	@GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ULD_USER_ID")
	private Integer userId;
	
	@Column(name="ULD_USER_NAME")
	private String userName;
	
	@Column(name="ULD_PASSWORD")
	private String password;
	
	@Column(name="ULD_USER_TYPE")
	private String userType; 
	
	@Column(name="ULD_FORCE_PWD_CHANGE")
	private String forcePwdChange; 
	
	@Column(name="ULD_AGENCY_ID")
	private Integer agencyId; 
	
	@Column(name="ULD_STATUS_ID")
	private Integer statusId; 
	
	
	
	@Column(name="ULD_BROKER_ID")
	private Integer brokerId; 
	
	@Column(name="ULD_LAST_LOGIN_TIME")
	private LocalDateTime lastLoginTime;  
	
	@Column(name="ULD_EFF_START_DT")
	private LocalDateTime ffStartDate;  
	
	@Column(name="ULD_EFF_END_DT")
	private LocalDateTime ffEndDate;  

	@Column(name="ULD_CREATED_BY")
	private String createdBy;  
	
	@Column(name="ULD_CREATED_DATE")
	private LocalDateTime createdDate;  
	
	@Column(name="ULD_UPDATED_BY")
	private String updatedBy;  

	
	@Column(name="ULD_UPDATED_DATE")
	private LocalDateTime updatedDate;  
}
