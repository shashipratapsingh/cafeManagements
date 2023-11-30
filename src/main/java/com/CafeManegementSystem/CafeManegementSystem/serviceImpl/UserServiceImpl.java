package com.CafeManegementSystem.CafeManegementSystem.serviceImpl;

import com.CafeManegementSystem.CafeManegementSystem.Dao.UserDao;
import com.CafeManegementSystem.CafeManegementSystem.Service.UserService;
import com.CafeManegementSystem.CafeManegementSystem.constents.CafeConstants;
import com.CafeManegementSystem.CafeManegementSystem.pojo.User;
import com.CafeManegementSystem.CafeManegementSystem.utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signup{}",requestMap);
        try {
            if(ValidationSignUpMap(requestMap)){
                User user=userDao.findByEmailId(requestMap.get("email"));

                if(Objects.isNull(user)){
                    userDao.save(getUserFromMap(requestMap));
                    return CafeUtils.getResponseEntity("Successfully saved",HttpStatus.OK);
                }else {

                    return CafeUtils.getResponseEntity("Email already exist:",HttpStatus.BAD_REQUEST);
                }
            }else {
                return CafeUtils.getResponseEntity(CafeConstants.INVALIDDATA, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);


    }

    private  boolean ValidationSignUpMap(Map<String, String> requestMap)
    {
        if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber") &&
                requestMap.containsKey("email") &&   requestMap.containsKey("password")){
            return  true;
        }
            return false;

    }

    private User getUserFromMap(Map<String,String> requestMap){
        User user=new User();
        user.setName(requestMap.get("name"));
        user.setEmail(requestMap.get("email"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setStatus(requestMap.get("false"));
        user.setRole(requestMap.get("user"));
        return user;
    }
}
