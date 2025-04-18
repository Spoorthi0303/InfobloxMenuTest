package com.infoblox.constants;
 
public enum MenuXpath {
    WHY_INFOBLOX("//*[@id='menu-primary-menu']/li[1]/a/span", "//*[@id='menu-primary-menu']/li[1]//div//div//div//a"),
    PRODUCTS("//*[@id='menu-primary-menu']/li[2]/a/span", "//*[@id='menu-primary-menu']/li[2]//div//div//div//a"),
    SOLUTIONS("//*[@id='menu-primary-menu']/li[3]/a/span", "//*[@id='menu-primary-menu']/li[3]//div//div//div//a"),
    SUPPORT_SERVICES("//*[@id='menu-primary-menu']/li[4]/a/span", "//*[@id='menu-primary-menu']/li[4]//div//div//div//a"),
    RESOURCES("//*[@id='menu-primary-menu']/li[5]/a/span", "//*[@id='menu-primary-menu']/li[5]//div//div//div//a"),
    COMPANY("//*[@id='menu-primary-menu']/li[10]/a/span", "//*[@id='menu-primary-menu']/li[10]//div//div//div//a");
    //COMPANY("//span[text()='Company']", "//*[@id='menu-primary-menu']/li[6]//ul//a/span");
    //COMPANY("//li[contains(@class,'menu-item')]/a/span[text()='Company']", "//a[ancestor::li[contains(@class,'menu-item') and .//span[text()='Company']]]/span");

    private final String menuXpath;
    private final String dropdownXpath;
 
    MenuXpath(String menuXpath, String dropdownXpath) {
        this.menuXpath = menuXpath;
        this.dropdownXpath = dropdownXpath;
    }
 
    public String getMenuXpath() {
        return menuXpath;
    }
 
    public String getDropdownXpath() {
        return dropdownXpath;
    }
}
