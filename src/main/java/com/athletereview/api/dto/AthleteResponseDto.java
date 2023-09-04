package com.athletereview.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AthleteResponseDto {
	private List<AthleteDto> content;
	private int pageNo;
	private int pageSize;
	private long totalElement;
	private int totalPages;
	private boolean last;

}
