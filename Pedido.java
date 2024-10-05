import java.time.LocalDate;

public class Pedido {
    private LocalDate dataCriacao; //Obs de gustavo: estou apenas fazendo um teste
    private String status;

    public Pedido(LocalDate dataCriacao){
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "data "+ dataCriacao;
    }
}
