package com.example.NguyenAnhDo_GK.repository;

import com.example.NguyenAnhDo_GK.model.phongban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IphongbanRepository extends JpaRepository<phongban, Long> {
}