import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.function.Function;

public class Convert {
    public Convert(){}

    /**
     * Method converts from one unit to another.
     * Conversion is done with a Breadth-First Search algorithm to find any possible connections between the initial unit
     * and the target unit for conversion. Should one be found, the number of conversions taking place will be equal to
     * the distance to the target unit.
     * @param initialUnit The object initial unit to be converted from.
     * @param targetUnit The object target unit to be converted to.
     * @param value The initial floating point value to be converted.
     * @return converted value as a float
     */
    public static Object convert(Unit initialUnit, Unit targetUnit, Float value){
        HashSet<Unit> visited = new HashSet<>(); // nodes visited during search
        Queue<Conversion> queue = new ArrayDeque<>(); // nodes to be visited

        Conversion start = new Conversion(initialUnit, value);
        queue.add(start);

        while(!queue.isEmpty()){
            Conversion current = queue.poll();
            visited.add(current.unit);

            Function<Float, Float> finalFunction = current.unit.checkConnection(targetUnit);
            if (finalFunction != null){
                float result = finalFunction.apply(current.conversionResult);
                return result;
            }

            current.unit.conversions.forEach((k,v) -> {
                if(!visited.contains(k)){
                    queue.add(new Conversion(k, v.apply(current.conversionResult)));
                }
            });
        }
        return null;
    }
}
