import java.util.ArrayList;

public class TotalDeItens {
    private ArrayList<Produto> todosProdutos;

    public TotalDeItens() {
        this.todosProdutos = new ArrayList<>();
    }

    public ArrayList<Produto> getTodosProdutos() {
        return todosProdutos;
    }

    public void setTodosProdutos(ArrayList<Produto> todosProdutos) {
        this.todosProdutos = todosProdutos;
    }

    public void adicionaProduto(Produto p) {
        todosProdutos.add(p);
    }
    
}
