package com.cy.store.controller;

import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * for errors come in controller
 */
public class BaseController {

    public static final int OK = 200;

    @ExceptionHandler(ServiceException.class) // to handle errors
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("The name has been registered");
        }else if (e instanceof UserNotFoundException){
            result.setState(5001);
            result.setMessage("User not exist");
        }else if (e instanceof PasswordNotMatchException){
            result.setState(5002);
            result.setMessage("Password is not correct");
        } else if (e instanceof InsertException){
            result.setState(5000);
            result.setMessage("fail to register");
        }
        return result;
    }

    /**
     * get uid from session
     * @param session
     * @return uid
     */
    protected final Integer getuidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * get username from session
     * @param session
     * @return String
     */
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
