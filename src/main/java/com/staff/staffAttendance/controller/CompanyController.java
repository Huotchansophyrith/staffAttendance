//package com.staff.staffAttendance.controller;
//
//import com.staff.staffAttendance.dto.CompanyDto;
//import com.staff.staffAttendance.dto.UserAdDto;
//import com.staff.staffAttendance.mapper.CompanyMapper;
//import com.staff.staffAttendance.mapper.UserAdMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import java.util.Map;
//
//@Controller
//@RequestMapping("company")
//public class CompanyController {
//
//    @Autowired
//    private CompanyMapper companyMapper;
//
//    @Autowired
//    private UserAdMapper userAdMapper;
//
//    @GetMapping
//    public String list(Model model){
//        model.addAttribute("teamOpen", "menu-open");
//        model.addAttribute("comOp", "menu-open");
//        model.addAttribute("lstActive", "active");
//        return "layouts/company/list";
//    }
//
//    @GetMapping("/create")
//    public String create(Model model){
//        model.addAttribute("currentUser", getCurrentLoginUser().getAdm_seq());
//        model.addAttribute("teamOpen", "menu-open");
//        model.addAttribute("comOp", "menu-open");
//        model.addAttribute("addActive", "active");
//        return "layouts/company/create";
//    }
//
//    @GetMapping("/update/{company_seq}")
//    public String update(Model model, @PathVariable int company_seq){
//        CompanyDto comId = this.companyMapper.findAllById(company_seq);
//        Map<String, Object> brName = this.companyMapper.findBranchNameByComId(company_seq);
//        model.addAttribute("currentUser", getCurrentLoginUser().getAdm_seq());
//        model.addAttribute("comId", comId);
//        model.addAttribute("brName", brName);
//        model.addAttribute("action", "update");
//        model.addAttribute("teamOpen", "menu-open");
//        model.addAttribute("comOp", "menu-open");
//        model.addAttribute("addActive", "active");
//        return "layouts/company/create";
//    }
//
//    private UserAdDto getCurrentLoginUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        return this.userAdMapper.findByCurrentUsername(currentPrincipalName);
//    }
//}
