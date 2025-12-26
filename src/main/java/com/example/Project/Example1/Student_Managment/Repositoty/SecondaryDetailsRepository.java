package com.example.Project.Example1.Student_Managment.Repositoty;


import com.example.Project.Example1.Student_Managment.Entity.SecondaryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryDetailsRepository extends JpaRepository<SecondaryDetails, Integer> {
}
