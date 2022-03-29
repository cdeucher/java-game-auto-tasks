# java-game-auto-tasks

- Bot para automatizar algumas ações repetitivas em um jogo de RPG.

- O arquivo `conf.txt` contém o mapeamento das teclas na seguinte disposição:
  - [ skill-coldown, skill-key, animation-delay ]
  - skill-coldown : Tempo de ciclo para execução, a cada quanto tempo deve-se executar esta ação?
  - skill-key : Id da tecla, pode ser consultado a lista [aqui](https://docs.oracle.com/javase/7/docs/api/constant-values.html).
  - animation-delay: tempo de duração de execução da ação (animação).

- Para executar deve-se:
  - Compilar o projeto `mvn clean package`.
  - Abrir o CMD (windows) em modo administrativo `java -jar bot-1.0-SNAPSHOT.jar`.
