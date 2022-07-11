package cn.lofalt.myblog.pojo;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Integer menuId;

    private String menuName;

    private String menuRoutePath;

    private List<Menu> childMenus = new ArrayList<>();
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuRoutePath() {
        return menuRoutePath;
    }

    public void setMenuRoutePath(String menuRoutePath) {
        this.menuRoutePath = menuRoutePath == null ? null : menuRoutePath.trim();
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuRoutePath='" + menuRoutePath + '\'' +
                ", childMenus=" + childMenus +
                '}';
    }

    public List<Menu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Menu> childMenus) {
        this.childMenus = childMenus;
    }
}