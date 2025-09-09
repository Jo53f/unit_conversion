import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {

    static Unit mm, cm, m, km, miles;
    static Unit c, f, k;

    @BeforeAll
    static void assignConversions() {
        mm = new Unit("mm");
        cm = new Unit("cm");
        m = new Unit("m");
        km = new Unit("km");
        miles = new Unit("miles");

        mm.addUnit(cm, a -> a/10);
        cm.addUnit(m, a -> a/100);
        m.addUnit(km, a -> a/1000);
        km.addUnit(miles, a -> a*0.6213712f);

        c = new Unit("celsius");
        f = new Unit("fahrenheit");
        k = new Unit("kelvin");

        c.addUnit(f, input -> input*9/5+32);
    }

    @Test
    void convert_cm_to_m() {
        float initalValue = 200;
        float expectedValue = 2;

        float result = Convert.convert(cm, m, initalValue);
        assertEquals(expectedValue, result);
    }

    @Test
    void convert_cm_to_km() {
        float initalValue = 200000;
        float expectedValue = 2;

        float result = Convert.convert(cm, km, initalValue);
        assertEquals(expectedValue, result);
    }

    @Test
    void convert_c_to_f() {
        float initalValue = 37.5f;
        float expectedValue = 99.5f;

        float result = Convert.convert(c, f, initalValue);
        assertEquals(expectedValue, result);
    }
}