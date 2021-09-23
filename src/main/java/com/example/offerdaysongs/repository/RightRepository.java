package com.example.offerdaysongs.repository;

import com.example.offerdaysongs.model.Right;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RightRepository extends JpaRepository<Right, Long>, JpaSpecificationExecutor<Right> {
    List<Right> findByCompany_Id(long id);
    List<Right> findByRecording_Id(long id);
}
