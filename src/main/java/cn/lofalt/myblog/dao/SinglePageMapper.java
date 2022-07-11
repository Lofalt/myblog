package cn.lofalt.myblog.dao;

import cn.lofalt.myblog.pojo.SinglePage;
import java.util.List;

public interface SinglePageMapper {
    int deleteByPrimaryKey(Integer singlePageId);

    int insert(SinglePage record);

    SinglePage selectByPrimaryKey(Integer singlePageId);

    List<SinglePage> selectAll();

    int updateByPrimaryKey(SinglePage record);
}