import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    private Usuario usuSolicitante;
    private Departamento depSolicitante;
    private LocalDate dataCriacao; //Obs de gustavo: estou apenas fazendo um teste
    private LocalDate dataConclusao;
    private String status;
    private ArrayList<Produto> produtos;
    private double total;


    public Pedido(Usuario usuSolicitante, Departamento depSolicitante, LocalDate dataCriacao){
        this.usuSolicitante = usuSolicitante;
        this.depSolicitante = depSolicitante;
        this.dataCriacao = dataCriacao;
        produtos = new ArrayList<>();
        this.status = "Aberto";
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        String retorno = "Usuário solicitante: " + this.usuSolicitante.getNome() + "\nData do pedido: " + this.dataCriacao + "\nStatus: " + this.status + "\nProdutos: \n" ;
        for (Produto p : produtos) {
            retorno += p.toString()+"\n";
        }
        retorno += "\nValor total: R$ " + calculaTotal();
        return retorno;
    }

    public Usuario getUsuSolicitante() {
        return usuSolicitante;
    }

    public void setUsuSolicitante(Usuario usuSolicitante) {
        this.usuSolicitante = usuSolicitante;
    }

    public Departamento getDepSolicitante() {
        return depSolicitante;
    }

    public void setDepSolicitante(Departamento depSolicitante) {
        this.depSolicitante = depSolicitante;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void adicionaProduto(Produto p) {
        produtos.add(p);
    }

    public String getStatus () {
        return status;
    }

    public double calculaTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.getValorUnitario();
        }   
        return total;
    }
}

