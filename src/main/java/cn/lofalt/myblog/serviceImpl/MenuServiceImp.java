package cn.lofalt.myblog.serviceImpl;

import cn.lofalt.myblog.dao.MenuMapper;
import cn.lofalt.myblog.pojo.Menu;
import cn.lofalt.myblog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImp implements MenuService {

    @Autowired
    private MenuMapper mm;

    @Override
    public Menu selectByPrimaryKey(Integer menuId) {
        return mm.selectByPrimaryKey(menuId);
    }

    @Override
    public List<Menu> selectAllTopMenu() {
        return mm.selectAllTopMenu();
    }
}
