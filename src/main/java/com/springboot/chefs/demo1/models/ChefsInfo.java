package com.springboot.chefs.demo1.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


public class ChefsInfo {
	@Getter @Setter public int id;
	@Getter @Setter public String cname;
	@Getter @Setter public String address;
	@Getter @Setter public String phone;
}
