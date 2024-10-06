public class Produto {
    private String nome;
    private String descricao;
    private double valorUnitario;

    public Produto(String descricao, String nome, double valorUnitario) {
        this.descricao = descricao;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    public String toString() {
        return "Nome: " + this.nome + "\nDescrição: " + this.descricao + "\nPreco: R$ " + this.valorUnitario;
    }
    
}
