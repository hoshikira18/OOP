public class Main {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();

        System.out.println(str);
        process(str);
        System.out.println(str);
    }

    public static void process(StringBuilder str) {
        str.append("Processed");
    }
}
