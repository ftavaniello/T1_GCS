import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;


public class Empresa {
    private ArrayList<Departamento> departamentos;
    private ArrayList<Pedido> pedidos;

    public Empresa(){
        departamentos = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void registrarPedidos(Pedido pedido){
        pedidos.add(pedido);
    }

    public ArrayList pedidosIntervaloTempo(LocalDate dataInicial, LocalDate dataFinal){
        return null;
    }
}
