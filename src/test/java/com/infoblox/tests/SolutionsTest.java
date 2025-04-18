package com.infoblox.tests;


import com.infoblox.constants.MenuXpath;
import com.infoblox.pages.HomePage;
import com.infoblox.utils.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;

public class SolutionsTest extends BaseTest {
    @Test
    public void testSolutionsDropdown() {
        HomePage home = new HomePage(driver);
        List<String> dropdownItems = home.getDropdownItems(MenuXpath.SOLUTIONS);
        ExcelUtil.writeToSheet("Solutions", dropdownItems);
        //ExcelUtil.saveExcel();
    }
}
