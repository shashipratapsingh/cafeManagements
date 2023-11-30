package com.CafeManegementSystem.CafeManegementSystem.restImpl;

import com.CafeManegementSystem.CafeManegementSystem.Service.UserService;
import com.CafeManegementSystem.CafeManegementSystem.constents.CafeConstants;
import com.CafeManegementSystem.CafeManegementSystem.rest.UserRest;
import com.CafeManegementSystem.CafeManegementSystem.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {
    @Autowired
    private UserService userService;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            return userService.signUp(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
