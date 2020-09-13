#!/bin/bash

dapr init -k
kubectl create namespace dapr-demo

cat deployment.yaml
kubectl create -f deployment.yaml

kubectl get pods --namespace dapr-demo -w


