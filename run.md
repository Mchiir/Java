docker-compose up --build -d
docker-compose down --volumes --remove-orphans

docker exec -it testdocker sh # Opening container's shell

curl http://localhost:8001

Commiting changes:
docker-compose down
docker-compose up --build -d
docker logs -f testdocker
