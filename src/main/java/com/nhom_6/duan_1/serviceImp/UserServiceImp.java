package com.nhom_6.duan_1.serviceImp;

import com.nhom_6.duan_1.model.entity.User;
import com.nhom_6.duan_1.repository.UserResponsitory;
import com.nhom_6.duan_1.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserResponsitory userResponsitory;
    @Override
    public User getLogin(HttpSession session) {
        String email = (String) session.getAttribute("MY_SESSION");
        return userResponsitory.findByEmail(email)
                .orElse(null);
    }

    public User getById(long id){
        return userResponsitory.findById(id)
                .orElse(null);
    }
}
