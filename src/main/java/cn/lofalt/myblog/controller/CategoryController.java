package cn.lofalt.myblog.controller;

import cn.lofalt.myblog.pojo.Category;
import cn.lofalt.myblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService cs;


    @RequestMapping("/category")
    @ResponseBody
    public List<Category> selectAll(){
        return cs.selectAll();
    }
}
