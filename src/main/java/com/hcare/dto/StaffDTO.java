package com.hcare.dto;

import java.util.Date;

import com.hcare.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO {

	private Long id;
	private String email;
	private String firstName;
	private String surname;
	private Date dateInscription;
	private String password;
	private Role role;
}
