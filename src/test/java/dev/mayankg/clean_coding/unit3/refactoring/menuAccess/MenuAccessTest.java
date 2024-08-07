package dev.mayankg.clean_coding.unit3.refactoring.menuAccess;

import dev.mayankg.clean_coding.unit3Refactoring.menuAccess.Constants;
import dev.mayankg.clean_coding.unit3Refactoring.menuAccess.MenuAccess;
import dev.mayankg.clean_coding.unit3Refactoring.menuAccess.MenuItem;
import dev.mayankg.clean_coding.unit3Refactoring.menuAccess.Role;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuAccessTest {

    @Test
    void testSetAuthorizationsInEachMenus() {

        Role[] userRoles = {new Role("MenuARead"), new Role("MenuBWrite"),
                new Role("MenuCRead"), new Role("MenuCWrite")};

        MenuItem[] menuItemsArray = {
                new MenuItem("A", "MenuARead", "MenuAWrite"),
                new MenuItem("B", "MenuBRead", "MenuBWrite"),
                new MenuItem("C", "MenuCRead", "MenuCWrite"),
                new MenuItem("D", "MenuDRead", "MenuDWrite")
        };

        List<MenuItem> menuItems = Arrays.asList(menuItemsArray);

        MenuAccess menuAccess = new MenuAccess();

        menuAccess.setAuthorizationsInEachMenus(menuItems, userRoles);

        MenuItem menuItemA = menuItems.get(0);
        assertEquals(Constants.READ, menuItemA.getAccess());
        assertEquals(true, menuItemA.isVisible());

        MenuItem menuItemB = menuItems.get(1);
        assertEquals(Constants.WRITE, menuItemB.getAccess());
        assertEquals(true, menuItemB.isVisible());

        MenuItem menuItemC = menuItems.get(2);
        assertEquals(Constants.WRITE, menuItemC.getAccess());
        assertEquals(true, menuItemC.isVisible());

        MenuItem menuItemD = menuItems.get(3);
        assertEquals(null, menuItemD.getAccess());
        assertEquals(false, menuItemD.isVisible());

    }
}