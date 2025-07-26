package com.erdal.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
	public class CategoryRequest {
		
		
	private Long id;
	
	private String  categoryName;
	
	private String image;
	
	private Long  saloonId;
	
		

		
	
}
