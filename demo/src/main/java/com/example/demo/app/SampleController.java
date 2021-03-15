package com.example.demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// ユーザの入出力を取得して、HTMLなどを表示する.
// SpringMVC の Controller を示すアノテーション
@Controller
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("title", "Inquiry Form");

        return "test"; // view にデータを流す
        // 渡した値と共にHTMLにレンダリングされる
    }

}