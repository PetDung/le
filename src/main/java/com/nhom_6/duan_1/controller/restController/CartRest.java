package com.nhom_6.duan_1.controller.restController;

import com.nhom_6.duan_1.model.req.CartReq;
import com.nhom_6.duan_1.service.BillService;
import com.nhom_6.duan_1.serviceImp.BillServiceImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/cart")
public class CartRest {

    @Autowired
    BillServiceImp billService;
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody CartReq entity, HttpSession session) {
        try {
            billService.updateCart(entity);
            return ResponseEntity.ok("successfully updated");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CartReq entity,
                                 @RequestParam("userid")Long userid,
                                 @RequestParam("color")Long color,
                                 @RequestParam("size")Long size) {
        try {
            billService.addCart(entity,userid,size,color);
            return ResponseEntity.ok("successfully add");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
