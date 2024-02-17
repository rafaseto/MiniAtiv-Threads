**! Mini projeto - Threads**

Este projeto demonstra o uso de threads em Java para manipulação segura de recursos compartilhados, utilizando exclusão mútua para evitar problemas de concorrência.

**Classes:**

1. **Contador:**
    - A classe `Contador` representa um contador simples que pode ser incrementado ou decrementado por múltiplas threads de forma segura.
    - Utiliza um objeto de bloqueio (`Lock`) para garantir a exclusão mútua durante as operações de incremento e decremento.
    - Fornece métodos `inc()` e `dec()` para incrementar e decrementar o contador, respectivamente, de forma segura.
    - Implementa o método `getContador()` para retornar o valor atual do contador.

2. **Incremento:**
    - A classe `Incremento` implementa a interface `Runnable`, permitindo que seja executada como uma thread.
    - Responsável por incrementar o contador em um loop controlado, com pausas entre cada incremento para simular operações demoradas.
    - Utiliza um objeto de bloqueio para garantir a exclusão mútua durante o acesso ao contador compartilhado.

3. **Decremento:**
    - Similar à classe `Incremento`, porém responsável por decrementar o contador.
    - Implementa a lógica para decrementar o contador em um loop controlado, com pausas entre cada decremento para simular operações demoradas.
    - Utiliza o mesmo objeto de bloqueio para garantir a exclusão mútua durante o acesso ao contador compartilhado.

4. **Main:**
    - A classe `Main` é a classe principal do projeto, contendo o método `main()` que inicia a execução do programa.
    - No método `main()`, são criadas instâncias das classes `Contador`, `Incremento` e `Decremento`, juntamente com um objeto de bloqueio.
    - As threads de incremento e decremento são iniciadas e executadas concorrentemente, demonstrando o uso de threads e exclusão mútua.