# Docker Notes

- Note: replace the content with `<>` with appropriate value to run the cmd properly.
- `Dockerfile` files are w/o any extensions and `docker-compose` files uses `yml` or `ymal` extensions.
- Docker images can be generated using three (3) different ways:
  - with a Dockerfile which has a set of sequential instructions (basic/ traditional approach)
  - with the help of [Buildpacks](https://buildpacks.io), we don’t need to write a low-level Dockerfile
  - with the help of GoogleJib (open source java tool maintained by Google for building docker images of java applications)

1. Docker Commands
   1. commands related to docker images 
   2. commands related to docker containers 
2. Docker Compose Commands

---

## Docker Commands

### To build the image using the jar for the app

- Navigate to the path where both `Dockerfile` and `jar` for the app are present.
- Here name of the image that we want to build is `userapp` and tag for the image is `2.0.1`
- Execute the following cmd:

```shell
docker build . -t <image_name>:<image_tag>
```

### List all the docker images present in your docker server

```shell
docker images
```

### To display detailed image information for a given image id

```shell
docker image inspect <image_id>
```

### To remove a docker image with a particular image_id

```shell
docker images rm <image_id>
```

### To push a docker image with an image_tag for a user to their docker registry

```shell
docker image push docker.io/<user_name>/<image_name>:<image_tag>
```

### To pull a particular docker image with an image_tag from docker registry

```shell
docker image pull docker.io/<user_name>/<image_name>:<image_tag>
```

### To run a container using a particular docker image

- External/Host port that we have used `9090` and Internal/Container port is `9191`
- Here we have used image `userapp` and its tag is `2.0.1`

```shell
docker run -d -p <host_port>:<cont_port> <image_name>:<image_tag>
```

```shell
docker run -d --name <container_name> -p <host_port>:<cont_port> <image_id>
```

### List of all the docker container/process running/stopped

```shell
docker ps -a
```

### To show only running container/process

```shell
docker ps
```

### To create a new image from an exiting running container which was modified

- This is done, in case if we have added some files in the running container and once the container is stopped the
  changes will also vanish.

```shell
docker commit <container_id> <new_container_name>:<new_container_tag>
```

### Pushing the local images to the docker-hub registry

- docker login

```shell
docker login
```

- tag you image with your dockerHubId --> `mayankg/my-app_image:v2.0`

```shell
docker tag <image_name>:<image_tag> <docker_userId>/<image_name>:<image_tag>
```

- push your images. for example, image -->`mayankg/my-app_image:v2.0`

```shell
docker push <image_name>:<image_tag> <docker_userId>/<image_name>:<image_tag>
```

### To stop a running container

```shell
docker container stop <container_name>
```
```shell
docker container stop <container_id>
```

### To start a docker container which was stopped

```shell
docker container start <container_name>
```
```shell
docker container start <container_id>
```

### To pause all the processes within one or more running containers

```shell
docker container pause <container_id>
```

### To resume/unpause all the processes within one or more paused containers

```shell
docker container unpause <container_id>
```

### To kill one or more running containers instantly

```shell
docker container kill <container_id>
```

### To restart one or more containers

```shell
docker container restart <container_id>
```

### To inspect all the details for a given container id

```shell
docker container inspect <container_id>
```

### To fetch the logs of a given container id

```shell
docker container logs <container_id>
```

### To follow log output of a given container id

```shell
docker container logs -f <container_id>
```

### To run a bash shell inside a particular container

```shell
docker exec -it <container_id> /bin/bash
```

### To remove one or more containers based on container ids

```shell
docker container rm <container_id>
```

### To remove all stopped containers

```shell
docker container prune
```

### List all the docker volumes

```shell
docker volumes
```

### To remove unused volumes

```shell
docker volume prune
```

### To clean up any unused data in the docker.

- Removing all stopped containers
- Removing all networks not used by at least one container
- Removing all dangling images (i.e., images not referenced by any container)
- Removing all dangling build cache

```shell
docker system prune -f
```

---

## Docker Compose Commands

### To start containers defined in the docker-compose.yml file

```shell
docker-compose up
```

### To start containers in detached mode (in the background)

```shell
docker-compose up -d
```

### To stop containers defined in the docker-compose.yml file

```shell
docker-compose down
```

### To stop and remove containers, networks, and volumes

```shell
docker-compose down -v
```

### To rebuild containers

```shell
docker-compose up --build
```

### To list containers managed by docker-compose

```shell
docker-compose ps
```

### To view the logs of services

```shell
docker-compose logs <service_name>
```

### To run a command in a service container

```shell
docker-compose exec <service_name> <command>
```

### To run a command in a service container interactively

```shell
docker-compose exec <service_name> <command> -it
```

### To scale services (increase the number of containers)

```shell
docker-compose scale <service_name>=<number_of_containers>
```

### To run a single service in a composition

```shell
docker-compose run <service_name>
```

### To build images before starting services

```shell
docker-compose up --build
```

### To remove all containers

```shell
docker-compose rm -f
```

### To check the configuration of docker-compose.yml

```shell
docker-compose config
```