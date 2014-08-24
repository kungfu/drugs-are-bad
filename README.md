# Drugs Are Bad
![mmmmkay?](doc/img/mackey.jpg)

**drugs-are-bad** is a response to [Use Clojure to Move Drugs: A Programming Challenge](https://github.com/micahalles/doll-smuggler).

While I didn't solve the NP-complete problem, I still had a good time learning Clojure. The algorithm succeeds against a number of different inputs, including the example given on Micah's GitHub page.

In addition, I've included a web interface for our team of drug dealers. It's ugly, and not too responsive, but if we give tablets to our drug traffickers, we should be able to assist them when dealing with the little old ladies of Eastown.

## Project Structure

The core code for solving the problem of which dolls our mule can carry
lies in `src/drugs_are_bad/core.clj`. The corresponding tests can be found
in `test/drugs_are_bad/core_test.clj`. The main function is called `burden`,
as in *burden all these poor old ladies with loads of illegal substances*.

The rest of the project contains a number of other folders and files for the
web server application. Most of these came along with [http-kit lein template](https://github.com/http-kit/lein-template). It is a single page application that uses ajax to calculate the
most efficient use of our old lady smugglers. The following files are of note:

* `src/drugs_are_bad/handlers/api.clj` - Contains the endpoint that our our ajax call uses
to call the `burden` function
* `public/js/app.js` - Contains the javascript that runs the web interface
* `src/templates/landing.tpl` - Contains the html template for the single page web app

## Compilation

You will need:

* [Leiningen](http://leiningen.org/) > v2.0

All other dependencies, including Clojure, will be downloaded automatically
on the first run.

## Running the Tests

In a terminal, run the following:

```
$ lein test
```

All tests against the core `burden` algorithm are located in `test/drugs_are_bad/core_test.clj`, 
including the example input from Micah's GitHub project page.

## Running the Web Server

To start the web server, run the following in a terminal:

```
$ ./scripts/run
```

The web server will listen on port 8080 by default. Open `http://localhost:8080/`
in a web browser. The rest should be self-explanatory.

