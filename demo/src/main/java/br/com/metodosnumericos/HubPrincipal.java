package br.com.metodosnumericos;

import java.util.Scanner;

import br.com.metodosnumericos.Cramer.MainInput;
import br.com.metodosnumericos.Lagrange.Input.LagrangeInput;
import br.com.metodosnumericos.Util.Validations.inputValidations;


public class HubPrincipal {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nBem Vindo Escolha um Metodo");
        
        exibirCaixaDeEscolha();
        int escolha = 0 ;
        while(true){
            System.out.print("_____________________________________________________________________" +
        "\nDeseja Testar outro Metodo? \nDigite 1 para testar outro metodo!\nDigite 2 Para finalizar o programa!\nEscolha: ");
            String value = scanner.nextLine();
            
            if(inputValidations.isValidNumeric(value)){
                escolha = Integer.parseInt(value);
                if(escolha == 1){
                    exibirCaixaDeEscolha();
                }else if(escolha == 2){
                    break;
                }else {
                    System.out.println("O valor deve ser 1 ou 2");
                }

            }else{
                System.out.println("O valor digitado é invalido por favor tente novamente!!!!");
            }


        }

        scanner.close();
    }


     public static void exibirCaixaDeEscolha() {

        String caixa = "___________________________\n" +
                       "| 1 - Cramer               |\n" +
                       "| 2 - Regressão Linear     |\n" +
                       "| 3 - Correlação de Pearson|\n" +
                       "| 4 - Lagrange             |\n" +
                       "| 5 - Gauss Seidel         |\n" +
                       "|__________________________|\n";


        System.out.println(caixa);

        int escolha = 0;
        while(true){
            System.out.print("Escolha uma opção: ");
            String value = scanner.nextLine();
            

            if(inputValidations.rangeNumeric(value)){
                escolha = Integer.parseInt(value);
                break;
            }

            System.out.println("Valor Invalidor Por valor Digite um numero de 1 a 5");


        }
  


        switch (escolha) {
            case 1:
                System.out.println("Você escolheu a Opção Metodo de Cramer\nSiga as orientações.\n\n\n");
                MainInput cramerInput = new MainInput();
                cramerInput.all();
                break;
            case 2:
                System.out.println("Você escolheu a Opção Regressão Lienar\nSiga as orientações.\n\n\n");
                br.com.metodosnumericos.RegressaoLinear.Input.MainInput linearInput = new br.com.metodosnumericos.RegressaoLinear.Input.MainInput();
                linearInput.All();
                break;
            case 3:
                System.out.println("Você escolheu a Opção Correlação de Pearson\nSiga as orientações.\n\n\n");
                br.com.metodosnumericos.CorrelacaodePearson.Input.MainInput personInput = new br.com.metodosnumericos.CorrelacaodePearson.Input.MainInput();
                personInput.All();
                break;
            case 4:
                System.out.println("Você escolheu a Opção Lagrange\nSiga as orientações.\n\n\n");
                LagrangeInput lagrangeInput = new LagrangeInput();
                lagrangeInput.addValuesInListX();
                lagrangeInput.attList();
                break;
            case 5:
                System.out.println("Você escolheu a Opção Gauss Seidel\nSiga as orientações.\n\n\n");
                br.com.metodosnumericos.GaussSeidel.Input.MainInput gausInput = new br.com.metodosnumericos.GaussSeidel.Input.MainInput();
                gausInput.all();
                break;
            default:
                System.out.println("Opção inválida.");
        }

}
}
