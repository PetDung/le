package com.nhom_6.duan_1.serviceImp;

import com.nhom_6.duan_1.model.entity.User;
import com.nhom_6.duan_1.repository.UserResponsitory;
import com.nhom_6.duan_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserResponsitory userResponsitory;
    @Override
    public User getLogin() {
        return userResponsitory.findById(7L)
                .orElse(null);
    }

    public User getById(long id){
        return userResponsitory.findById(id)
                .orElse(null);
    }
}
