import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        URLParamParser urlParamParser = new URLParamParser();
        KeyValue exitKeyValue = new KeyValue("exit", "1");

        System.out.println("Enter 'exit=1' to exit");

        while (true) {
            System.out.print("Enter URL to parse: ");
            String urlToParse = scanner.nextLine();
            try {
                KeyValue[] keyValueArray = urlParamParser.parse(urlToParse);

                if(keyValueArray.length == 1 && keyValueArray[0].equals(exitKeyValue)) {
                    return;
                }

                System.out.println(Arrays.toString(keyValueArray));
            } catch (Exception e) {
                System.out.println();
                System.err.println(e);
            }

        }

    }
}
