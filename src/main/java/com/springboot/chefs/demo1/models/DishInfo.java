package com.springboot.chefs.demo1.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class DishInfo {
	@Getter @Setter public int id;
	@Getter @Setter public String dname;
	@Getter @Setter public String ddetail;
	@Getter @Setter public int cid;
}
