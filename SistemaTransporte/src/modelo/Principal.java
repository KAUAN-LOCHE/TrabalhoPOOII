package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import controlador.SistemaTransporte;
//CLASSE QUE SERVIRÁ PARA TESTES E IMPLEMENTAÇÕES FUTURAS
import modelo.enums.TipoAssento;
import java.util.Scanner;


public class Principal {
    static Scanner scan;

    public Principal(){
        scan = new Scanner(System.in);
    }

    public void AlimentarSistema(){
        SistemaTransporte sis = SistemaTransporte.getInstance();

        //Criacao de 5 Motoristas com dados ficticios e variados
        sis.createMotorista("Maria", 45, "98765432100", "5678", "654321", 10, "Sou", "Jardim Europa/Santa Clara");
        sis.createMotorista("Carlos", 28, "12312312312", "8765", "789456", 3, "Sou", "Vila Nova/Centro");
        sis.createMotorista("Ana", 35, "32132132132", "4321", "147258", 7, "Jandaia", "Alvorada/Parque das Flores");
        sis.createMotorista("Pedro", 50, "45645645645", "9101", "369258", 15, "Jandaia", "Jardim Bela Vista/Planalto");
        sis.createMotorista("Fernanda", 32, "78978978978", "6543", "852741", 8, "Andorinha", "Santa Mônica/São Cristóvão");
        sis.createMotorista("Luis", 40, "11223344556", "2109", "963852", 6, "Andorinha", "Centro/Nova Cidade");
        sis.createMotorista("Bruna", 29, "99887766554", "3456", "159753", 4, "Andorinha", "Alameda/Vila Nova");

        //Criação de 20 Paradas com endereços ficticios e variados
        sis.createParada("Rua 1, 123");
        sis.createParada("Rua 2, 456");
        sis.createParada("Rua 3, 789");
        sis.createParada("Rua 4, 101");
        sis.createParada("Rua 5, 112");
        sis.createParada("Rua 6, 131");
        sis.createParada("Rua 7, 415");
        sis.createParada("Rua 8, 161");
        sis.createParada("Rua 9, 171");
        sis.createParada("Rua 10, 181");
        sis.createParada("Rua 11, 191");
        sis.createParada("Rua 12, 201");
        sis.createParada("Rua 13, 211");
        sis.createParada("Rua 14, 221");
        sis.createParada("Rua 15, 231");
        sis.createParada("Rua 16, 241");
        sis.createParada("Rua 17, 251");
        sis.createParada("Rua 18, 261");
        sis.createParada("Rua 19, 271");
        sis.createParada("Rua 20, 281");

        //Criação de 6 Onibus
        sis.createOnibus(10, 5, 2, 3, sis.getMotoristas().get(0), 1, 1);    
        sis.createOnibus(15, 6, 3, 3, sis.getMotoristas().get(1), 2, 2);
        sis.createOnibus(20, 7, 4, 4, sis.getMotoristas().get(2), 3, 3);
        sis.createOnibus(25, 8, 5, 5, sis.getMotoristas().get(3), 4, 4);
        sis.createOnibus(30, 9, 6, 6, sis.getMotoristas().get(4), 5, 5);
        sis.createOnibus(35, 10, 7, 7, sis.getMotoristas().get(5), 6, 6);

        //Criação de 35 Passageiros com dados ficticios e variados, dependendo da idade, o tipo de assento é definido se é COMUM ou IDOSO. 
        //Além disso, há assentos para CADEIRANTE e PLUS_SIZE. CRIE TODOS OS TIPOS DE ASSENTO
        //Telefone deve seguir o padrão (XX)XXXXX-XXXX

        sis.createPassageiro("João", 25, "12345678900", "1234", "Rua 1, 123", "(12)3456-7890", TipoAssento.COMUM);
        sis.createPassageiro("Maria", 65, "98765432100", "5678", "Rua 2, 456", "(98)7654-3210", TipoAssento.IDOSO);
        sis.createPassageiro("Carlos", 30, "12312312312", "8765", "Rua 3, 789", "(12)3123-1231", TipoAssento.COMUM);
        sis.createPassageiro("Ana", 70, "32132132132", "4321", "Rua 4, 101", "(32)1321-3213", TipoAssento.IDOSO);
        sis.createPassageiro("Pedro", 35, "45645645645", "9101", "Rua 5, 112", "(45)6456-4564", TipoAssento.COMUM);
        sis.createPassageiro("Fernanda", 75, "78978978978", "6543", "Rua 6, 131", "(78)9789-8978", TipoAssento.IDOSO);
        sis.createPassageiro("Luis", 40, "11223344556", "2109", "Rua 7, 415", "(11)2233-4455", TipoAssento.COMUM);
        sis.createPassageiro("Bruna", 80, "99887766554", "3456", "Rua 8, 161", "(99)8877-6655", TipoAssento.IDOSO);
        sis.createPassageiro("Mariana", 45, "12345678900", "1234", "Rua 9, 171", "(12)3456-7890", TipoAssento.COMUM);
        sis.createPassageiro("Marcos", 85, "98765432100", "5678", "Rua 10, 181", "(98)7654-3210", TipoAssento.IDOSO);
        sis.createPassageiro("Carla", 50, "12312312312", "8765", "Rua 11, 191", "(12)3123-1231", TipoAssento.COMUM);
        sis.createPassageiro("Antonio", 90, "32132132132", "4321", "Rua 12, 201", "(32)1321-3213", TipoAssento.IDOSO);
        sis.createPassageiro("Paulo", 55, "45645645645", "9101", "Rua 13, 211", "(45)6456-4564", TipoAssento.COMUM);
        sis.createPassageiro("Fernanda", 95, "78978978978", "6543", "Rua 14, 221", "(78)9789-8978", TipoAssento.IDOSO);
        sis.createPassageiro("Luiz", 60, "11223344556", "2109", "Rua 15, 231", "(11)2233-4455", TipoAssento.COMUM);
        sis.createPassageiro("Bruno", 100, "99887766554", "3456", "Rua 16, 241", "(99)8877-6655", TipoAssento.IDOSO);
        sis.createPassageiro("Mariana", 65, "12345678900", "1234", "Rua 17, 251", "(12)3456-7890", TipoAssento.COMUM);
        sis.createPassageiro("Marcos", 105, "98765432100", "5678", "Rua 18, 261", "(98)7654-3210", TipoAssento.IDOSO);
        sis.createPassageiro("Carla", 70, "12312312312", "8765", "Rua 19, 271", "(12)3123-1231", TipoAssento.COMUM);
        sis.createPassageiro("Antonio", 110, "32132132132", "4321", "Rua 20, 281", "(32)1321-3213", 
TipoAssento.IDOSO);
        sis.createPassageiro("Paulo", 75, "45645645645", "9101", "Rua 21, 291", "(45)6456-4564", TipoAssento.IDOSO);
        sis.createPassageiro("Fernanda", 120, "78978978978", "6543", "Rua 22, 301", "(78)9789-8978", TipoAssento.IDOSO);
        sis.createPassageiro("Luiz", 80, "11223344556", "2109", "Rua 23, 311", "(11)2233-4455", TipoAssento.IDOSO);


        //Crie assentos para CADEIRANTE e PLUS_SIZE
        sis.createPassageiro("Paulo", 75, "45645645645", "9101", "Rua 21, 291", "(45)6456-4564", TipoAssento.CADEIRANTE);
        sis.createPassageiro("Fernanda", 120, "78978978978", "6543", "Rua 22, 301", "(78)9789-8978", TipoAssento.PLUS_SIZE);
        sis.createPassageiro("Luiz", 80, "11223344556", "2109", "Rua 23, 311", "(11)2233-4455", TipoAssento.CADEIRANTE);
        sis.createPassageiro("Bruno", 125, "99887766554", "3456", "Rua 24, 321", "(99)8877-6655", TipoAssento.PLUS_SIZE);
        sis.createPassageiro("Mariana", 85, "12345678900", "1234", "Rua 25, 331", "(12)3456-7890", TipoAssento.CADEIRANTE);

        //Alocar passageiros em assentos de onibus variados dos criados anteriormente

        //Onibus 1
        
        //Exibi Todos os Motoristas
        ArrayList<Motorista> motoristas = sis.getMotoristas();
        for(Motorista motorista: motoristas){
            System.out.println(motorista.toString());
            System.out.println("\n==============================\n");
        }
    }

