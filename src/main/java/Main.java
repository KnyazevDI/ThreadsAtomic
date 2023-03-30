import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger length3 = new AtomicInteger(0);
        AtomicInteger length4 = new AtomicInteger(0);
        AtomicInteger length5 = new AtomicInteger(0);

        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        new Thread (() -> {
            for (int i = 0; i < texts.length; i++) {
                if (isPalindrome(texts[i])) {
                    if (texts[i].length() == 3) length3.incrementAndGet();
                    if (texts[i].length() == 4) length4.incrementAndGet();
                    if (texts[i].length() == 5) length5.incrementAndGet();
                }
            }
        }).start();

        new Thread (() -> {
            for (int i = 0; i < texts.length; i++) {
                if (oneChar(texts[i])) {
                    if (texts[i].length() == 3) length3.incrementAndGet();
                    if (texts[i].length() == 4) length4.incrementAndGet();
                    if (texts[i].length() == 5) length5.incrementAndGet();
                }
            }
        }).start();

        new Thread (() -> {
            for (int i = 0; i < texts.length; i++) {
                if (isLexicograph(texts[i])) {
                    if (texts[i].length() == 3) length3.incrementAndGet();
                    if (texts[i].length() == 4) length4.incrementAndGet();
                    if (texts[i].length() == 5) length5.incrementAndGet();
                }
            }
        }).start();


        System.out.println("Красивых слов с длиной 3: " + length3 + " шт.");
        System.out.println("Красивых слов с длиной 4: " + length4 + " шт.");
        System.out.println("Красивых слов с длиной 5: " + length5 + " шт.");
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static boolean isPalindrome(String text) {
        return text.replaceAll("\\W","")
                .equalsIgnoreCase(new StringBuilder(text.replaceAll("\\W",""))
                        .reverse().toString());
    }

    public static boolean oneChar(String text) {
        char[] mas = text.toCharArray();
        boolean result = false;
        for (int i = 1; i < mas.length; i++) {
            if (mas[0] != mas[i]) {
                result = false;
                break;
            } else result = true;
        }
        return result;
    }

    public static boolean isLexicograph(String text) {
        boolean result = false;
        char[] chars = text.toCharArray();
        Arrays.sort(chars);
        String str = new String(chars);
        if (text.equals(str)) result = true;
        return result;
    }
}
