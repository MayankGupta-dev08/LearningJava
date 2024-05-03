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

### To run the container for a particular docker image

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

### To run the bash inside a particular container

- instead of <container_name>, we could also use <container_id>.

```shell
docker exec -it <container_name> bash
```

### Check the logs for the container

- instead of <container_name>, we could also use <container_id>.

```shell
docker log <container_name> bash
```