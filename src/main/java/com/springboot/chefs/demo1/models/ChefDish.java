package com.springboot.chefs.demo1.models;

import lombok.Getter;
import lombok.Setter;

public class ChefDish {
	@Getter @Setter public int id;
	@Getter @Setter public String cname;
	@Getter @Setter public String address;
	@Getter @Setter public String dname;
	@Getter @Setter public String ddetail;
}
