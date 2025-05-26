import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class RaizQuadradaNewton {

    //Define a precisão "M" de casas decimais do objetivo do código, exemplo: M = 30
    private static final int PRECISAO = 30;
    private static final MathContext mc = new MathContext(PRECISAO + 10, RoundingMode.HALF_UP); //+10 de margem de segurança, garante que os cálculos internos sejam mais precisos que o resultado final
    private static final BigDecimal DOIS = new BigDecimal("2");

    public static BigDecimal sqrt(BigDecimal n) {
        if (n.compareTo(BigDecimal.ZERO) < 0) {
            throw new ArithmeticException("Raiz quadrada de número negativo"); //Nega o processo em caso de raiz negativa,  não real
        } else if (n.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        //Estimativa inicial do valor
        BigDecimal x = n.divide(DOIS, mc);

        //Critério de parada para finalizar o processo
        BigDecimal epsilon = BigDecimal.ONE.scaleByPowerOfTen(-PRECISAO);

        while (true) {
            BigDecimal xPrev = x;
            x = x.add(n.divide(x, mc)).divide(DOIS, mc); //Método de Newton traduzido para a linguagem java bigdecimal

            //Verifica se a diferença entre aproximações é menor que epsilon
            if (x.subtract(xPrev).abs().compareTo(epsilon) < 0) {
                break;
            }
        }

        return x.round(new MathContext(PRECISAO, RoundingMode.HALF_UP));
    }

    public static void main(String[] args) {
        BigDecimal numero = new BigDecimal("2"); //Restringindo o processo para a raiz de 2
        BigDecimal raiz = sqrt(numero);
        System.out.println("Raiz quadrada de " + numero + " é:"); //Exibe um texto com o resultado final do processo
        System.out.println(raiz.toPlainString());
    }
}
