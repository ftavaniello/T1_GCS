import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    Scanner entrada = new Scanner (System.in);
    private Empresa empresa;
    
    public App () {
        empresa = new Empresa();
    }

    public void executar() {
        dadosInicias();
        
        //menu inicial
        while (true) {
            int n;
            System.out.println("Bem-vindo ao sistema de pedidos de aquisição.");
            System.out.println("Insira o seu código identificador: [digite -1 para sair]");
            n = entrada.nextInt();
            if (n == -1) {
                break;
            }
            if (empresa.existeUsuario(n)) {
                for (Departamento d : empresa.getDepartamentos()) {
                    for (Usuario u : d.getUsuario()) {
                        if (u.getIdentificador() == n) {
                            if (u.getTipo().equals("Funcionario")) {
                                menuFuncionario(u);
                            }
                            else {
                                //menu do adm
                                menuAdministrador(u);
                            }
                        }
                    }
                }
            }else{
                System.out.println("Usuário não encontrado, tente novamente.");
            }
        }
    }

        //menu administrador
        public void menuAdministrador (Usuario administrador){
            while (true){
                System.out.println(administrador.getNome() + ", o que você deseja fazer? ");
                System.out.println("1 - Solicitar uma aquisição");
                System.out.println("2 - Avaliar solicitações");
                System.out.println("3 - Listar pedidos entre datas");
                System.out.println("4 - Buscar pedidos por funcionário");
                System.out.println("5 - Buscar pedidos por descrição de itens");
                System.out.println("6 - Analisar estatísticas dos pedidos");
                System.out.println("7 - Sair");
                int n = entrada.nextInt();
                if (n == 1) {
                    solicitarPedido(administrador); //mesmo código do funcionário
                }else if (n == 2) {
                    avaliarSolicitacoes();
                }else if (n == 3) {
                    listarPedidosEntreDatas();
                }else if (n == 4) {
                    buscarPedidosPorFuncionario();
                }else if (n == 5) {
                    buscarPedidosPorDescricao();
                }else if (n == 6) {
                    menuEstatisticas(administrador);
                }else if (n == 7) {
                    break;
                }else {
                    System.out.println("Informe uma opção válida.");
                }
            }
        }

        //2 avaliar todas as solicitações
        int id;
        String descricao;
        String funcionario;
        String dataPedido;
        boolean aprovado;
        public void avaliarSolicitacoes() {
            boolean encontrou = false;
            System.out.println("Pedidos abertos:");
            for (Pedido pedido : empresa.getPedidos()) {
                if (!pedido.aprovado) {
                    System.out.println(pedido);
                    encontrou = true;
                }
            }
            if (!encontrou) {
                System.out.println("Não há pedidos abertos para avaliar.");
                return;
            }
            while (true) {
                System.out.print("Digite o ID do pedido que deseja reprovar (ou -1 para voltar): ");
                int id= entrada.nextInt();
                entrada.nextLine();
                if (id == -1) {
                    break;
                }
                boolean pedidoEncontrado = false;
                for (Pedido pedido : empresa.getPedidos()) {
                    if (pedido.id == id && !pedido.aprovado) {
                        System.out.print("Deseja reprovar o pedido (S/N)? ");
                        String resposta = entrada.nextLine();
                        if (resposta.equalsIgnoreCase("S")) {
                            pedido.aprovado = false;
                            System.out.println("Pedido reprovado.");
                        } else {
                            System.out.println("Operação cancelada.");
                        }
                        pedidoEncontrado = true;
                        break;
                    }
                }
                if (!pedidoEncontrado) {
                    System.out.println("Pedido não encontrado.");
                }
                System.out.print("Deseja reprovar mais algum pedido? ");
                String resposta = entrada.nextLine();
                if (!resposta.equalsIgnoreCase("S")) {
                    break;
                }
            }
        }

        //3 listar pedidos entre duas datas
        public void listarPedidosEntreDatas() {
            System.out.print("Digite a data inicial (dd/MM/yyyy): ");
            String dataInicial= entrada.nextLine();
            System.out.print("Digite a data final (dd/MM/yyyy): ");
            String dataFinal = entrada.nextLine();

            for (Pedido pedido : empresa.getPedidos()) {
                if (estaNoIntervalo(pedido.dataPedido, dataInicial, dataFinal)) {
                    System.out.println(pedido);
                }
            }
        }
        public boolean estaNoIntervalo(String dataPedido, String dataInicial, String dataFinal) {
            return dataPedido.compareTo(dataInicial) >= 0 && dataPedido.compareTo(dataFinal) <= 0;
        }

        //4 buscar pedidos por funcionário
        public void buscarPedidosPorFuncionario() {
            System.out.print("Digite o nome do funcionário: ");
            String nome = entrada.nextLine();
            for (Pedido pedido : empresa.getPedidos()) {
                if (pedido.funcionario.equalsIgnoreCase(nome)) {
                    System.out.println(pedido);
                }
            }
        }

        // 5 buscar pedidos pela descrição do item
        public void buscarPedidosPorDescricao() {
            System.out.print("Digite a descrição do item: ");
            String descricao = entrada.nextLine();;
            for (Pedido pedido : empresa.getPedidos()) {
                if (pedido.descricao.toLowerCase().contains(descricao.toLowerCase())) {
                    System.out.println(pedido);
                }
            }
        }

        //6 menu de estatísticas
        public void menuEstatisticas (Usuario administrador) {
            while (true){
                System.out.println(administrador.getNome () + ", qual estatística você deseja ver?");
                System.out.println("1 - Número total de pedidos, dividos por status e seus percentuais");
                System.out.println("2 - Número de pedidos nos últimos 30 dias, e seus valores médios");
                System.out.println("3 - Valor total de cada categoria nos últimos 3 dias");
                System.out.println("4 - Detalhes do pedido de maior valor em aberto");
                System.out.println("5 - Sair");
                int n = entrada.nextInt();
                if (n ==1){
                    calculaPercentual(empresa.getPedidos());
                }else if (n == 2){
                    pedidosUltimos30Dias(empresa.getPedidos());
                }else if (n == 3){
                    maiorPedidoAberto(empresa.getPedidos());
                }else if (n == 4){
                    maiorPedidoAberto(empresa.getPedidos());
                }else if (n == 5){
                    break;
                }else{
                    System.out.println("Informe uma opção válida.");
                }
            }
        }

        //1 método para calcular porcentagem e dividir por apv/rep/con
        public void calculaPercentual(ArrayList<Pedido> pedidos){
            int totalPedidos = pedidos.size();
            double aprovados = 0;
            double reprovados  = 0;
            double concluidos  = 0;
            for(Pedido p : empresa.getPedidos()){
                switch (empresa.getPedidos().getStatus()) {
                    case "Aprovado":
                        aprovados++;
                        break;
                    case "Reprovado":
                        reprovados++;
                        break;
                    case "Concluído":
                    concluidos++;
                        break;
                }
            }
            double percAprovados = (double) aprovados / totalPedidos * 100;
            double percReprovados = (double) reprovados / totalPedidos * 100;
            double percConcluídos = (double) concluidos / totalPedidos * 100;

            System.out.println("A porcentagem de aprovados é de: " + percAprovados + 
            "/nA porcentagem de reprovados é de: " + percReprovados + 
            "/nA porcetnagem de concluídos é de: " + percConcluídos); 
        }

        //2 método para últimos 30 dias e valor médio
        public void pedidosUltimos30Dias(ArrayList<Pedido> pedidos){
            LocalDate hoje = LocalDate.now();
            LocalDate limite = hoje.minusDays(30);
            Map<String, Double> totalPorCategoria = new HashMap<>();

            for (Pedido pedido : pedidos) {
                if (pedido.getDataCriacao().isAfter(limite)) {
                    for (Produto produto : pedido.getProdutos()) {
                        String categoria = produto.getDescricao();
                        totalPorCategoria.put(categoria, totalPorCategoria.getOrDefault(categoria, 0.0) + produto.getValorUnitario());
                    }
                }
            }

            for (String categoria : totalPorCategoria.keySet()) {
                System.out.println("Categoria: " + categoria + ", Valor Total: R$ " + totalPorCategoria.get(categoria));
            }
        }

        //3 valor de cada categoria nos últimos 30 dias
        public void valorPorCategoriaUltimos30Dias(ArrayList<Pedido> pedidos) {
            LocalDate hoje = LocalDate.now();
            LocalDate limite = hoje.minusDays(30);
            Map<String, Double> totalPorCategoria = new HashMap<>();
        
            for (Pedido pedido : pedidos) {
                if (pedido.getDataCriacao().isAfter(limite)) {
                    for (Produto produto : pedido.getProdutos()) {
                        String categoria = produto.getDescricao(); // Ajuste se necessário
                        totalPorCategoria.put(categoria, totalPorCategoria.getOrDefault(categoria, 0.0) + produto.getValorUnitario());
                    }
                }
            }
        
            for (String categoria : totalPorCategoria.keySet()) {
                System.out.println("Categoria: " + categoria + ", Valor Total: R$ " + totalPorCategoria.get(categoria));
            }
        }

        //4 maior valor
        public void maiorPedidoAberto(ArrayList<Pedido> pedidos) {
            Pedido maiorPedido = null;
            double maiorValor = 0;
        
            for (Pedido pedido : pedidos) {
                if (pedido.getStatus().equals("Aberto") && pedido.calculaTotal() > maiorValor) {
                    maiorValor = pedido.calculaTotal();
                    maiorPedido = pedido;
                }
            }
        
            if (maiorPedido != null) {
                System.out.println("Detalhes do maior pedido em aberto:");
                System.out.println(maiorPedido.toString());
            } else {
                System.out.println("Não há pedidos em aberto.");
            }
        }

        //menu funcionário
        public void menuFuncionario (Usuario funcionario) {
            while (true) { 
                System.out.println(funcionario.getNome() + ", o que você deseja fazer? ");
                System.out.println("1 - Solicitar uma aquisição");
                System.out.println("2 - Ver o meu histórico de solicitações");
                System.out.println("3 - Sair");
                int n = entrada.nextInt();
                if (n == 1) {
                    solicitarPedido(funcionario);
                }else if (n == 2) {
                    System.out.println("Histórico de pedidos de " + funcionario.getNome() + ": ");
                    ArrayList<Pedido> pedidosFuncionario = new ArrayList<>();
                    for (Pedido p : empresa.getPedidos()) {
                        if (p.getUsuSolicitante() == funcionario) {
                            pedidosFuncionario.add(p);
                        }
                    }
                    if (pedidosFuncionario.isEmpty()) {
                        System.out.println("Você não realizou nenhum pedido.");
                    }else {
                        int c = 1;
                        for (Pedido x : pedidosFuncionario) {
                            System.out.println("Pedido " + c );
                            System.out.println(x.toString());
                            c++;
                        }
                        System.out.print("Deseja excluir algum pedido? [S/N] ");
                        entrada.nextLine();
                        String r = entrada.nextLine();
                        if (r.toUpperCase().equals("S")){
                            System.out.print("Qual o número do pedido? ");
                            int num = entrada.nextInt();
                            if (pedidosFuncionario.get(num-1).getStatus().equals("Aberto")) {
                                empresa.removePedido(pedidosFuncionario.get(num-1));
                                System.out.println("Pedido removido com sucesso");
                            }else {
                                System.out.println("Houve uma falha: um pedido só pode ser removido se seu status estiver ABERTO");
                            }
                        
                        }else {
                            break;
                        }
                    }
                }else if (n == 3) {
                    break;
                }else {
                    System.out.println("Informe uma opção válida.");
                }
            }
        } 

        public void solicitarPedido (Usuario usuario) {
            Produto p1 = new Produto("Caneta BIC cor azul", "Caneta", 2);
            Produto p2 = new Produto("Bloco de notas", "Bloco de notas", 10);
            Produto p3 = new Produto("Computador", "Computador", 3000);
            Produto p4 = new Produto("Café", "Café", 20);
            Produto p5 = new Produto("Mousepad", "Mousepad", 20);
            ArrayList<Produto> todosProdutos = new ArrayList<>();
            todosProdutos.add(p1);
            todosProdutos.add(p2);
            todosProdutos.add(p3);
            todosProdutos.add(p4);
            todosProdutos.add(p5);

            Departamento depPedido = new Departamento(null, null);
                for (Departamento d : empresa.getDepartamentos()) {
                    for (Usuario u : d.getUsuario()) {
                        if (u == usuario) {
                            depPedido = d;
                            break;
                    }
                }
            }

            ArrayList<Produto> compras = new ArrayList<>();
            
            while (true) {
                System.out.print("Informe o dia de hoje: ");
                int dia = entrada.nextInt();
                System.out.print("Informe o mês: ");
                int mes = entrada.nextInt();

                System.out.println(usuario.getNome() + " qual item abaixo você deseja adquirir? ");
                int contador = 1;
                for (Produto i : todosProdutos) {
                    System.out.println(contador + " - " + i.toString());
                    contador ++;
                }
                System.out.println("Qual desse você deseja adquirir? ");
                int c = entrada.nextInt();
                System.out.println("Quantas unidades? ");
                int qtd = entrada.nextInt();
                entrada.nextLine();
                for (int i = 1; i<=qtd; i++) {
                    compras.add(todosProdutos.get(c-1));
                } 
                System.out.println("Total desse item: R$ " +  todosProdutos.get(c-1).getValorUnitario() * qtd);
                System.out.println("Deseja adicionar mais um item? [S/N]");
                String resp = entrada.nextLine();
                if (resp.toUpperCase().equals("N")) {
                    System.out.println("Revisão do pedido: ");
                    Pedido p = new Pedido (usuario, depPedido, LocalDate.of(2024, mes,dia));
                    p.setProdutos(compras);
                    empresa.adicionaPedido(p);
                    System.out.println(p.toString());
                    break;
                }
            }
        }

        public void dadosInicias() {
        ArrayList <Usuario> usuariosDTI = new ArrayList<>();
        ArrayList <Usuario> usuariosDRH = new ArrayList<>();
        ArrayList <Usuario> usuariosDMarketing = new ArrayList<>();
        ArrayList <Usuario> usuariosDFinanceiro = new ArrayList<>();
        ArrayList <Usuario> usuariosDAdm = new ArrayList<>();

        ArrayList<Departamento> departamentos = new ArrayList<>();
        
        Usuario u1 = new Usuario(1101, "Flavia");
        Usuario u2 = new Usuario(1102, "Gustavo");
        Usuario u3 = new Usuario(1103, "Helena");
        usuariosDTI.add(u1);
        usuariosDTI.add(u2);
        usuariosDTI.add(u3);
        Departamento ti = new Departamento("TI", usuariosDTI);
        departamentos.add(ti);

        Usuario u4 = new Usuario(1104, "Rafaela");
        Usuario u5 = new Usuario(1105, "Giancarlo");
        Usuario u6 = new Usuario(1106, "Pedro");
        usuariosDRH.add(u4);
        usuariosDRH.add(u5);
        usuariosDRH.add(u6);
        Departamento rh = new Departamento("RH", usuariosDRH);
        departamentos.add(rh);

        Usuario u7 = new Usuario(1107, "Arthur");
        Usuario u8 = new Usuario(1108, "Joao");
        Usuario u9 = new Usuario(1109, "Carlos");
        usuariosDMarketing.add (u7);
        usuariosDMarketing.add(u8);
        usuariosDMarketing.add(u9);
        Departamento marketing = new Departamento("Marketing", usuariosDMarketing);
        departamentos.add(marketing);

        Usuario u10 = new Usuario(1110, "Otavio");
        Usuario u11 = new Usuario(1111, "Marcelo");
        Usuario u12 = new Usuario(1112, "Henrique");
        usuariosDFinanceiro.add(u10);
        usuariosDFinanceiro.add(u11);
        usuariosDFinanceiro.add(u12);
        Departamento financeiro = new Departamento("Financeiro", usuariosDFinanceiro);
        departamentos.add(financeiro);

        Usuario u13 = new Usuario(1113, "Isabella");
        Usuario u14 = new Usuario(1114, "Miguel");
        Usuario u15 = new Usuario(1115, "Gustavo");
        Usuario u16 = new Usuario(3301, "Rogerio");
        usuariosDAdm.add(u13);
        usuariosDAdm.add(u14);
        usuariosDAdm.add(u15);
        usuariosDAdm.add(u16);
        Departamento administrativo = new Departamento("Administrativo", usuariosDAdm);
        departamentos.add(administrativo);

        empresa.setDepartamentos(departamentos);

        // Criação de pedidos iniciais e registro
        Pedido pedido1 = new Pedido(u1, ti, LocalDate.of(2024, 10, 4));
        Pedido pedido2 = new Pedido(u4, rh, LocalDate.of(2024, 3, 26));
        Pedido pedido3 = new Pedido(u7, marketing, LocalDate.of(2024, 6, 15));

        // Adicionando produtos ao pedido1
        Produto p1 = new Produto("Caneta BIC cor azul", "Caneta", 2);
        Produto p2 = new Produto("Bloco de notas", "Bloco de notas", 10);
        ArrayList<Produto> produtosPedido1 = new ArrayList<>();
        produtosPedido1.add(p1);
        produtosPedido1.add(p2);
        pedido1.setProdutos(produtosPedido1);

        // Adicionando produtos ao pedido2
        Produto p3 = new Produto("Computador", "Computador", 3000);
        Produto p4 = new Produto("Café", "Café", 20);
        ArrayList<Produto> produtosPedido2 = new ArrayList<>();
        produtosPedido2.add(p3);
        produtosPedido2.add(p4);
        pedido2.setProdutos(produtosPedido2);

        // Adicionando produtos ao pedido3
        Produto p5 = new Produto("Mousepad", "Mousepad", 20);
        ArrayList<Produto> produtosPedido3 = new ArrayList<>();
        produtosPedido3.add(p5);
        pedido3.setProdutos(produtosPedido3);

        // Registrando os pedidos na empresa
        empresa.adicionaPedido(pedido1);
        empresa.adicionaPedido(pedido2);
        empresa.adicionaPedido(pedido3);

    }
}

        // Pedido pedido1 = new Pedido(LocalDate.of(2024, 10, 4));
        // Pedido pedido2 = new Pedido(LocalDate.of(2024,3,26));

        // empresa.registrarPedidos(pedido1);
        // empresa.registrarPedidos(pedido2);

        // empresa.pedidosIntervaloTempo(LocalDate.of(2024,1,1), LocalDate.of(2024,6,1));
        // ArrayList<Pedido> p = empresa.pedidosIntervaloTempo(LocalDate.of(2024,1,1), LocalDate.of(2024,6,1));
        
        // for (Pedido pe : p) {
        //     System.out.println(pe.toString());
        // }