    /**
     * Método de teste
     */
    public void Teste1(){
        SistemaTransporte sis = SistemaTransporte.getInstance();

        // Criação de um passageiro
        Passageiro passageiroComum = sis.createPassageiro("Marcos", 42, "123456789", "4321", "outro endereço", "123321",
                TipoAssento.COMUM);
        // Criação de um motorista
        Motorista motorista = sis.createMotorista("João", 30, "123456789", "1234", "123456", 5, "Empresa", "Linha");

        // Criação de um ônibus
        Onibus onibus = sis.createOnibus(7, 3, 1, 2, motorista, 1, 1);

        // Criação de uma parada
        Parada local1 = sis.createParada("endereco de teste1");
        Parada local2 = sis.createParada("endereco de teste2");
        Parada local3 = sis.createParada("endereco de teste3");

        // Criação de uma array de paradas com horários
        ParadaDecorator parada1 = sis.createParadaDecorator(local1, LocalDateTime.parse("2024-11-10T10:15:30"));
        ParadaDecorator parada2 = sis.createParadaDecorator(local2, LocalDateTime.parse("2024-11-10T10:35:30"));
        ParadaDecorator parada3 = sis.createParadaDecorator(local3, LocalDateTime.parse("2024-11-10T10:45:30"));

        ArrayList<ParadaDecorator> paradas = new ArrayList<ParadaDecorator>();
        paradas.add(parada1);
        paradas.add(parada2);
        paradas.add(parada3);

        // Criação de uma viagem
        sis.createViagemOnibus(onibus, paradas);

        /*
         * A criação da viagem do passageiro seguiria o seguinte fluxo:
         * - Passageiro (usuário) seleciona a parada de destino
         * - Abre tela de exibição das ViagensOnibus que tem essa parada no trajeto e de
         * onde elas saem
         * - Passageiro seleciona a viagem que ele quer
         * 
         * Tendo em vista que esse fluxo foi seguido, ocorreriam as seguintes chamadas
         */

        ParadaDecorator destinoSelecionado = parada2;

        var tipoAssentoPassageiro1 = passageiroComum.getTipoAssento();

        ArrayList<Viagem> viagensDisponiveis = sis.getAllViagensOnibusByDestino(destinoSelecionado, tipoAssentoPassageiro1);
        Viagem viagemSelecionada = viagensDisponiveis.get(0);
        ArrayList<Number> posicoesDisponiveis = viagemSelecionada.getVeiculo().getPosicoesDisponiveis(tipoAssentoPassageiro1);
        Number posicaoSelecionada = posicoesDisponiveis.get(0);
        ParadaDecorator embarqueSelecionado = viagemSelecionada.getParadas().get(0);

        // Gera um bilhete para a viagem
        sis.createBilhete(passageiroComum, viagemSelecionada, embarqueSelecionado, destinoSelecionado, posicaoSelecionada.intValue(), LocalDateTime.now());

        System.out.println("Viagem do passageiro criada com sucesso!");

        /*
         * Quando uma um veiculo passar por uma de suas paradas,
         * o método visitarParada da viagem em questão é invocado
         * e a parada em questão é passada por parâmentro, assim 
         * finalizando a viagem do passageiro e atualizando o 
         * bilhete eletrônico.
         */
        System.out.println("Passageiro esta em viagem?\nR: " + passageiroComum.getEmViagem());
        viagemSelecionada.visitarParada(destinoSelecionado.parada);
        System.out.println("Onibus passou pela parada.");
        System.out.println("Passageiro esta em viagem?\nR: " + passageiroComum.getEmViagem());
    }


