import java.util.HashMap;
import java.util.Map;

public class EnglishWordNumber{

    private static Map<Integer,String> lookup = new HashMap<>();

    static{
        lookup.put(0,"");
        lookup.put(1,"one");
        lookup.put(2,"two");
        lookup.put(3,"three");
        lookup.put(4,"four");
        lookup.put(5,"five");
        lookup.put(6,"six");
        lookup.put(7,"seven");
        lookup.put(8,"eight");
        lookup.put(9,"nine");
        lookup.put(10,"ten");
        lookup.put(11,"eleven");
        lookup.put(12,"twelve");
        lookup.put(13,"thirteen");
        lookup.put(14,"fourteen");
        lookup.put(15,"fifteen");
        lookup.put(16,"sixteen");
        lookup.put(17,"seventeen");
        lookup.put(18,"eighteen");
        lookup.put(19,"nineteen");
        lookup.put(20,"twenty");
        lookup.put(30,"thirty");
        lookup.put(40,"forty");
        lookup.put(50,"fifty");
        lookup.put(60,"sixty");
        lookup.put(70,"seventy");
        lookup.put(80,"eighty");
        lookup.put(90,"ninety");
        lookup.put(100,"hundred");
        
        
    }


    public static void main(String[] args){
        int number = 101;
        String translated = translateNumberToEnglish(number);
        System.out.printf("%d in english is '%s'",number,translated);

    }

    public static String translateNumberToEnglish(int number){
        StringBuilder toReturn = new StringBuilder();
        int split = number;
        for(int i = 0 ; i < String.valueOf(number).length();i++){
            int divider = Double.valueOf(Math.pow(10,(String.valueOf(split).length()-1))).intValue();
            // System.out.printf("divider is %s\n",divider);
            int toPrint = split/divider;
            // System.out.printf("number to print is %s\n",toPrint);
            boolean skipOnes = false;
            switch (divider){
                case 100:
                    toReturn.append(lookup.get(toPrint) + " ");
                    toReturn.append(lookup.get(divider) + " ");
                    break;
                case 10:
                    if(lookup.containsKey(split)){
                        toReturn.append(lookup.get(split));
                        skipOnes = true;
                    }else{
                        toReturn.append(lookup.get(toPrint*10) + " ");
                    }
                    break;
                case 1:
                    toReturn.append("and " + lookup.get(toPrint) + " ");
                    break;
            }
            if(skipOnes) break;
            split = split - (toPrint * divider);
            // System.out.printf("split is %s\n",split);
        }

        // System.out.println(231/100);

        return toReturn.toString().trim();

    }
}