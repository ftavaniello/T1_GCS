public class Usuario {
    private int identificador;
    private String nome;
    private String tipo;
    
    public Usuario(int identificador, String nome){
        this.identificador = identificador;
        this.nome = nome;

        String numIdentificador = String.valueOf(identificador);
        String doisPrimeiros = numIdentificador.substring(0, 2);
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

    public void aprovarPedido(Pedido pedido){
        pedido.setStatus("Aprovado");
    }
}
