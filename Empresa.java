import java.time.LocalDate;
import java.util.ArrayList;


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

    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }


    public ArrayList<Pedido> pedidosIntervaloTempo(LocalDate dataInicial, LocalDate dataFinal){
        ArrayList<Pedido> pedidosPeloTempo = new ArrayList<>();
        
        for(int i = 0; i < pedidos.size(); i++){
            if(pedidos.get(i).getDataCriacao().isAfter(dataInicial) && pedidos.get(i).getDataCriacao().isBefore(dataFinal)){
                pedidosPeloTempo.add(pedidos.get(i)); 
            }
        }
        return pedidosPeloTempo;
    }

    public boolean existeUsuario (int n) {
        for (Departamento d : departamentos) {
            for (Usuario u : d.getUsuario()) {
                if (u.getIdentificador() == n) {
                    return true;
                }
            }
        }     
        return false;
    }

    public void adicionaPedido (Pedido p) {
        pedidos.add(p);
    }

    public void removePedido (Pedido p) {
        pedidos.remove(p);
    }

    public ArrayList<Pedido> buscaPorDesc(String desc) {
        ArrayList<Pedido> retorno = new ArrayList<>();
        //ArrayList<Produto> retorno = pedidos.getProdutos();
    
        for (Pedido p : pedidos) {
            for (Produto prod : p.getProdutos()) {
                if (prod.getDescricao().equals(desc)) {
                    retorno.add(p);
                }
            }
        }
        return retorno;
    }

}
