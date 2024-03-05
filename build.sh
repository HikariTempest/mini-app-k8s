#!/usr/bin/env bash

mvn -B package
cp src/main/docker/Dockerfile target/
docker login ghcr.io -u $GITHUB_ACTOR -p $GITHUB_TOKEN
docker build --tag ghcr.io/hikaritempest/backend:latest ./target
docker push ghcr.io/hikaritempest/backend:latest
