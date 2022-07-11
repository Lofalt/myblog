package cn.lofalt.myblog.dao;

import cn.lofalt.myblog.pojo.Category;
import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(Category record);

    Category selectByPrimaryKey(Integer categoryId);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);
}