package com.webonise.demo.model;
<<<<<<< HEAD

=======
>>>>>>> 567948f4b1a592d602cdb6bbd4177a4cd82a14c3
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
<<<<<<< HEAD
@Getter
@Setter
@ToString
public class Student implements Serializable{
=======
public class Student implements Serializable {
>>>>>>> 567948f4b1a592d602cdb6bbd4177a4cd82a14c3

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private int age;
<<<<<<< HEAD
=======

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
>>>>>>> 567948f4b1a592d602cdb6bbd4177a4cd82a14c3
}
