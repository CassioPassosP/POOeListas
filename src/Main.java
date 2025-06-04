import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        try{
            System.out.println("Digite o limite do cartao: ");
            double limite = leitura.nextDouble();
            Cartao cartao = new Cartao(limite);

            int sair = 1;
            while (sair!=0){
                System.out.println("Digite a descricao da compra: ");
                String descricao = leitura.next();

                try {
                    System.out.println("Digite p valor da compra: ");
                    double valor = leitura.nextDouble();

                    Compra compra = new Compra(descricao, valor);
                    boolean compraFinalizada = cartao.CartaoLancaCompra(compra);

                    if (compraFinalizada) {
                        System.out.println("Compra realizada!");
                        System.out.println("Digite 0 para sair ou 1 para continuar");
                        try {
                            sair = leitura.nextInt();
                        } catch (Exception e) {
                            System.err.println("Erro: Opcao valida.");
                        }
                    }else{
                        System.out.println("Saldo insuficiente!");
                        sair = 0;
                    }

                    System.out.println("\n***********************************");
                    System.out.println("\nCOMPRAS REALIZADAS:");

                    for (Compra c : cartao.getCompras()){
                        System.out.println(c.getDesricao() + " - " + c.getValor());
                    }

                    System.out.println("\nSaldo do cartao: " + cartao.getSaldo());

                } catch (Exception e) {
                    System.err.println("Erro: Opcao valida.");
                }

            }

        } catch (Exception e){
            System.err.println("Erro: Opcao valida.");
        }
    }
}