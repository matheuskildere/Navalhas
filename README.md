
# Barbearia Navalhas

Este projeto tem a intenção de colaborar com o sistema de gerenciamento da  **Barbearia Navalhas**.

## Tecnologias Utilizadas:
- **Java**
- **PostgreSQL**

### Instalação
Para utilizar esse sistema em sua maquina em versão de teste, você irá precisar dos seguintes programas:

- PostgreSQL
- Java
- IDE/Editor de texto de sua escolha (VSCode, Eclipse, Netbeans etc).

Antes de tudo você deverá criar uma base de dados na sua máquina usando PostgreSQL, para facilitar deixamos todos os scripts SQL para criação das tabelas e inserção dos dados necessários em um arquivo que você encontrará no seguinte link: [Scripts SQL](https://github.com/matheuskildere/Navalhas/blob/master/Readme/bd.txt).
Faça um clone deste repositório e abra em sua IDE ou em seu Editor de texto, em seguida execute a classe Navalhas.java

## Sistema de Gerenciamento

Esse sistema possui funções/opções separadas dentro de um menu principal. Sendo elas:

### **CLIENTE**
> - **Adicionar**
> - **Consultar**
> - **Editar**
> - **Excluir**

Segue abaixo uma imagem desta dela do sistema:

![Tela cliente](https://github.com/matheuskildere/Navalhas/blob/master/Readme/cliente.png)

### **ASSINATURAS**
> - **Adicionar nova assinatura**
> Essa opção consiste em cadastrar um novo serviço (corte, barba etc) prestado ao sistema de gerenciamento, e ao mesmo tempo relacionar esse serviço ao cliente. O cliente irá receber uma assinatura, caso o mesmo possua um total de 10 assinaturas, este terá direito ao um corte grátis.

Segue abaixo uma imagem desta dela do sistema:

![Tela de Assinaturas](https://github.com/matheuskildere/Navalhas/blob/master/Readme/telaAssinauta.jpeg)

### Relatórios
> - **Diário**
> - **Semanal**
> - **Mensal**
> - **Anual**

Segue abaixo duas imagens desta dela do sistema:

![Tela relatorios](https://github.com/matheuskildere/Navalhas/blob/master/Readme/realatorios.png)

![Tela relatorio diario](https://github.com/matheuskildere/Navalhas/blob/master/Readme/realatoriodiario.png)
