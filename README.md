# SD_RMI — Chat Distribuído com Java RMI

Trabalho acadêmico da disciplina de **Sistemas Distribuídos**, implementando um sistema de chat entre cliente e atendente usando **Java RMI (Remote Method Invocation)**.

## Sobre o Projeto

O sistema simula uma fila de atendimento: clientes se conectam ao servidor e aguardam um atendente disponível. Quando um atendente entra, o servidor faz o pareamento e abre um canal de comunicação bidirecional entre os dois — tudo via chamadas remotas transparentes pelo Java RMI.

## Arquitetura

Cliente ──► Servidor ──► Atendente
(fila de disponibilidade)



- O **servidor** mantém listas de atendentes livres e ocupados
- O **cliente** solicita um atendente ao servidor e aguarda pareamento
- O **atendente** se registra no servidor e fica disponível para receber clientes
- A comunicação acontece diretamente entre cliente e atendente após o pareamento

## Estrutura do Projeto

trab/
├── IServer.java        # Interface remota do servidor
├── IChat.java          # Interface remota do chat (deliver, setChat, closeChat)
├── IMessage.java       # Interface de mensagem
├── Message.java        # Implementação de mensagem
├── ServerChat.java     # Servidor RMI (porta 1099, rmi://localhost/ChatServer)
├── ClientChat.java     # Cliente com GUI
├── ClientGUI.java      # Interface gráfica do cliente
├── AtendentChat.java   # Atendente com GUI
└── AtendentGUI.java    # Interface gráfica do atendente



## Como Executar

**1. Iniciar o servidor:**
```bash
cd ServerChat
java -cp build/classes chat.ServerChat
2. Abrir um ou mais atendentes:


cd AtendentChat
java -cp build/classes chat.AtendentChat
3. Abrir um cliente:


cd ClientChat
java -cp build/classes chat.ClientChat
O servidor precisa estar rodando na mesma máquina (localhost) na porta padrão RMI 1099.

Tecnologias
Java SE
Java RMI (java.rmi)
Swing (GUI)
NetBeans IDE + Apache Ant
Contexto
Projeto desenvolvido em 2015 como trabalho prático da disciplina de Sistemas Distribuídos.



---

Classic trabalho de SD — fila de atendimento com RMI é um dos exercícios mais clássicos dessa disciplina. Quer ajustar algo?
