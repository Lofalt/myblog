package cn.lofalt.myblog.serviceImpl;

import cn.lofalt.myblog.dao.CategoryMapper;
import cn.lofalt.myblog.pojo.Category;
import cn.lofalt.myblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper cm;

    @Override
    public List<Category> selectAll() {

        return cm.selectAll();
    }
}
