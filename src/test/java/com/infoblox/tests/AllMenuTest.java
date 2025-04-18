package com.infoblox.tests;

import com.infoblox.constants.MenuXpath;
import com.infoblox.pages.HomePage;
import com.infoblox.utils.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;

public class AllMenuTest extends BaseTest {

    @Test
    public void testAllDropdowns() {
    HomePage home = new HomePage(driver);

    for (MenuXpath menu : MenuXpath.values()) {
        String cleanName = menu.name().trim().toUpperCase().replace("_", " ");
        System.out.println("Extracting dropdown for menu: " + cleanName);

        List<String> dropdownItems = home.getDropdownItems(menu);
        ExcelUtil.writeToSheet(cleanName, dropdownItems);
    }

    ExcelUtil.saveExcel();
    System.out.println("All menus exported to Excel successfully!");
    }
}
