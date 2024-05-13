1 .Control Flow Graph

	Прикачено како слика

2. Цикломатска комплексност

	28 - 24 + 2 = 6

3. Тест случаи според критериумот Every statement

class SILab2Test {

Тест со празна низа
    @Test
    void checkCartWEmpyList() {
        assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null, 1);
        });
    }
Тест со продукт без баркод

    @Test
    void checkCartWNoBarcode() {
        assertThrows(RuntimeException.class, () -> {
            List<Item> itemList = new ArrayList<>();
            itemList.add(new Item("testItem", null, 123, 0));
            SILab2.checkCart(itemList, 1);
        });
    }

Тест со грешен баркод
    @Test
    void checkCartWIncorrectBarcode() {
        assertThrows(RuntimeException.class, () -> {
            List<Item> itemList = new ArrayList<>();
            itemList.add(new Item("testItem", "null", 123, 0));
            SILab2.checkCart(itemList, 1);
        });
    }

Тест со продукт без име
    @Test
    void checkCartWNoName() {
        assertAll(() -> {
            List<Item> itemList = new ArrayList<>();
            itemList.add(new Item(null, "789", 123, 0));
            SILab2.checkCart(itemList, 1);
        });
    }

Тест со мала сума
    @Test
    void checkCartWSmallPayment() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("testItem", "132423", 123, 0));
        assertFalse(SILab2.checkCart(itemList, 1));
    }

Тест со доволна сум
    @Test
    void checkCartWOkPayment() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("testItem", "132423", 123, 0));
        assertTrue(SILab2.checkCart(itemList, 124));
    }

Тест со попуст
    @Test
    void CheckCartWDiscount() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("testItem", "132543", 100, 0.05F));
        assertTrue(SILab2.checkCart(itemList, 95));
    }

Тест со попуст број2 на кој излегува грешка
    @Test
    void CheckCartWDiscountN2() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("testItem", "132543", 100, 0.05F));
        assertFalse(SILab2.checkCart(itemList, 50));
    }

}

4. Сите тест случаи според Multiple Condition критериумот 

Тест случај 1:

    Цена: 350
    Попуст: 50
    Баркод: "0123456789"

Овој случај ги исполнува сите услови (цена > 300, попуст > 0, прва цифра од баркодот == '0').

Тест случај 2:

    Цена: 400
    Попуст: 100
    Баркод: "9123456789"

Овој случај ги исполнува првите два услови, но не и третиот (прва цифра од баркодот != '0').

Тест случај 3:

    Цена: 350
    Попуст: 0
    Баркод: "0123456789"

Овој случај ги исполнува првиот и третиот услов, но не и вториот (попуст == 0).

