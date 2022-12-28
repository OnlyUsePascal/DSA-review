package algo.String.PatternSearching.KMP;

public class KMP {

    int patternPrefix[];
    String pattern, text;


    KMP(String _text, String _pattern){
        pattern = _pattern;
        text = _text;
    }


    void handlePattern(){
        int idx = 0;
        for (int i = 1; i < pattern.length(); i++){
            while (idx > 0 && pattern.charAt(idx) != pattern.charAt(i)){
                idx = patternPrefix[idx-1];
            }

            if (pattern.charAt(idx) == pattern.charAt(i)){
                idx++;
            }

            patternPrefix[i] = idx;
        }
    }


    void findMatch(){
        System.out.println("=== KMP ===");

        //handle prefix
        patternPrefix = new int[pattern.length()];
        handlePattern();

        //find match
        int count = 0;
        int idx = 0;
        for (int i = 0; i < text.length(); i++){
            while (idx > 0 && pattern.charAt(idx) != text.charAt(i)){
                idx = patternPrefix[idx - 1];
            }

            if (pattern.charAt(idx) == text.charAt(i)){
                idx++;
            }

            if (idx == pattern.length()){
                System.out.println("Pattern found at idx: " + (i - pattern.length() + 1));
                idx = patternPrefix[idx-1];
            }
        }
    }


    public static void main(String[] args) {
        KMP ex = new KMP("AABAACAADAABAABA", "AABA");
        ex.findMatch();
    }
}
