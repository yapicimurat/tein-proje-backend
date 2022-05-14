package com.example.spring_test.service;


import com.example.spring_test.model.Admin;
import com.example.spring_test.repository.AdminRepository;
import com.example.spring_test.results.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;


    public Result<Admin> login(String username, String password){
        Admin admin = this.adminRepository.findAdminByUsernameAndPassword(username, password);

        if(admin == null)
            return new Result<Admin>(false, null, "Kullanıcı adı veya parola hatalı.");

        return new Result<Admin>(false, admin, "Giriş başarılı.");
    }




}

