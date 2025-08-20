package model;

public class Token {
    public static final int VARIABLE = 0;
    public static final int OPE_MAT = 1;
    public static final int OPE_COMPARATIVO = 2;
    public static final int ASIGNACION = 3;
    public static final int ABRIR = 4;
    public static final int CERRAR = 5;
    public static final int EST_CONTROL = 6;
    public static final int EST_CONDICIONAL = 7;
    public static final int MENSAJE = 8;
    public static final int EST_METODOS = 9;
    public static final int COMENTARIO = 10;
    public static final int NUMERO = 11;
    public static final int ESPACIO = -1;
    public static final int CADENA;

    static {
        CADENA = 12;
    }


    public final int token;
    public final String lexeme;
    public final int pos;

    public Token(int token, String sequence, int pos) {
        super();
        this.token = token;
        this.lexeme = sequence;
        this.pos = pos;
    }

    public Token clone(){
        return new Token(this.token, this.lexeme, this.pos);
    }
}
