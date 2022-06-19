#!/bin/bash

docker-compose down
docker-compose rm -f
docker volume rm local_postgres_data local_redis_data