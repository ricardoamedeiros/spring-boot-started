# Projeto Backend - Spring Boot

**Sumário**

- [1. Sobre o projeto](#1-sobre-o-projeto)
- [2. Criar um novo projeto usando o archetype](#criar-um-novo-projeto-usando-o-archetype)
- [3. Build e execução local](#build-e-execução-local)
    - [3.1. Com arquivo jar](#com-arquivo-jar)
    - [3.2. Com Docker](#com-docker)
- [4. Acessar o projeto](#acessar-o-projeto)
- [5. Upload de archetype no nexus](#upload-de-archetype-no-nexus)

## Sobre o projeto

Trata-se de um projeto desenvolvido para ser referência e acelerar a configuração inicial de novos projetos. 

## Criar um novo projeto usando o archetype

Após baixar o código fonte desse projeto execute o comando:

``` console
mvn install
```

Esse comando faz com que o archetype seja instalado no repositório local do maven e depois disso é possível usar o projeto como base para criar outros a partir dele.


* Execute o comando: 

``` console
mvn archetype:generate -DgroupId=<grupo-do-seu-projeto> -DartifactId=<nome-do-seu-projeto> -Dversion=<nome-da-sua-versao> -DpackageName=br.com.salute -DarchetypeGroupId=br.com.salute -DarchetypeArtifactId=spring-boot-started-archetype -DarchetypeVersion=0.0.1 -DinteractiveMode=false
```

Obs.: Substitua no nome transformacao-digital pelo nome do projeto que será gerado.

## Build e execução local

### Com arquivo .jar
Para gerar a versão executável do projeto com a extensão .jar é necessário executar o comando abaixo no diretório raiz:

```bash
mvn clean package
```

Execute o comando abaixo para iniciar o projeto

```bash
java -jar ~\target\<nome-do-seu-projeto>.jar
```

### Com Docker
Para gerar a versão executável do projeto com Docker é necessário executar o comando abaixo no diretório raiz:
```bash
docker build -t <nome-do-seu-projeto> .
```

Executar o comando abaixo para iniciar o container Docker no diretório dos arquivos Dockerfile:
```bash
docker run -p 8080:8080 <nome-do-seu-projeto>
```
Obs. É necessário executar o build com docker antes.

## Acessar o projeto

Para acessar o projeto digite no navegador o endereço: http://localhost:8080/swagger-ui.html 

## Upload de archetype no nexus

Para gerar o archetype deste projeto execute os comandos abaixo:

```bash 
mvn archetype:create-from-project
```

entre na pasta que foi gerado o archetype

```bash
cd ~/target/generated-sources/archetype
````

faça o upload

```bash 
mvn deploy -DaltDeploymentRepository=<profile-de-acesso-do-.m2/settings.xml-do-maven>::default::https://<endereco-do-seu-repositorio>/repository/maven-releases/
```
