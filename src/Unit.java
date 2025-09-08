import java.util.HashMap;
import java.util.function.Function;

/**
 * A class to store the available conversion mappings from one unit to another.
 */
public class Unit {

    /**
     * The unit name, such as mm or millimetre
     */
    String name;
    /**
     * The function, representing the equation to convert from one unit, to another.
     */
    HashMap<Unit, Function<Float, Float>> conversions = new HashMap<>();

    public Unit(String unit){
        this.name = unit;
    }

    /**
     * Checks if there's an immediate connection to another unit, returning a function to allow
     * for this conversion. If an immediate connection is not found, null is returned.
     * @param target Unit to convert to
     * @return A function to correctly convert unit
     */
    public Function<Float, Float> checkConnection(Unit target){
        var immediate = conversions.getOrDefault(target, null);
        return immediate;
    }

    /**
     * Adds a new function to which this unit can be converted to, where the function should be an equation to the
     * conversion.
     * @param newTarget The unit to which a conversion will happen of class Unit
     * @param equation A Function<Float,Float> providing the equation for the conversion
     */
    public void addUnit(Unit newTarget, Function<Float, Float> equation) {
        this.conversions.put(newTarget, equation);
    }
}
