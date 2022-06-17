# Инструкция к развертыванию

## Подготовка окружения

### Docker

Мы храним нашу базу данных в Docker контейнере

1. Установить [Docker CE](https://docs.docker.com/engine/install/ubuntu/) и [Docker Compose](https://docs.docker.com/compose/install/)
2. Запустить следующие команды:
```sh
cd docker-config
docker-compose up -d
```

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

