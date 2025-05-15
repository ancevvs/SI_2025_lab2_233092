import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SILab2Test {

    @Test
    void testEveryStatement() {

        //prazna lista na proizvodi, se frla isklucok i programata zavrsuva
        RuntimeException ex= assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567890123456"));
        assertTrue(ex.getMessage().contains("allItems list can't be null"));

        //validen produkt bez popust, normalen izlez bez isklucok
        Item item2= new Item("Produkt1", 1, 100, 0.0);
        assertEquals(100, SILab2.checkCart(List.of(item2), "1234567890123456"));

        //nevaliden produkt, nema ime
        Item item3 = new Item("", 1, 100, 0.0);
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(item3), "1234567890123456"));
        assertTrue(ex.getMessage().contains("Invalid item"));

        //validen produkt i presmetka so popust, normalen izlez bez isklucok
        Item item4 = new Item("Produkt2", 5, 500, 0.2);
        double res=0;
        res-=30;
        res+= 500 * (1 - 0.2) * 5;
        assertEquals(res, SILab2.checkCart(List.of(item4), "1234567890123456"));

        //nevalidna karticka, nevaliden karakter vo brojot na karticka
        Item item5 = new Item("Produkt3", 1, 100, 0.0);
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(item5), "abc4567890123456"));
        assertTrue(ex.getMessage().contains("Invalid character in card number"));

        //nevalidna karticka, brojot na cifri ne e 16
        Item item6 = new Item("Produkt4", 1, 100, 0.0);
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(item6), "123"));
        assertTrue(ex.getMessage().contains("Invalid card number"));

    }

    @Test
    void testMultipleCondition() {

        double res;
        // item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10

        //T T T
        Item i1 = new Item("Produkt1", 30, 500, 0.5);
        res=0;
        res-=30;
        res+= 500 * (1 - 0.5) * 30;
        assertEquals(res, SILab2.checkCart(List.of(i1), "1234567890123456"));

        //T T F
        Item i2 = new Item("Produkt2", 5, 500, 0.5);
        res=0;
        res-=30;
        res+= 500 * (1 - 0.5) * 5;
        assertEquals(res, SILab2.checkCart(List.of(i2), "1234567890123456"));

        //T F T
        Item i3 = new Item("Produkt3", 30, 500, 0.0);
        res=0;
        res-=30;
        res+=500*30;
        assertEquals(res, SILab2.checkCart(List.of(i3), "1234567890123456"));

        //F T T
        Item i4 = new Item("Produkt4", 30, 100, 0.5);
        res=0;
        res-=30;
        res+= 100 * (1 - 0.5) * 30;
        assertEquals(res, SILab2.checkCart(List.of(i4), "1234567890123456"));

        //T F F
        Item i5 = new Item("Produkt5", 30, 500, 0.0);
        res=0;
        res-=30;
        res+=500*30;
        assertEquals(res, SILab2.checkCart(List.of(i5), "1234567890123456"));

        //F T F
        Item i6 = new Item("Produkt6", 5, 100, 0.5);
        res=0;
        res= 100 * (1 - 0.5) * 5 -30;
        assertEquals(res, SILab2.checkCart(List.of(i6), "1234567890123456"));

        //F F T
        Item i7 = new Item("Produkt7", 30, 100, 0.0);
        res=0;
        res-=30;
        res+=100*30;
        assertEquals(res, SILab2.checkCart(List.of(i7), "1234567890123456"));

        //F F F
        Item i8 = new Item("Produkt8", 5, 100, 0.0);
        res=0;
        res=5*100;
        assertEquals(res, SILab2.checkCart(List.of(i8), "1234567890123456"));
    }
}
