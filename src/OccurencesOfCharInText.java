import java.util.HashMap;

class OccurencesOfCharInText {

    private String alphabet;

    public OccurencesOfCharInText() {
        this.alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public void characterCount(String inputString) {
        String sanitizedText = cleanPlainTextInput(inputString);
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        char[] strArray = sanitizedText.toCharArray();

        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        charCountMap.forEach((k, v) -> {
            float percentage = v / (float)sanitizedText.length() * 100;
            System.out.println(k + " - " + percentage + '%');
        });
    }

    private String cleanPlainTextInput(String text) {
        text = text.replaceAll("\\s+", "");

        for (int x = 0; x < text.length(); x++) {
            int position = alphabet.indexOf(text.charAt(x));

            if (position == -1) {
                text = text.replace(text.charAt(x), ' ');
            }
        }
        return text;
    }
}


