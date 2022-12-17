package algo.looping.String.PatternSearching.RabinKarp;
//https://www.programiz.com/dsa/rabin-karp-algorithm#limitations

public class RabinKarp {
    final int MOD;
    final int hashBase;
    String pattern, text;

    RabinKarp(String _text, String _pattern){
        pattern = _pattern;
        text = _text;
        MOD = (int) 1e9 + 7;
        hashBase = 13;
    }


    int getHash(String s){
        int hash = 0;
        for (int i = 0; i < s.length(); i++){
            hash = (hash * hashBase % MOD + (s.charAt(i) - 'a')) % MOD;
        }
        return hash;
    }


    void findMatch(){
        System.out.println("=== Rabin Karp ===");

        if (pattern.length() > text.length()){
            System.out.println("No match found");
            return;
        }

        //get hash of pattern
        int patternHash = getHash(pattern);

        //get hash of text's substring with length of pattern
        int textHash = getHash(text.substring(0,pattern.length()));

        //precompute
        int base = 1;
        for (int i = 0; i < pattern.length() - 1; i++){
            base = (base * hashBase) % MOD;
        }

        //start sliding
        for (int i = pattern.length() - 1; i < text.length(); i++){
            if (i >= pattern.length()){
                textHash = ((textHash - base * (text.charAt(i - pattern.length()) - 'a') % MOD) * hashBase % MOD
                            + (text.charAt(i) - 'a')) % MOD;
            }

            if (textHash == patternHash){
                System.out.println("Matching at: " + (i - pattern.length() + 1));
            }
        }

    }

    public static void main(String[] args) {
        RabinKarp ex = new RabinKarp("AABAACAADAABAABA", "AABA");
        ex.findMatch();
    }
}
