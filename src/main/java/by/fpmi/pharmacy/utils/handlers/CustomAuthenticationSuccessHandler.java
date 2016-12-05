package by.fpmi.pharmacy.utils.handlers;


import by.fpmi.pharmacy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by user on 26.10.2015.
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        by.fpmi.pharmacy.model.User  user = userService.readUserByUsername(authUser.getUsername());
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("user", user);

        //set our response to OK status
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        //since we have created our custom success handler, its up to us to where
        //we will redirect the user after successfully login
        httpServletResponse.sendRedirect("/start");
    }
}
