public class Main
{
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insertWord("ARM");
        t.insertWord("DO");
        t.insertWord("TIME");
        System.out.println("Word : TIME Present or not  :" + t.search("TIME"));
        System.out.println("Word : TIM Present or not :" + t.search("TIM"));

        System.out.println(t.delete("TIM"));
        System.out.println(t.delete("ARMY"));
        System.out.println("Word : TIM Present or not :" + t.search("TIM"));
        System.out.println("Word : ARM Present or not :" +t.search("ARM"));
    }
}

/*
Time complexity of insertion O(length of word)
Time complexity of searching O(length of word)
 */