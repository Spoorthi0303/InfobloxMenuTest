
package com.infoblox.tests;

import com.infoblox.constants.MenuXpath;
import com.infoblox.pages.HomePage;
import com.infoblox.utils.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;

public class WhyInfobloxTest extends BaseTest {
    @Test
    public void testWhyInfobloxDropdown() {
        HomePage home = new HomePage(driver);
        List<String> dropdownItems = home.getDropdownItems(MenuXpath.WHY_INFOBLOX);

        // Just pass the title as you want it displayed
        ExcelUtil.writeToSheet("Why Infoblox", dropdownItems);
    }
}
