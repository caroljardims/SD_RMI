# SD_RMI — Distributed Chat with Java RMI

> 🇧🇷 Versão em português abaixo

A university project for the **Distributed Systems** course, implementing a chat system between clients and attendants using **Java RMI (Remote Method Invocation)**.

## About

The system simulates a support queue: clients connect to the server and wait for an available attendant. Once matched, a bidirectional communication channel is established directly between them — all through transparent remote calls via Java RMI.

## Architecture

Client ──► Server ──► Attendant
(availability queue)

- The **server** manages lists of free and busy attendants
- The **client** requests an attendant from the server and waits for matching
- The **attendant** registers on the server and becomes available for clients
- After matching, communication happens directly between client and attendant

## Project Structure
```bash
trab/
├── IServer.java        # Remote server interface
├── IChat.java          # Remote chat interface (deliver, setChat, closeChat)
├── IMessage.java       # Message interface
├── Message.java        # Message implementation
├── ServerChat.java     # RMI server (port 1099, rmi://localhost/ChatServer)
├── ClientChat.java     # Client with GUI
├── ClientGUI.java      # Client graphical interface
├── AtendentChat.java   # Attendant with GUI
└── AtendentGUI.java    # Attendant graphical interface
```


## How to Run

**1. Start the server:**
```bash
cd ServerChat
java -cp build/classes chat.ServerChat
```

**2. Open one or more attendants:**
```bash
cd AtendentChat
java -cp build/classes chat.AtendentChat
```

3. Open a client:
```bash
cd ClientChat
java -cp build/classes chat.ClientChat
```

The server must be running on the same machine (localhost) on the default RMI port 1099.

## Tech Stack
Java SE
Java RMI (java.rmi)
Swing (GUI)
NetBeans IDE + Apache Ant


# 🇧🇷 SD_RMI — Chat Distribuído com Java RMI
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

```bash
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
```


## Como Executar

**1. Iniciar o servidor:**
```bash
cd ServerChat
java -cp build/classes chat.ServerChat
```

2. Abrir um ou mais atendentes:
```bash
cd AtendentChat
java -cp build/classes chat.AtendentChat
```

3. Abrir um cliente:
```bash
cd ClientChat
java -cp build/classes chat.ClientChat
```
O servidor precisa estar rodando na mesma máquina (localhost) na porta padrão RMI 1099.

##Tecnologias
Java SE
Java RMI (java.rmi)
Swing (GUI)
NetBeans IDE + Apache Ant
Contexto
Projeto desenvolvido em 2015 como trabalho prático da disciplina de Sistemas Distribuídos.
