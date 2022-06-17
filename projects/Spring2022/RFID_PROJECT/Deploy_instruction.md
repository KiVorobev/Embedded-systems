# Инструкция к развертыванию

## Подготовка окружения

### Docker

Мы храним нашу базу данных в Docker контейнере

1. Установить [Docker CE](https://docs.docker.com/engine/install/ubuntu/) и [Docker Compose](https://docs.docker.com/compose/install/)
2. Git clone `docker-config`
3. `cd ~/IdeaProjects/ticon-config/local/`
4. `docker-compose up -d` чтобы поднять БД

## Сборка

```sh
cd back-end
mvn package
java -jar target/rfid-backend-1.0-SNAPSHOT.jar
```

# Документация 

- [Описание используемого протокола общения с контроллером протокола](Protocol.md)
- [Описание технической схемы](Technical_scheme.md)
- [Описание технического задания](TZ.md)

