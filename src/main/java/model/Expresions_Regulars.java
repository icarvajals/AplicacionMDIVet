package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Expresions_Regulars {

    private Tokenizer tokenizer;

    public Expresions_Regulars(){
        tokenizer = new Tokenizer();

        tokenizer.add("\\bBLOQUE\\b", Token.EST_METODOS);
        tokenizer.add("\\bFUNCIONAR\\b", Token.EST_METODOS);
        tokenizer.add("\\bDEVUELVA\\b", Token.EST_METODOS);
        tokenizer.add("\\bMUESTRE\\b", Token.MENSAJE);

        tokenizer.add("\\bSI\\b|\\bHAGA\\b|O\\sSI|SI\\sNO", Token.EST_CONDICIONAL);
        tokenizer.add("\\bRECORRA\\b|HASTA\\sQUE|MIENTRAS\\sQUE", Token.EST_CONTROL);

        tokenizer.add("->", Token.ASIGNACION);
        tokenizer.add("-/>", Token.OPE_COMPARATIVO);
        tokenizer.add("\\+\\+|--|-=|\\+=|VACIO", Token.OPE_COMPARATIVO);
        tokenizer.add("[+\\-*/]", Token.OPE_MAT);

        tokenizer.add("\\[|\\(|“", Token.ABRIR);
        tokenizer.add("\\]|\\)|”|;", Token.CERRAR);

        tokenizer.add("//[^\\n]*", Token.COMENTARIO);

        tokenizer.add("[0-9]+", Token.NUMERO);
        tokenizer.add("[a-zA-Z_][a-zA-Z0-9_]*", Token.VARIABLE);

        tokenizer.add("\\s+", Token.ESPACIO);

        tokenizer.add("\"[^\"]*\"", Token.CADENA);
        tokenizer.add("“[^”]*”", Token.CADENA);
    }

    public String validarExpresion(String contenido) {
        List<String> listaTokens = new ArrayList<>();
        try {
            tokenizer.tokenize(contenido);
            LinkedList<Token> tokens = tokenizer.getTokens();

            for (Token t : tokens) {
                listaTokens.add("[" + t.token + "] " + t.lexeme + " at pos " + t.pos);
            }

        } catch (LexerException e) {
            System.out.println(e.getMessage());
        }
        return String.join("\n", listaTokens);
    }
}
