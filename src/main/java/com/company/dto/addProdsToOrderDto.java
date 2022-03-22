package com.company.dto;

import lombok.Data;

@Data
//@NoArgsConstructor
public class addProdsToOrderDto {
	long[] prodIds;
	int[] prodQuants;
}
