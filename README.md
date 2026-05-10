# Roman Numbers

[![Java CI](https://github.com/MTSS26/roman-numbers/actions/workflows/java-ci.yml/badge.svg)](https://github.com/MTSS26/roman-numbers/actions/workflows/java-ci.yml)
[![Coverage Status](https://img.shields.io/coveralls/github/MTSS26/roman-numbers/develop?label=coverage)](https://coveralls.io/github/MTSS26/roman-numbers?branch=develop)

Programma Java per convertire numeri interi arabi da 1 a 1000 in numeri romani e stamparli in ASCII art.

## Autori

- Dorde Blagojevic 2116424
- Leonardo Soligo 2111042

## Requisiti

- Java 8 o superiore
- Maven

## Comandi Maven

Compila il codice sorgente:

```console
mvn compile
```

Esegue la suite di test unitari:

```console
mvn test
```

Crea il file jar ed esegue Checkstyle:

```console
mvn package
```

Esegue test, analisi statica e controllo della coverage con JaCoCo:

```console
mvn verify
```

## Utilizzo

Per generare il jar del progetto:

```console
mvn clean package
```

Per provare le classi tramite `jshell`:

```console
jshell --class-path target/roman-number-1.0.0.jar
```

Esempio:

```java
import it.unipd.mtss.IntegerToRoman;
import it.unipd.mtss.RomanPrinter;

IntegerToRoman.convert(944);
RomanPrinter.print(4);
```

## Qualità

La pipeline GitHub Actions verifica automaticamente compilazione, test, analisi statica e coverage. La copertura del codice viene misurata con JaCoCo e pubblicata tramite Coveralls.
