package cn.lofalt.myblog.daotmp;

import java.util.List;

public interface GlobalSettingMapper {
    int deleteByPrimaryKey(Integer settingId);

    int insert(GlobalSetting record);

    GlobalSetting selectByPrimaryKey(Integer settingId);

    List<GlobalSetting> selectAll();

    int updateByPrimaryKey(GlobalSetting record);
}