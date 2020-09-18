#!/bin/bash

. ../util.sh

kubectl create -f dapr-demo-k8s/deployment/namespace.yaml 2>&1 > /dev/null

run 'clear'

run 'kubectl create -f dapr-demo-k8s/deployment/dapr.yaml'

run 'kubectl create -f dapr-demo-k8s/deployment/deployment.yaml'

run 'watch kubectl --namespace kube-events get pods'

POD=$(kubectl --namespace kube-events get pods --no-headers | awk '{print $1}')
run "kubectl --namespace kube-events logs ${POD} java"
