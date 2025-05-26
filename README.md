# NewtonRaphsonEmJava
Tradução do método de Newton-Raphson para Java.

RELATÓRIO ABAIXO (Versão em .pdf segue no email):

1. Método de Newton em Java (Classe BigDecimal)

Fiz esse projeto em Java com o objetivo de implementar uma resolução para o cálculo da raiz quadrada de 2 (mas pode ser utilizado para qualquer número positivo), utilizando o método maatemático de Newton-Raphson e a classe BigDecimal (no lugar da double), pois é mais responsiva e segura ao fazer operações com valores altos de precisão.

2. Funções do código resumidamente

Serve para calcular da raiz quadrada de 2, ou qualquer outro número positivo.
Obter uma precisão configurável pelo usuário (para o exemplo eu defini 30 casas decimais).
Utiliza a classe de Java "BigDecimal" para resultados com maior precisão (mais casas decimais).

3. Algoritmo utilizado

Para o processo, é utilizado o método de Newton-Raphson para encontrar a raiz quadrada de um número "N", resolvendo a equação:

    f(x) = x² - N  →  x = (x + N / x) / 2

O processo se repete até que a diferença entre aproximações consecutivas seja menor que o valor de tolerância definido pela precisão.

4. Exceção:

Código de exceção:

if (n.compareTo(BigDecimal.ZERO) < 0) {
    throw new ArithmeticException("Raiz quadrada de número negativo");
}

Serve para checar se o valor "N" é negativo, o que invalidaria a equação, que trata apenas de resultados com números reais.
Como eu havia dito, apesar do objetivo ser apenas encontrar o valor da raiz quadrada de 2, o código foi feito para atender qualquer outro número positivo.

5. Exemplo de uso (predefinido)

Número de entrada no código:

BigDecimal numero = new BigDecimal("2");
int precisao = 30;

Saída:

Raiz quadrada de 2 é:
1.41421356237309504880168872421
