package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import java.util.List;
import java.util.ArrayList;

import com.example.demo.SampleData;

@Controller
public class WebController {

    List<SampleData> samples = new ArrayList<>();

    WebController() {
        samples.add(new SampleData("Name", "Hieu"));
        samples.add(new SampleData("City", "Viet Tri"));
        samples.add(new SampleData("Province", "Phu Tho"));
        samples.add(new SampleData("Phone", "0394370708"));
        samples.add(new SampleData("Email", "ngtrunghieu@gmail.com"));
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "Dat") String name, Model model) {

        model.addAttribute("name", name);

        return "hello";
    }

    @GetMapping("/todo")
    public String todo(@RequestParam(name = "todo", required = false, defaultValue = "SpringBoot") String todo,
            Model model) {
        model.addAttribute("todo", todo);
        return "todo";
    }

    @GetMapping("/info")
    public String getInfo(@RequestParam(name = "limit", required = false, defaultValue = "5") String limit,
            Model model) {

        model.addAttribute("info", samples);

        return "info";

    }

    @GetMapping("/sample")
    public String getInfo(Model model) {

        model.addAttribute("sample", new SampleData("Hieu", "Nguyen"));

        return "sample";

    }

    @PostMapping("/addInfo")
    public String addInfo(@ModelAttribute SampleData newsample, Model model) {
        samples.add(newsample);

        System.out.println("Add new Info");

        // model.addAttribute("info", samples);

        return "success";
    }

    @GetMapping("/addInfo")
    public String addTodo(Model model) {
        model.addAttribute("newsample", new SampleData());

        return "addInfo";
    }
}
