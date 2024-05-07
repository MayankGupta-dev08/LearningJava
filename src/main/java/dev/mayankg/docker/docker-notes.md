# Docker Commands

- Note: replace the content with `<>` with appropriate value to run the cmd properly.

---

### To build the image using the jar for the app

- Navigate to the path where both `Dockerfile` and `jar` for the app are present.
- Here name of the image that we want to build is `userapp` and tag for the image is `2.0.1`
- Execute the following cmd:

```shell
docker build -t <image_name>:<image_tag> .
```

### List all the docker images

```shell
docker images
```

### List all the docker volumes

```shell
docker volumes
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

- If only want to see the running containers the remove the `-a` from the cmd.

```shell
docker ps -a
```

### To stop a running container

- instead of <container_name>, we could also use <container_id>.

```shell
docker stop <container_name>
```

### To start a container which was stopped

- instead of <container_name>, we could also use <container_id>.

```shell
docker start <container_name>
```

### Check the logs for the container

```shell
docker logs <container_id> bash
```

### To run a bash shell inside a particular container

- instead of <container_name>, we could also use <container_id>.

```shell
docker exec -it <container_name> /bin/bash
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
docker tag <image_name>:<image_tag> <docker_userId>/<ōimage_name>:<image_tag>
```

- push your images. for example, image -->`mayankg/my-app_image:v2.0`

```shell
docker push <image_name>:<image_tag> <docker_userId>/<image_name>:<image_tag>
```

### Pull a docker image from the docker hub

```shell
docker pull <exact_image_name>
```