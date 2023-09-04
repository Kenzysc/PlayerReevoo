package com.athletereview.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteDto {
	private int id;
	private String name;
	private String type;
	
}
