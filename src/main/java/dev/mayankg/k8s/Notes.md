# Kubernetes (K8s)

Kubernetes also known as K8s was built by Google based on their experience running containers in production. It is now an open-source project and is arguably one of the best and most popular container orchestration technologies out there.

[Download and Install K8s](https://kubernetes.io/releases/download/)

## K8s Architecture

K8s architecture is based on a master-slave model. The master is responsible for managing the cluster and the slaves are responsible for running the containers. 
The master is responsible for the following:
1. Scheduling applications
2. Scaling applications
3. Rolling out new updates
4. Monitoring applications
5. Managing the state of the cluster, nodes, pods, containers, services, and volumes
The slaves are responsible for running the containers and monitoring their health.

K8s has the following components:
- Master
    1. API Server (Frontend for K8s)
    2. Scheduler (Schedules the pods)
    3. Controller Manager (Monitors the state of the cluster)
    4. etcd (Key-Value Store)
- Node
    5. Kubelet  (Agent)
    6. Kube Proxy (Network Proxy)
    7. Container Runtime (Docker, rkt, etc.)

## K8s Commands

### Pods

- how many pods are running in the current (default) namespace

```shell
kubectl get pods
```

- how many pods are running in the current (default) namespace with wide output

```shell
kubectl get pods -o wide
```

- how many pods are running in a namespace

```shell
kubectl get pods -n <namespace> --no-headers | wc -l
```

- to get the list of namespaces

```shell
kubectl get namespaces
```

- to get the cluster information

```shell
kubectl cluster-info
```

- to get help for a specific command (e.g. `run`)

```shell
kubectl run --help
```

- to create a new pod (named `nginx`) with `nginx` image 

```shell
kubectl run nginx --image=nginx
```

- to create a new pod with `nginx` image and expose it on port 80

```shell
kubectl run nginx --image=nginx --port=80
```

- to create a new pod def in a yml file with `nginx` image and expose it on port 80 and name it `nginx`

```shell
kubectl run nginx --image=nginx --port=80 --restart=Never --dry-run=client -o yaml > pod-def.yml
```

- to create a new pod using the pod def file

```shell
kubectl create -f pod-def.yml
```

- to describe a pod named `myapp-pod`

```shell
kubectl describe pod myapp-pod
```

- to delete a pod named `myapp-pod`

```shell
kubectl delete pod myapp-pod
```

- to edit the pod named `myapp-pod`

```shell
kubectl edit pod myapp-pod
```

- to change the image of a pod named `myapp-pod` from `nginx` to `nginx:1.9.1`

```shell
kubectl set image pod myapp-pod nginx=nginx:1.9.1
```

- to get the logs of a pod named `myapp-pod` with timestamps

```shell
kubectl logs myapp-pod --timestamps
```

- to apply a new configuration to a pod using a file named `pod-def.yml`

```shell
kubectl apply -f pod-def.yml
```

### ReplicaSets and ReplicationControllers

- to create a replication controller using a file named `rc-def.yml`

```shell
kubectl create -f rc-def.yml
```

- to get the list of replication controllers

```shell
kubectl get rc
```

- to get the list of replication controllers with wide output

```shell
kubectl get rc -o wide
```

- to create a replication set using a file named `rs-def.yml`

```shell
kubectl create -f rs-def.yml
```

- to get the list of replication sets

```shell
kubectl get rs
```

- to get the list of replication sets with wide output

```shell
kubectl get rs -o wide
```

- to replace a replication set using a file named `rs-def.yml`

```shell
kubectl replace -f rs-def.yml
```

- to scale a replication set named `myapp-rs` to 6 replicas

```shell
kubectl scale --replicas=6 replicaset myapp-rs
```

```shell
kubectl scale --replicas=6 -f rs-def.yml
```

- to delete a replication set named `myapp-rs` (also deletes the underlying pods)

```shell
kubectl delete rs myapp-rs
```

- to describe a replica set named `myapp-rs`

```shell
kubectl describe rs myapp-rs
```

- to edit the replica set named `myapp-rs`

```shell
kubectl edit replicaset myapp-rs
```

### Deployments

- to create a deployment using a file named `deploy-def.yml`

```shell
kubectl create -f deploy-def.yml
```

- to get the list of deployments

```shell
kubectl get deployments
```

- to get the list of deployments with wide output

```shell
kubectl get deployments -o wide
```

- to get the list of all the objects in the current namespace

```shell
kubectl get all
```
