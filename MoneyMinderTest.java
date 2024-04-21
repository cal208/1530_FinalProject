import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MoneyMinderTest {

    @Test
    public void testAddIncome() {
        String input = "100\nStarbucks\n200\nBonus\n0\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Map<String, Object>> incomes = new ArrayList<>();
        MoneyMinder.addIncome(incomes, new Scanner(System.in));

        assertEquals(2, incomes.size());

        Map<String, Object> income1 = incomes.get(0);
        assertEquals(100.0, income1.get("amount"));
        assertEquals("Starbucks", income1.get("source"));

        Map<String, Object> income2 = incomes.get(1);
        assertEquals(200.0, income2.get("amount"));
        assertEquals("Bonus", income2.get("source"));
    }
}
