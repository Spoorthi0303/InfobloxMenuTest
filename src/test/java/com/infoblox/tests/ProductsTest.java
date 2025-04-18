package com.infoblox.tests;


import com.infoblox.constants.MenuXpath;
import com.infoblox.pages.HomePage;
import com.infoblox.utils.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTest extends BaseTest {
    @Test
    public void testProductsDropdown() {
        HomePage home = new HomePage(driver);
        List<String> dropdownItems = home.getDropdownItems(MenuXpath.PRODUCTS);
        ExcelUtil.writeToSheet("Products", dropdownItems);
        //ExcelUtil.saveExcel();
    }
}
