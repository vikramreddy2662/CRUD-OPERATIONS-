package com.example.LibrarayDataStorage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibrarayDataStorage.Entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{
	
	

}
