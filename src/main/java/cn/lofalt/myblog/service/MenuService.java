package cn.lofalt.myblog.service;

import cn.lofalt.myblog.pojo.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {

    public abstract Menu selectByPrimaryKey(Integer menuId);

    public abstract List<Menu> selectAllTopMenu();
}