    /**
     * Menu de inicialização
     */
    public void menuInicializacao(){
        System.out.println("\n\n=================================================");  
        System.out.println("|BEM-VINDO AO SISTEMA DE TRANSPORTE             |");
        System.out.println("=================================================");
        System.out.println("|1 - Modo Administrador                         |");
        System.out.println("|2 - Modo Cliente                               |");
        System.out.println("|3 - Sair                                       |");
        System.out.println("=================================================");
        System.out.println("Digite a opção desejada: ");
    }

    /**
     * Menu do Administrador
     */
    public void menuAdministrador(){
        System.out.println("\n\n=================================================");  
        System.out.println("|BEM-VINDO AO MODO ADMINISTRADOR                 |");
        System.out.println("=================================================");
        System.out.println("|1 - Cadastrar Onibus                            |");
        System.out.println("|2 - Cadastrar Motorista                         |");
        System.out.println("|3 - Cadastrar Passageiro                        |");
        System.out.println("|4 - Cadastrar Parada                            |");
        System.out.println("|5 - Cadastrar Viagem                            |");
        System.out.println("|6 - Buscar:                                     |");
        System.out.println("|7 - Alterar:                                    |");
        System.out.println("|8 - Exibir:                                     |");
        System.out.println("|9 - Excluir:                                    |");
        System.out.println("|10 - Voltar                                     |");
        System.out.println("==================================================");
        System.out.println("Digite a opção desejada: ");
    }

