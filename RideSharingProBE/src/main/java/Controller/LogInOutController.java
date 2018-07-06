/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Asmaa
 */
@org.springframework.stereotype.Controller
public class LogInOutController extends SimpleFormController{
     @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    //-------------------------------------------------------------------

    @RequestMapping(value = "/SignOut", method = RequestMethod.GET)
    public String signOut(Model model, HttpServletRequest request) {
        request.getSession().removeAttribute("User");
//        model.addAttribute("user", new User());
        return "redirect:/login.htm";
    }

    //-------------------------------------------------------------------
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginCheck(@ModelAttribute(value = "user") @Valid User u, BindingResult br, Model m, HttpServletRequest request) {

        if (!u.getUserName().equals("") || !u.getPassword().equals("")) {

            String url = "http://localhost:8084/RideSharingProWS/rest/getUser/" + u.getUserName() + "/" + u.getPassword() + ".json";

            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(url,String.class);

            if (result != null) {

                Gson g = new Gson();

                User us = g.fromJson(result, User.class);

                System.out.println(us.getUserName());

//            m.addAttribute("name", us.getUserName());
                request.getSession().setAttribute("User", us);

                return "success";

            } else {
                return "login";
            }

        } else {
            
            return "login";
        }

    }

}
