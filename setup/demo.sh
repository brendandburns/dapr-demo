#!/bin/bash

. ../util.sh

run 'clear'

desc "Install dapr on your Kubernetes cluster"
run 'dapr init -k'
run 'watch kubectl get pods --namespace=dapr-system'

desc "Install a sample app"
kubectl create namespace dapr-demo 2>&1 > /dev/null

run 'less deployment.yaml'
run 'kubectl create -f deployment.yaml'
run 'watch kubectl get pods --namespace dapr-demo'


