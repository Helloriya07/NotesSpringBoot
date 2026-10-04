package com.example.MySpringBootDemo;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	
	@JsonView(MyViews.UserView.class)
	private String name;
	
	@JsonView(MyViews.UserView.class)
	private double marks;
	
	@JsonView(MyViews.UserView.class)
	private String mobileNo;
	
	@JsonView(MyViews.UserView.class)
	private String college;
	
	@JsonView(MyViews.UserView.class)
	private String department;
	
	@JsonView(MyViews.AdminView.class)
	private double fees;
}

