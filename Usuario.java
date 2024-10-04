public class Usuario {
    private int identificador;
    private String nome;
    private String tipo;
    
    public Usuario(int identificador, String nome, String tipo){
        this.identificador = identificador;

    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

}
