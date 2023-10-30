package demoFirst.demoFirst.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/base")
public class BaseController {

    List<String> persons = List.of("John Dupont", "Maria Martez", "Chloée Smith");

    @RequestMapping(value = "/{key}-param")
    public String oneParam(Model model, @PathVariable("key") int id)
    {
        model.addAttribute("persons",persons);
        model.addAttribute("key", id);
        return "base/one-param";
    }

    @RequestMapping(value = "/{key}-param/{secondKey}-param")
    public String oneParam(Model model, @PathVariable("key") int id, @PathVariable("secondKey") int secondKey)
    {
        model.addAttribute("persons",persons);
        model.addAttribute("key", id);
        model.addAttribute("secondKey", secondKey);
        return "base/two-params";
    }

    @RequestMapping(value = "/params")
    public String params(Model model)
    {
        model.addAttribute("persons",persons);
        return "base/params";
    }
}
