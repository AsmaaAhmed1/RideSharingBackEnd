/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
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
public class usersDataController extends SimpleFormController{
     @RequestMapping(value = "/pending", method = RequestMethod.GET)
    public String pending(Model m, @ModelAttribute(value = "user") @Valid User u, HttpServletRequest request) {

        if (request.getSession().getAttribute("User") != null) {

            String url = "http://localhost:8084/RideSharingProWS/rest/getUser/pending.json";

            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(url, String.class);

            if (result != null) {

                Gson g = new Gson();

                List us = g.fromJson(result, List.class);

                List<User> users = new ArrayList<User>();

                for (int i = 0; i < us.size(); i++) {

                    Gson gs = new Gson();

                    User user = gs.fromJson(us.get(i).toString(), User.class);

                    users.add(user);

                }

                if (users.size() <= 0) {

                    m.addAttribute("noUsers", "There is no users");
                    m.addAttribute("name", u.getUserName());

                    return "success";

                }

                m.addAttribute("users", users);

                return "PendingUsers";
            } else {
                m.addAttribute("noUsers", "There is no users");
                m.addAttribute("name", u.getUserName());

                return "success";
            }
        } else {
            return "redirect:/login.htm";
        }
    }
    //-------------------------------------------------------------------

     @RequestMapping(value = "/DeniedUsers", method = RequestMethod.GET)
    public String Denied(Model m, @ModelAttribute(value = "user") @Valid User u, HttpServletRequest request) {

        String url = "http://localhost:8084/RideSharingProWS/rest/getUser/DenyUsers.json";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        if (result != null) {

            Gson g = new Gson();

            List us = g.fromJson(result, List.class);

            List<User> users = new ArrayList<User>();

            for (int i = 0; i < us.size(); i++) {

                Gson gs = new Gson();

                User user = gs.fromJson(us.get(i).toString(), User.class);

                users.add(user);

            }

            if (users.size() <= 0) {

                m.addAttribute("noDeniedUsers", "There is no users");
                m.addAttribute("name", u.getUserName());

                return "success";

            }

            m.addAttribute("DenyUsers", users);

            return "DeniedUsers";
        } else {
            m.addAttribute("noUsers", "There is no users");
            m.addAttribute("name", u.getUserName());

            return "success";
        }

    }
}
