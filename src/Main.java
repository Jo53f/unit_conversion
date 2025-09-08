//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var m = new Unit("m");
        var mm = new Unit("mm");
        var km = new Unit("km");

        // meter
        m.addUnit(mm, c -> c*1000);
        var result = m.checkConnection(mm).apply(54f);

        System.out.println(result);
    }
}