package Projeto;

import java.util.Scanner;

public class App{
   
    public void operacoes(){
      System.out.println("digite um para cadastrar usuario");
      System.out.println("digite dois para criar conta");
      System.out.println("digite três para entrar na conta");
      System.out.println("digite quatro para mexer na sua conta");
      System.out.println("digite cinco para investimentos");
      System.out.println("digite seis para transferencias");
      System.out.println("digite sete para ir ao suporte");
      System.out.println("digite oito para encerrar conta");
   
    }
 
    public static void main(String[] args) {
        // Crie alguns objetos de exemplo
    /*    Usuario usuario1 = new Usuario("12345678900", "João", "Rua A", "01/01/1990");
        Usuario usuario2 = new Usuario("98765432100", "Maria", "Rua B", "02/02/1985");

        ContaBancaria conta1 = new ContaBancaria(1, "joao123", 123, 1000.0, usuario1);
        ContaBancaria conta2 = new ContaBancaria(2, "maria456", 456, 500.0, usuario2);

        
        conta1.depositar(200.0);
        conta1.sacar(50.0);


        conta1.Extrato();
        conta2.Extrato();
    }*/
CadastroUsuario usuari = new CadastroUsuario();
 Gerente g1 = new Gerente("234433", "carlos", "123", "12042004", "gerente", null);
  GerenciarConta geren1 = new GerenciarConta(g1);

 AutorizacaoSeguranca autorizaçao = new AutorizacaoSeguranca();
 
  
       while(true){
      
        System.out.println("digite um valor");
        Scanner sc = new Scanner(System.in);
       int opcao = sc.nextInt();
      
    
       
            switch (opcao) {
                case 1:
               
                usuari.Cadastro();
                    break;
                case 2:
             
             System.out.println("digite nome do usuario para criar conta");
               String nomeUsuarioConta = sc.next();
             Usuario usuariopelonome =  usuari.escolherUsuario(nomeUsuarioConta);
             if(usuariopelonome!=null){
                System.out.println("digite senha");
                int senha = sc.nextInt();
                System.out.println("digite o login");
                String login = sc.next();
                ContaBancaria novaconta = new ContaBancaria(opcao, login, senha, senha, usuariopelonome);
               geren1.criarConta(novaconta); 
             System.out.println("conta criada");
            }else{
                System.out.println("usuario nao encontrado");
            }
                break;
                  case 3:
  
           ContaBancaria entrarConta = geren1.encontrarConta();
           autorizaçao.verificarSenha(entrarConta);
                 break;
               case 4:
               int valor = sc.nextInt();
               ContaBancaria veriConta = geren1.encontrarConta();
              if(veriConta!=null&&autorizaçao.verificarSenha(veriConta)==true){
               veriConta.depositar(valor);
              }
                 


               break;
        
                 case 5:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            
  
  
                
     sc.close();
  
                }
        
       
                
    }


}
}





