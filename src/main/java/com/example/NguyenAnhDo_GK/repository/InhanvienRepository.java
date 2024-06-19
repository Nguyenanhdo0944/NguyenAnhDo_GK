package com.example.NguyenAnhDo_GK.repository;

import com.example.NguyenAnhDo_GK.model.nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InhanvienRepository extends JpaRepository<nhanvien, Long> {
}
