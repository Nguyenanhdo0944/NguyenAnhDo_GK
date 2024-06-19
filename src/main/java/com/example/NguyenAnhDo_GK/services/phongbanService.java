package com.example.NguyenAnhDo_GK.services;

import com.example.NguyenAnhDo_GK.model.phongban;
import com.example.NguyenAnhDo_GK.repository.IphongbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class phongbanService {
    @Autowired
    private IphongbanRepository phongBanRepositorty;

    public List<phongban> getAllphongBans() {
        return phongBanRepositorty.findAll();
    }

    public phongban getPhongBanById(Long id) {
        return phongBanRepositorty.findById(id).orElse(null);
    }

    public phongban savePhongBan(phongban phongBan) {
        return phongBanRepositorty.save(phongBan);
    }

    public void deletePhongBan(Long id){
        phongBanRepositorty.deleteById(id);
    }
}
