package com.nunu.lmc.Service;

import com.nunu.lmc.Entity.CompanyProfile;
import com.nunu.lmc.Repository.CompanyProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyProfileService {

    private final CompanyProfileRepository companyProfileRepository;

    public  CompanyProfileService(CompanyProfileRepository companyProfileRepository){
        this.companyProfileRepository = companyProfileRepository;
    }

    public List<CompanyProfile> getCompanyProfile(){
        return this.companyProfileRepository.findAll();
    }

    public void maintainCompanyProfile(CompanyProfile companyProfile){
        companyProfileRepository.save(companyProfile);
    }
}
