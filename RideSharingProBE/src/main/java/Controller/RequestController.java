/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Asmaa
 */
@org.springframework.stereotype.Controller
public class RequestController extends SimpleFormController{
      @RequestMapping(value = "/Deny", method = RequestMethod.GET)
    public String AcceptReq(@RequestParam("id") int id, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("User") != null) {

            String url = "http://localhost:8084/RideSharingProWS/rest/getUser/DenyReq/" + id + ".json";

            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(url, String.class);

            if (result != null) {

                return "redirect:/pending.htm";

            } else {
                return "success";
            }

        } else {
            return "redirect:/login.htm";
        }
    }
    //-------------------------------------------------------------------

    @RequestMapping(value = "/Accept", method = RequestMethod.GET)
    public String DenyReq(@RequestParam("id") int id, Model model, HttpServletRequest request) {

        if (request.getSession().getAttribute("User") != null) {
            String url = "http://localhost:8084/RideSharingProWS/rest/getUser/AcceptReq/" + id + ".json";

            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(url, String.class);

            if (result != null) {

                return "redirect:/pending.htm";

            } else {
                return "login";
            }
        } else {
            return "redirect:/login.htm";
        }

    }
}
