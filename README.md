# Smart-os

Az alkalmazás indításásoz Java 21 szükséges.

Gyökérkönyvtárban a következő két parancs segítségével indítható:

* mvn clean install
* docker compose up --build

Az implementált végpontokat egyszerűen ki lehet próbálni:
http://localhost:8080/swagger-ui/index.html#/

Első indításkor a fejlesztő profilja töltődik be. Ezen felül van lehetőség még egy "teszt" felhasználót felvenni a rendszerbe a */simulation/loadData* végpont segítségével.
