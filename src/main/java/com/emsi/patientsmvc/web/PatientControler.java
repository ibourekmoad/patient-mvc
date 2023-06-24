package com.emsi.patientsmvc.web;

import com.emsi.patientsmvc.entities.Patient;
import com.emsi.patientsmvc.repositories.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientControler {


    private PatientRepo patientRepo;

    @GetMapping(path = "/index")
    public String patients(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name = "Keyword",defaultValue = "") String keyword){
        Page<Patient> patientPage = patientRepo.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listPatients", patientPage.getContent());
        model.addAttribute("pages",new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("currentKw",keyword);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id, String Keyword, int page){
        patientRepo.deleteById(id);
        return "redirect:/index?page="+page+"&Keyword="+Keyword;
    }
    @GetMapping("/")
    public String home(Long id){
        return "redirect:/index";
    }
    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> patientList(){
        return patientRepo.findAll();
    }
}
