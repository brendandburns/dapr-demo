#!/bin/bash

mvn package
docker build -t brendanburns/dapr-demo-java:v2 .