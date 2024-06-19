package com.example.NguyenAnhDo_GK.controller;

import com.example.NguyenAnhDo_GK.model.nhanvien;
import com.example.NguyenAnhDo_GK.services.nhanvienService;
import com.example.NguyenAnhDo_GK.services.phongbanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class nhanvienController {
    @Autowired
    private nhanvienService nhanvienService;
    @Autowired
    private phongbanService phongbanService;

    @GetMapping
    public String showAllnhanvien (Model model) {
        List<nhanvien> nhanviens = nhanvienService.getAllnhanvien();
        model.addAttribute("nhanvien", nhanviens);
        return "nhanvien/list";
    }
    @GetMapping("/add")
    public  String addnhanvienFrom(Model model){
        model.addAttribute("nhanvien",new nhanvien());
        model.addAttribute("phongbans", phongbanService.getAllphongBans());
        return "/nhanvien/add";
    }
    @PostMapping("/add")
    public String addnhanvien(@Valid @ModelAttribute("nhanvien")nhanvien nv, BindingResult result, Model model){
        if(result.hasErrors())
            return "/nhanvien/add";
        nhanvienService.addnhanvien(nv);
        return "redirect:/nhanviens";
    }

    @GetMapping("/delete/{id}")
    public String deletenhanvien(@PathVariable Long id){
        if(nhanvienService.getnhanvienById(id)==null)
            return "not-found";
        nhanvienService.deletenhanvien(id);
        return "redirect:/nhanviens";
    }

    @GetMapping("/edit/{id}")
    public String editnhanvienForm(@PathVariable Long id, Model model ){
        nhanvien editnhanvien = nhanvienService.getnhanvienById(id);
        if(editnhanvien!=null){
            model.addAttribute("nhanvien", editnhanvien);
            model.addAttribute("phongbans", phongbanService.getAllphongBans());
            return "nhanvien/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit/{id}")
    public String editnhanvien(@PathVariable Long id, @Valid nhanvien updatenhanvien, BindingResult result){
        if(nhanvienService.getnhanvienById(updatenhanvien.getId())==null)
            return "not-found";
        if(result.hasErrors()){
            updatenhanvien.setId(id);
            return "nhanvien/edit";
        }
        nhanvienService.updatenhanvien(updatenhanvien);
        return "redirect:/nhanviens";
    }
}
