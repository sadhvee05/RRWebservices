package com.rrWebservices.RRWebservices.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mst_accnts" , schema = "cris")
public class StationMsaterEntity {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ACCNT_ID")
	    private Long id;

	    @Column(name = "USR_ID")
	    private String username;

	    @Column(name = "USR_PSSWD")
	    private String password;
	    
	    @Column(name = "ROLE_ID")
	    private String roleId;
}
