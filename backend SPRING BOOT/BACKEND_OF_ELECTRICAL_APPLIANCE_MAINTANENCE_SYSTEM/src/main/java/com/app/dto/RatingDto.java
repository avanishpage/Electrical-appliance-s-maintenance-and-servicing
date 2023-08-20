package com.app.dto;

import com.app.enums.Stars;

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
public class RatingDto {
	
	private Stars stars;
	private String description;
	
}
