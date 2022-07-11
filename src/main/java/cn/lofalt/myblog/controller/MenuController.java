package cn.lofalt.myblog.controller;

import cn.lofalt.myblog.pojo.Menu;
import cn.lofalt.myblog.service.MenuService;
import cn.lofalt.myblog.serviceImpl.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuController {

    @Qualifier("menuServiceImp")
    @Autowired
    private MenuService ms;

    @RequestMapping("/menu/{menuId}")
    @ResponseBody
    public Menu selectByPrimaryKey(@PathVariable("menuId") Integer id){
        return ms.selectByPrimaryKey(id);
    }

    @RequestMapping("/menu")
    @ResponseBody
    public List<Menu> selectAllTopMenu() {
        return ms.selectAllTopMenu();
    }
}
