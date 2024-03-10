@echo off
docker run --name army2-server -p 8122:8122 --env-file .env -d army2-server:latest