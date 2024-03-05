#!/usr/bin/env bash

repo="${GITHUB_REPOSITORY,,}"

mvn -B package
cp src/main/docker/Dockerfile target/
docker login ghcr.io -u $GITHUB_ACTOR -p $GITHUB_TOKEN
docker build --tag ghcr.io/$repo/backend:latest ./target
docker push ghcr.io/$repo/backend:latest