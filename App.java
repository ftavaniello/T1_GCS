import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    Scanner entrada = new Scanner (System.in);
    private Empresa empresa;
    
    public App () {
        empresa = new Empresa();
    }

    public void executar() {
        
        
        Pedido pedido1 = new Pedido(LocalDate.of(2024, 10, 4));
        Pedido pedido2 = new Pedido(LocalDate.of(2024,3,26));

        empresa.registrarPedidos(pedido1);
        empresa.registrarPedidos(pedido2);

        empresa.pedidosIntervaloTempo(LocalDate.of(2024,1,1), LocalDate.of(2024,6,1));
        ArrayList<Pedido> p = empresa.pedidosIntervaloTempo(LocalDate.of(2024,1,1), LocalDate.of(2024,6,1));
        for (Pedido pe : p) {
            System.out.println(pe.toString());
        }
    }
}
