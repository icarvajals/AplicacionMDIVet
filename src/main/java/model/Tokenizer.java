package model;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private LinkedList<TokenInfo> tokenInfos;
    private LinkedList<Token> tokens;

    public Tokenizer() {
        super();
        tokenInfos = new LinkedList<TokenInfo>();
        tokens = new LinkedList<Token>();
    }

    public void add(String regex, int token) {
        tokenInfos.add(new TokenInfo(Pattern.compile("^(" + regex + ")"), token));
    }

    public void tokenize(String str) {
        String s = str;
        int index = 0;
        tokens.clear();

        while (!s.isEmpty()) {
            boolean match = false;
            for (TokenInfo info : tokenInfos) {
                Matcher m = info.regex.matcher(s);
                if (m.find()) {
                    match = true;
                    String tok = m.group();

                    if (info.token != Token.ESPACIO) { // ignoramos espacios
                        tokens.add(new Token(info.token, tok, index));
                    }

                    index += tok.length();
                    s = s.substring(tok.length());
                    break;
                }
            }
            if (!match) {
                throw new LexerException("Unexpected character in input: " + s);
            }
        }
    }




    public LinkedList<Token> getTokens() {
        return tokens;
    }
}
