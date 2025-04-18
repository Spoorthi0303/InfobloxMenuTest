package com.infoblox.tests;


import com.infoblox.constants.MenuXpath;
import com.infoblox.pages.HomePage;
import com.infoblox.utils.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;

public class CompanyTest extends BaseTest {
    @Test
    public void testCompanyDropdown() {
        HomePage home = new HomePage(driver);
        List<String> dropdownItems = home.getDropdownItems(MenuXpath.COMPANY);
        ExcelUtil.writeToSheet("Company", dropdownItems);
        //ExcelUtil.saveExcel();
    }
}
