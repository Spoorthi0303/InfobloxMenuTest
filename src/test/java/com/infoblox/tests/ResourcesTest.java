
package com.infoblox.tests;

import com.infoblox.constants.MenuXpath;
import com.infoblox.pages.HomePage;
import com.infoblox.utils.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;

public class ResourcesTest extends BaseTest {

    @Test
    public void testResourcesDropdown() {
        HomePage home = new HomePage(driver);
        List<String> dropdownItems = home.getDropdownItems(MenuXpath.RESOURCES);
        ExcelUtil.writeToSheet("Resources", dropdownItems); 
        //ExcelUtil.saveExcel();
    }
}
