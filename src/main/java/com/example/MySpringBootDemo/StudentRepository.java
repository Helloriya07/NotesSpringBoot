package com.example.MySpringBootDemo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findByName(String name);

	@Query("From Student s LIMIT:limit")
	List<Student> findByLimit(@Param("limit") int limit);
	

}
