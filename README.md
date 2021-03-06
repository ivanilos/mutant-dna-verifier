A simple API created with Java 8, Maven, Jersey, Junit and Mockito.

# Running
```sh
$ mvn compile
$ mvn package
```

A war file should be produced, you can deploy it to Tomcat to test it locally.

# Routes (locally)
1. POST localhost:8080/resources/mutant
  Returns an HTTP Code regarding whether the queried dna is a mutant (OK 200 code), not mutant (Forbidden 403) or the request didn't receive a dna (Bad Request 400). A mutant is considered someone whose piece of dna has 4 consecutively matching characters, horinzontally, vertically or diagonally. The sent dna must be sent in json format, have an equal number of rows and columns and consist of only the characters "A", "C", "G", "T".

### Example 1

```
POST /service/mutant HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache

{"dna" : ["ACG",
          "CTT",
          "AAA"]}
```

Should return HTTP 403

### Example 2

```
POST /service/mutant HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache

{"peptide" :["AAAA",
            "AAAA",
            "AAAA",
            "AAAA"]}
```
Should return HTTP 400
