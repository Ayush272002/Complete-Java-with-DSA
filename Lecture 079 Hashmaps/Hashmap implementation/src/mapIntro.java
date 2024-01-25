import java.util.HashMap;
import java.util.Map;

public class mapIntro
{
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        Pair p = new Pair("abc", 8);
        map.put(p.name , p.data);
    }
}
