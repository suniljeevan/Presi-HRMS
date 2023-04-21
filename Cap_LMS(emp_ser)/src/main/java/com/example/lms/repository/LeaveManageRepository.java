package com.example.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.lms.entity.LeaveDetails;

public interface LeaveManageRepository extends JpaRepository<LeaveDetails, Long>{

}