    /**
     * Menu de busca
     */
    public void BuscarAdm(){
        SistemaTransporte sis = SistemaTransporte.getInstance();
        int opcaoBuscar;
        int numVeiculo;
        System.out.println("\n\n=================================================");  
        System.out.println("|BEM-VINDO AO MODO DE BUSCA                      |");
        System.out.println("=================================================");
        System.out.println("|1 - Buscar Motorista                            |");
        System.out.println("|2 - Buscar Passageiro                           |");
        System.out.println("|3 - Buscar Onibus                               |");
        System.out.println("|4 - Buscar Parada                               |");
        System.out.println("|5 - Buscar Viagem                               |");
        System.out.println("|6 - Buscar ParadaDecorator                      |");
        System.out.println("|7 - Buscar Bilhete                              |");
        System.out.println("|8 - Voltar                                      |");
        System.out.println("==================================================");
        System.out.println("Digite a opção desejada: ");
        opcaoBuscar = scan.nextInt();

        if(opcaoBuscar == 8){
            return;
        }

        switch(opcaoBuscar){
            case 1: 
                
                System.out.println("Digite o numero do veículo: ");
                numVeiculo = scan.nextInt();

                Motorista motorista = sis.getMotorista(numVeiculo);
                System.out.println(motorista.toString());
                break;
            
        
            case 2:
                String cpfPassageiro;
                System.out.println("Digite o CPF do Passageiro: ");
                cpfPassageiro = scan.nextLine();
                System.out.println("Digite o Número do Veículo: ");
                numVeiculo = scan.nextInt();

                Passageiro passageiro = sis.getPassageiro(numVeiculo, cpfPassageiro);
                passageiro.toString();

                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            case 7:
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }

    }

