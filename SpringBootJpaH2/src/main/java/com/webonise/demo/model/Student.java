package com.webonise.demo.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private int age;
}
