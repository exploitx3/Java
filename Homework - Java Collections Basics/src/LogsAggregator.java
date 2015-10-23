import java.util.*;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Integer size = scanner.nextInt();
        scanner.nextLine();
        StringBuilder fullText = new StringBuilder();
        for (int i = 0; i < size; i++) {
            String currentStr = scanner.nextLine();
            fullText.append(currentStr+"\r\n");
        }
        TreeMap<String,Integer> values = new TreeMap<>();
        TreeMap<String,HashSet<String>> ipAddresses = new TreeMap<>();
        Pattern pattern = Pattern.compile("([\\d\\.]+)(?:[\\s]+)([A-Za-z]+)(?:[\\s]+)([\\d]+)");
        Matcher extractor = pattern.matcher(fullText);
        while(extractor.find()){
            String user = extractor.group(2);
            String ip = extractor.group(1);
            Integer duration = Integer.parseInt(extractor.group(3));
            if(!values.containsKey(user)){
                values.put(user,duration);
                ipAddresses.put(user,new HashSet<>());
                ipAddresses.get(user).add(ip);
            }else{
                values.put(user,values.get(user)+duration);
                ipAddresses.get(user).add(ip);
            }
        }

        for(String key : values.keySet()){
            ArrayList<String> strs = new ArrayList<>();
            ipAddresses.get(key).stream().sorted().forEach(p->strs.add(p));
            System.out.printf("%s: %d [%s]%n", key, values.get(key), String.join(", ", strs));
        }

    }
}
