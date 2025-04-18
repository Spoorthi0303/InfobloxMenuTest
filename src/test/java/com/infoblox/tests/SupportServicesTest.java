package com.infoblox.tests;


import com.infoblox.constants.MenuXpath;
import com.infoblox.pages.HomePage;
import com.infoblox.utils.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;

public class SupportServicesTest extends BaseTest {
    @Test
    public void testSupportServicesDropdown() {
        HomePage home = new HomePage(driver);
        List<String> dropdownItems = home.getDropdownItems(MenuXpath.SUPPORT_SERVICES);

        ExcelUtil.writeToSheet("Support Services", dropdownItems);
        //ExcelUtil.saveExcel();
    }
}
