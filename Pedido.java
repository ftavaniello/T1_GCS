import java.time.LocalDate;

public class Pedido {
    private LocalDate dataCriacao; //Obs de gustavo: estou apenas fazendo um teste
    

    public Pedido(LocalDate dataCriacao){
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public String toString() {
        return "data "+ dataCriacao;
    }
}
