package cn.lofalt.myblog.dao;

import cn.lofalt.myblog.pojo.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu record);

    Menu selectByParentId(Integer id);

    List<Menu> selectAllTopMenu();
}