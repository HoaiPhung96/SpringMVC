package controller;

import javafx.beans.binding.NumberExpression;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.invoke.empty.Empty;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Optional;

@Controller
public class ControllerCovert {
    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @RequestMapping(value={"/addUpdate","addUpdate/{id}"}, method= RequestMethod.GET)
    public String addUpdate(@PathVariable(value = "id") Optional<String> id,Model model ){
        if (id.isPresent())
            model.addAttribute("Title","Edit");
        else
            model.addAttribute("Title","Add");
        return "addUpdate";

    }
    @RequestMapping(value = "/sent", method = RequestMethod.GET)
    public String sent(@RequestParam(value="rate", required = true) double rate
            , @RequestParam(required = false) String sent, Model model) {

        if (sent == null || sent.isEmpty()){
            model.addAttribute("resout","Loi");
            return "index";
        }

        double conver = Double.parseDouble(sent.toString()) * rate;
        model.addAttribute("resout", conver);
        return "index";

    }

    @RequestMapping(value = {"/sent/{rate1}","/sent/{rate1}/{sent1}", "/sent/{rate1}/{sent1}/{unit}"}, method = RequestMethod.GET)
    public String sent2(@PathVariable(value = "rate1") double rate,
                        @PathVariable(value = "sent1") Optional<String> sent,
                        @PathVariable(value = "unit") Optional<String> unit,
                        Model model) {
        if (!sent.isPresent() ){
            model.addAttribute("resout","Loi");
            model.addAttribute("unit","");
            return "index";
        }
        double conver = Double.parseDouble(sent.get()) * rate;
        if (unit.isPresent())
            model.addAttribute("unit",unit.get());
        else
            model.addAttribute("unit","VND");
        model.addAttribute("resout", conver);
        return "index";

    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam(value="email") String email
            , @RequestParam(value="address",required = false) String address, Model model) {
        model.addAttribute("email", email);
        model.addAttribute("address",address);
        return "result";

    }
    @GetMapping("/test")
    public ModelAndView test(){
        User user = new User();
        user.username= "test";
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("name",user);
        return  modelAndView;
    }
}
