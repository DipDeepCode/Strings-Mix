import java.util.ArrayList;
import java.util.List;

public class Mixing {
    private static final int ARR_LENGTH = 26;

    public static String mix(String s1, String s2) {
        String[] sdf1 = abc2(s1);
        String[] sdf2 = abc2(s2);
        List<String> stringList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < ARR_LENGTH; i++) {
            if (sdf1[i].length() > 1 | sdf2[i].length() > 1) {
                if (sdf1[i].length() == sdf2[i].length()) {
                    stringList.add("=:" + sdf1[i]);
                } else {
                    stringList.add(sdf1[i].length() > sdf2[i].length() ? "1:" + sdf1[i] : "2:" + sdf2[i]);
                }
            }
        }

        stringList.stream()
                .sorted((o1, o2) -> {
                    if (o2.length() == o1.length()) return o1.compareTo(o2);
                    else return o2.length() - o1.length();
                })
                .forEach(s -> stringBuilder.append(s).append("/"));
//        stringList.stream()
//                .sorted(new Comparator<String>() {
//                    @Override
//                    public int compare(String o1, String o2) {
//                        if (o2.length() == o1.length()) return o1.compareTo(o2);
//                        else return o2.length() - o1.length();
//                    }
//                })
//                .forEach(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) {
//                        stringBuilder.append(s).append("/");
//                    }
//                });
        if (stringBuilder.length() >= 1) return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
        else return "";
    }

    private static String[] abc2(String str) {
        String[] arr = new String[ARR_LENGTH];
        for (int i = 0; i < ARR_LENGTH; i++) {
            arr[i] = "";
        }
        if (str == null) return arr;
        str.chars()
                .filter(value -> (char) value >= 'a' && (char) value <= 'z')
                .forEach(value -> arr[value - (int) 'a'] += (char) value);
//        str.chars()
//                .filter(new IntPredicate() {
//                    @Override
//                    public boolean test(int value) {
//                        return (char) value >= 'a' && (char) value <= 'z';
//                    }
//                })
//                .forEach(new IntConsumer() {
//                    @Override
//                    public void accept(int value) {
//                        arr[value - (int) 'a'] += (char) value;
//                    }
//                });
        return arr;
    }
}
