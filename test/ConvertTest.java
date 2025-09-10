import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

        mm.addUnit(cm, a -> a / 10);
        cm.addUnit(m, a -> a / 100);
        m.addUnit(km, a -> a / 1000);
        km.addUnit(miles, a -> a * 0.6213712f);

        c = new Unit("celsius");
        f = new Unit("fahrenheit");
        k = new Unit("kelvin");

        c.addUnit(f, input -> (input * 9) / 5 + 32);
        c.addUnit(k, input -> input + 273.15f);
        f.addUnit(c, input -> ((input - 32) * 5) / 9);
    }

    @Test
    void convert_cm_to_m() {
        float initialValue = 200;
        float expectedValue = 2;

        Object checkNull = Convert.convert(cm, m, initialValue);
        assertNotNull(checkNull);
        float result = (float) checkNull;
        assertEquals(expectedValue, result);
    }

    @Test
    void convert_cm_to_km() {
        float initialValue = 200000;
        float expectedValue = 2;

        Object checkNull = Convert.convert(cm, km, initialValue);
        assertNotNull(checkNull);
        float result = (float) checkNull;
        assertEquals(expectedValue, result);
    }

    @Test
    void convert_c_to_f() {
        float initialValue = 37.5f;
        float expectedValue = 99.5f;

        Object checkNull = Convert.convert(c, f, initialValue);
        assertNotNull(checkNull);
        float result = (float) checkNull;
        assertEquals(expectedValue, result);
    }

    @Test
    void convert_f_to_k() {
        float initialValue = 100f;
        float expectedValue = 310.92776f;

        Object checkNull = Convert.convert(f, k, initialValue);
        assertNotNull(checkNull);
        float result = (float) checkNull;
        assertEquals(expectedValue, result);
    }

    @Test
    void convert_c_cm() {
        float initialValue = 100f;

        Object checkNull = Convert.convert(c, cm, initialValue);
        assertNull(checkNull);
    }
}
