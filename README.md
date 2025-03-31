Compile (Ubuntu 22.04):
    javac -d bin -cp "lib/mysql-connector-j-9.1.0.jar" src/*.java

Run (Ubuntu 22.04):
    java -cp "bin:lib/mysql-connector-j-9.1.0.jar" App

This probably works for most Linux based OS tho.

This software isnt in its final version and can get locked when doing things like adding a vehicle when no Customers or Vehicle brands are registered. My bad :3