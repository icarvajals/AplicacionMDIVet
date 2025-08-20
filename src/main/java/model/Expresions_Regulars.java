package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Expresions_Regulars {

    private Tokenizer tokenizer;

    public Expresions_Regulars(){
        tokenizer = new Tokenizer();

        // =============================
        // 1. CADENAS Y COMENTARIOS
        // =============================
        tokenizer.add("\"[^\"]*\"", Token.CADENA);     // "texto"
        tokenizer.add("“[^”]*”", Token.CADENA);       // “texto”
        tokenizer.add("//[^\\n]*", Token.COMENTARIO); // comentarios

        // =============================
        // 2. PALABRAS RESERVADAS
        // =============================
        tokenizer.add("\\bBLOQUE\\b", Token.EST_METODOS);
        tokenizer.add("\\bFUNCIONAR\\b", Token.EST_METODOS);
        tokenizer.add("\\bDEVUELVA\\b", Token.EST_METODOS);
        tokenizer.add("\\bMUESTRE\\b", Token.MENSAJE);

        tokenizer.add("\\bSI\\b|\\bHAGA\\b|O\\sSI|SI\\sNO", Token.EST_CONDICIONAL);
        tokenizer.add("\\bRECORRA\\b|HASTA\\sQUE|MIENTRAS\\sQUE", Token.EST_CONTROL);

        tokenizer.add("\\b(PALABRA|NUMERO|FECHA|LISTA DE|AGREGAR|CANTIDAD)\\b", Token.VARIABLE);

        // =============================
        // 3. OPERADORES
        // =============================
        tokenizer.add("->", Token.ASIGNACION);                    // asignación
        tokenizer.add("-/>", Token.OPE_COMPARATIVO);              // no igual
        tokenizer.add("\\+\\+|--|-=|\\+=|VACIO", Token.OPE_COMPARATIVO);
        tokenizer.add("[+\\-*/]", Token.OPE_MAT);                 // + - * /

        // =============================
        // 4. AGRUPADORES Y DELIMITADORES
        // =============================
        tokenizer.add("\\[|\\(|\\{", Token.ABRIR);                // apertura
        tokenizer.add("\\]|\\)|\\}", Token.CERRAR);               // cierre
        tokenizer.add(";", Token.CERRAR);                         // fin de instrucción (lo dejamos en CERRAR)
        tokenizer.add(",", Token.CERRAR);                         // separador también lo tratamos como CERRAR
        tokenizer.add("\\.", Token.CERRAR);                       // acceso a propiedad (lo dejamos en CERRAR)

        // =============================
        // 5. IDENTIFICADORES Y NÚMEROS
        // =============================
        tokenizer.add("[0-9]+", Token.NUMERO);                    // números
        tokenizer.add("[a-zA-Z_][a-zA-Z0-9_]*", Token.VARIABLE);  // variables/identificadores

        // =============================
        // 6. ESPACIOS
        // =============================
        tokenizer.add("\\s+", Token.ESPACIO);
    }

    public String validarExpresion(String contenido) {
        List<String> listaTokens = new ArrayList<>();
        try {
            tokenizer.tokenize(contenido);
            LinkedList<Token> tokens = tokenizer.getTokens();

            for (Token t : tokens) {
                listaTokens.add("Token[" + t.token + "] " + "Lexema: " + t.lexeme + "pos:" + t.pos);
            }

        } catch (LexerException e) {
            System.out.println(e.getMessage());
        }
        return String.join("\n", listaTokens);
    }
}
