package cn.lofalt.myblog.dao;

import cn.lofalt.myblog.pojo.GlobalSetting;
import java.util.List;

public interface GlobalSettingMapper {
    int deleteByPrimaryKey(Integer settingId);

    int insert(GlobalSetting record);

    GlobalSetting selectByPrimaryKey(Integer settingId);

    List<GlobalSetting> selectAll();

    int updateByPrimaryKey(GlobalSetting record);
}