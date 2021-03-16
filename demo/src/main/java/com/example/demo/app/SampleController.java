package com.example.demo.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// ユーザの入出力を取得して、HTMLなどを表示する.
// SpringMVC の Controller を示すアノテーション
@Controller
@RequestMapping("/sample")
public class SampleController {

    private final JdbcTemplate jdbcTemplate;

    // Dependency Injection を使う
    @Autowired
    public SampleController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/test")
    public String test(Model model) {

        String sql = "SELECT * FROM inquiry WHERE id = 1";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);

        model.addAttribute("title", "Inquiry Form");
        model.addAttribute("name", map.get("name"));
        model.addAttribute("email", map.get("email"));
        return "test"; // view にデータを流す
        // 渡した値と共にHTMLにレンダリングされる
    }

}