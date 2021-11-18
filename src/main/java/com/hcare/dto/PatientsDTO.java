package com.hcare.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientsDTO {

	private Long id;
	private String email;
	private String firstName;
	private String surname;
	private Date dateInscription;
	private String password;
}
