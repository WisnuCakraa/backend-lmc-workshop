package com.nunu.lmc.Controller;


import com.nunu.lmc.Entity.CompanyProfile;
import com.nunu.lmc.Service.CompanyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/company-profile")
public class CompanyProfileController {
    private final CompanyProfileService companyProfileService;

    @Autowired
    public CompanyProfileController(CompanyProfileService companyProfileService){
        this.companyProfileService = companyProfileService;
    }

    @GetMapping
    public List<CompanyProfile> getAllCategory(){
        return companyProfileService.getCompanyProfile();
    }

    @PostMapping(path = "/maintain")
    public void maintainCompanyProfile(@RequestBody CompanyProfile companyProfile){
        companyProfileService.maintainCompanyProfile(companyProfile);
    }
}
