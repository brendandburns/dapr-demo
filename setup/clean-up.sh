#!/bin/bash

kubectl delete -f deployment.yaml
kubectl delete namespace dapr-demo

dapr uninstall -k
