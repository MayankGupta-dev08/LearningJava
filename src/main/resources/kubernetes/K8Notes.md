# KUBERNETES OR K8S

## What is K8s?
 - K8s is basically an orchestration tool for containers.
 - K8s deploys the containerized apps & therefore it has to use a specific container runtime.
 - Apart from Docker, K8s supports other container runtime such as CRI-O and containerD.

## What does K8s actually does??
1. Automatically deploys the containerized applications across different servers.
2. Load distribution across multiple servers.
3. Auto-scalling of deployed applications.
4. Montioring and health check of the container.
5. Replacement of the failed containers.

### **Some Terminologies**
  - Container: In Docker, we use the source code, different settings and all the dependencies to build an image and then that image is used to build the container.
  - Pod: It is the smallest unit in K8s world and container(s) are created inside the pod. Apart from the container(s), pod also contains shared volumes and shared network resources (shared IP address).
    - This means inside a pod all the containers share the volume and share the IP address.
    - Most of the times its prefered to have a single container per pod,
    - but their could be a scenario where we need to have multiple containers tightened together inside one pod inorder to make them havily dependent on each other and they could exist in the same namespace.
    - one pod --> one server (each container inside a pod will be located on a same server).
  - Cluster: It consists of node(s) which is a server (either bare metal server or a virtual server). And these nodes/servers could be located in different data centers in different parts of the world.
    - but nodes which belong to same cluster are loacted closely to each other in order to perform their job more efficiently.
    - inside the node we have pod(s) and inside it we have container(s).

*Note: Our job is to create nodes and form cluster(s) using these nodes and rest will be taken care by K8s automatically.*

## How K8s work?
- In a K8s cluster we have a Master Node and all other nodes aka worker nodes. Master node actually manages the worker nodes.
- Its master node responsibilty to distribute for example the loads b/w the different worker nodes.
- All the ports which are related to ur applications are deployed on the worker nodes and master node runs all the sytem ports which are responsible for the actual work of the k8s cluster.
- So basically master node acts as a control panel in ur cluster for managing the worker nodes and doesn't run any client applications.
- **Kubernetes Services**
  - Their are services like **kublet, kube-proxy** and **container runtime** which are present on every node in the cluster.
  - Container runtime: runs the actual containers inside each node and that their could be container runtime of any of the Docker, Cri-O or containerD.
  - The **kublet** service of the worker node communicates with the **API Server** service of the master node