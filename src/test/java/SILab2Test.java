import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void checkCartWEmpyList() {
        assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null, 1);
        });
    }

    @Test
    void checkCartWNoBarcode() {
        assertThrows(RuntimeException.class, () -> {
            List<Item> itemList = new ArrayList<>();
            itemList.add(new Item("testItem", null, 123, 0));
            SILab2.checkCart(itemList, 1);
        });
    }

    @Test
    void checkCartWIncorrectBarcode() {
        assertThrows(RuntimeException.class, () -> {
            List<Item> itemList = new ArrayList<>();
            itemList.add(new Item("testItem", "null", 123, 0));
            SILab2.checkCart(itemList, 1);
        });
    }

    @Test
    void checkCartWNoName() {
        assertAll(() -> {
            List<Item> itemList = new ArrayList<>();
            itemList.add(new Item(null, "789", 123, 0));
            SILab2.checkCart(itemList, 1);
        });
    }

    @Test
    void checkCartWSmallPayment() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("testItem", "132423", 123, 0));
        assertFalse(SILab2.checkCart(itemList, 1));
    }

    @Test
    void checkCartWOkPayment() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("testItem", "132423", 123, 0));
        assertTrue(SILab2.checkCart(itemList, 124));
    }

    @Test
    void CheckCartWDiscount() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("testItem", "132543", 100, 0.05F));
        assertTrue(SILab2.checkCart(itemList, 95));
    }

    @Test
    void CheckCartWDiscountN2() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("testItem", "132543", 100, 0.05F));
        assertFalse(SILab2.checkCart(itemList, 50));
    }

}