    /**
     * Menu de alteração
     */
    public void AlterarAdm(){
        int opcaoAlterar;
        System.out.println("\n\n=================================================");  
        System.out.println("|BEM-VINDO AO MODO DE ALTERAÇÃO                  |");
        System.out.println("=================================================");
        System.out.println("|1 - Alterar Motorista                           |");
        System.out.println("|2 - Alterar Passageiro                          |");
        System.out.println("|3 - Alterar Onibus                              |");
        System.out.println("|4 - Alterar Parada                              |");
        System.out.println("|5 - Alterar Viagem                              |");
        System.out.println("|6 - Voltar                                      |");
        System.out.println("==================================================");
        System.out.println("Digite a opção desejada: ");
        opcaoAlterar = scan.nextInt();

        if(opcaoAlterar == 6){
            return;
        }

        switch(opcaoAlterar){
            case 1: 
                break;
        
            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    /**
     * Exibir dados do sistema
     */
    public void ExibirAdm(){
        SistemaTransporte sis = SistemaTransporte.getInstance();
        int opcaoExibir;
        System.out.println("\n\n=================================================");  
        System.out.println("|BEM-VINDO AO MODO ADMINISTRADOR                 |");
        System.out.println("=================================================");
        System.out.println("|1 - Exibir Motoristas                           |");
        System.out.println("|2 - Exibir Passageiros de um Ônibus             |");
        System.out.println("|3 - Exibir Onibus                               |");
        System.out.println("|4 - Exibir Paradas                              |");
        System.out.println("|5 - Exibir Viagens                              |");
        System.out.println("|6 - Voltar                                      |");
        System.out.println("==================================================");
        System.out.println("Digite a opção desejada: ");
        opcaoExibir = scan.nextInt();

        if(opcaoExibir == 6){
            return;
        }

        switch(opcaoExibir){
            case 1: 
                ArrayList<Motorista> motoristas = sis.getMotoristas();
                for(Motorista motorista: motoristas){
                    motorista.toString();
                    System.out.println("\n==============================\n");
                }
                break;
        
            case 2:
                System.out.println("Digite o Número do Ônibus: ");
                int numOnibus = scan.nextInt();
                Assento[] assentos = sis.getAssentos(numOnibus);
                for(Assento assento: assentos){
                    assento.toString();
                    System.out.println("\n==============================\n");
                }

                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    /**
     * Menu do Cliente 
     */
    public void menuCliente(){
        System.out.println("\n\n=================================================");  
        System.out.println("|BEM-VINDO AO MODO CLIENTE                       |");
        System.out.println("=================================================");
        System.out.println("|1 - Comprar Passagem                            |");
        System.out.println("|2 - Cancelar Passagem                           |");
        System.out.println("|3 - Exibir Viagens                              |");
        System.out.println("|4 - Exibir Paradas                              |");
        System.out.println("|6 - Voltar                                      |");
        System.out.println("=================================================");
    }



    public static void main(String[] args) {
        Principal main= new Principal();
        main.Teste1();
        main.AlimentarSistema();
        int opcaoInicializacao, opcaoAdministrador, opcaoCliente;

        while (true){
            main.menuInicializacao();   
            opcaoInicializacao = scan.nextInt();

            if(opcaoInicializacao == 3){
                break;
            }

            switch(opcaoInicializacao){
                case 1: 
                    /**
                     * MENU DO ADMINISTRADOR
                     */
                    while (true){
                        main.menuAdministrador();
                        opcaoAdministrador = scan.nextInt();

                        if(opcaoAdministrador == 10){
                            break;
                        }

                        switch(opcaoAdministrador){
                            case 1: 
                                break;
                        
                            case 2:
                                break;

                            case 3:
                                break;

                            case 4:

                                break;

                            case 5:
                                break;

                            case 6:
                                main.BuscarAdm();
                                break;

                            case 7:
                                break;

                            case 8:
                                break;

                            case 9:
                                break;
                                
                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                    }
                case 2:
                    /**
                     * MENU DO CLIENTE
                     */
                    while (true){
                        main.menuCliente();
                        opcaoCliente = scan.nextInt();

                        if(opcaoCliente == 6){
                            break;
                        }

                        switch(opcaoCliente){
                            case 1: 
                                break;
                        
                            case 2:
                                break;

                            case 3:
                                break;

                            case 4:
                                break;

                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                        
                    }
            }
            
            

          
            

        }


    }
    
}
