import java.util.*;

class Solution
{

    private static class pair<K,V>
    {
        K first;
        V second;
        pair(K first, V second)
        {
            this.first = first;
            this.second = second;
        }
    }
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item[] arr, int n)
    {
        // Your code here
        List<pair<Double,Item>> list = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            double perUnitValue = 1.0 * arr[i].value/arr[i].weight;
            pair<Double,Item> p = new pair<>(perUnitValue,arr[i]);
            list.add(p);
        }

        list.sort((o1, o2) -> o2.first.compareTo(o1.first));

        double totalValue = 0;

        for (int i = 0; i < n; i++)
        {
            if(list.get(i).second.weight > W)
            {
                totalValue += W * list.get(i).first;
                W = 0;
            }
            else
            {
                totalValue += list.get(i).second.value;
                W -= list.get(i).second.weight;
            }
        }

        return totalValue;
    }
}