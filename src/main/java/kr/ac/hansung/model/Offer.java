package kr.ac.hansung.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Offer {
	
	private int id;
	private int year;
	private int semester;
	private String code;
	private String name;
	private String divide;
	private String credit;
	
}
