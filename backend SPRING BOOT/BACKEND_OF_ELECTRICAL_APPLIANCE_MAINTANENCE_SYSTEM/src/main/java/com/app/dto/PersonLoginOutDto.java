
package com.app.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.app.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonLoginOutDto {
	
	private Long id;
	
	@NotBlank(message = "first name cannot be blank!!")
	private String firstName;

	@NotBlank(message = "last name cannot be blank!!")
	private String lastName;
	
	@NotBlank(message = "email is mandatory!!")
	@Email
	private String email;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String city;
	
	@NotBlank(message = "phone number cannot be blank!!")
	private String phoneNumber;

	
	
	
	public PersonLoginOutDto(@NotBlank(message = "first name cannot be blank!!") String firstName,
			@NotBlank(message = "last name cannot be blank!!") String lastName,
			@NotBlank(message = "email is mandatory!!") @Email String email,
			@NotBlank(message = "address cannot be blank!!") String address,
			@NotBlank(message = "phone number cannot be blank!!") String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
