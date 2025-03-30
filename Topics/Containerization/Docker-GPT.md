# Docker

> Notes on Docker.

- [Docker](#docker)
- [Definitions](#definitions)
  - [Terminology](#terminology)
    - [Docker Desktop](#docker-desktop)
    - [Docker Engine](#docker-engine)
    - [Docker Daemon](#docker-daemon)
    - [Docker Image](#docker-image)
    - [Docker Image Registry](#docker-image-registry)
    - [Docker Container](#docker-container)
    - [Docker Networking](#docker-networking)
- [Docker Commands](#docker-commands)
    - [`docker build`](#docker-build)
    - [`docker compose up`](#docker-compose-up)
    - [`docker compose down`](#docker-compose-down)
    - [`docker logs`](#docker-logs)
    - [`docker ps`](#docker-ps)
    - [`docker network`](#docker-network)
    - [`docker volume`](#docker-volume)
    - [`docker prune`](#docker-prune)
- [Docker Build \& Images](#docker-build--images)
    - [Dockerfile Overview](#dockerfile-overview)
    - [Dockerfile Best Practices](#dockerfile-best-practices)
    - [Step-by-Step Docker Image Creation](#step-by-step-docker-image-creation)
- [Docker Compose Overview](#docker-compose-overview)
  - [Concepts](#concepts)
    - [Docker Compose Services](#docker-compose-services)
    - [Docker Compose Volumes](#docker-compose-volumes)
    - [Docker Compose Networks](#docker-compose-networks)
    - [Docker Compose Environment](#docker-compose-environment)
  - [Running \& Managing Containers](#running--managing-containers)
    - [Running \& Deploying a Docker Container](#running--deploying-a-docker-container)
    - [Executing Inside a Running Container](#executing-inside-a-running-container)
    - [Stopping \& Restarting Containers](#stopping--restarting-containers)
- [Scaling Beyond Docker Compose](#scaling-beyond-docker-compose)
    - [Docker Swarm](#docker-swarm)
    - [Kubernetes (K8s)](#kubernetes-k8s)

# Definitions

## Terminology

### Docker Desktop

- A GUI application for managing Docker containers, images, and settings on macOS and Windows. It simplifies Docker installation and configuration on these platforms.

### Docker Engine

- The core component of Docker, responsible for building, running, and managing containers. It consists of the Docker Daemon, the API, and the Docker CLI.

### Docker Daemon

- A background service that manages Docker containers. It handles container lifecycle management, image management, networking, and volume management.

### Docker Image

- A read-only template used to create containers. Images contain the application and all dependencies needed to run it, including the operating system, libraries, and configuration files.

### Docker Image Registry

- A centralized repository where Docker images are stored and shared. The most common registry is Docker Hub, but private registries can also be used.

### Docker Container

- A lightweight, portable, and self-sufficient executable package that contains everything needed to run a piece of software. Containers are instances of Docker images.

### Docker Networking

- How Docker containers communicate with each other and external systems.
  - **Bridge** (default) – Isolated internal network for containers.
  - **Host** – Shares the host’s network stack.
  - **Overlay** – Used in multi-host environments like Swarm.

# Docker Commands

### `docker build`

- Builds an image from a Dockerfile. `docker build -t <image_name> .`

### `docker compose up`

- Starts containers defined in a `docker-compose.yml` file. Use the `-d` flag for detached mode.

### `docker compose down`

- Stops and removes containers, networks, and volumes defined in a `docker-compose.yml` file.

### `docker logs`

- Shows the logs from a container. `docker logs <container_id>`

### `docker ps`

- Lists running containers. Use `docker ps -a` to show all containers (running and stopped).

### `docker network`

- `docker network ls` – List available networks.
- `docker network inspect <network_name>` – View details of a network.

### `docker volume`

- `docker volume create <volume_name>` – Create a volume.
- `docker volume inspect <volume_name>` – Inspect a volume.
- `docker volume prune` – Remove unused volumes.

### `docker prune`

- `docker system prune` – Remove unused data (containers, images, networks, volumes).
- `docker image prune` – Remove unused images.

# Docker Build & Images

### Dockerfile Overview

- A text document that contains a series of instructions for building a Docker image. It defines the base image, environment variables, and the application installation process.

### Dockerfile Best Practices

- Use **multi-stage builds** to keep images small.
- Optimize **layer caching** by ordering instructions correctly.
- Use **minimal base images** like `alpine` when possible.
- Avoid running containers as root (`USER` directive).

### Step-by-Step Docker Image Creation

1. Create a `Dockerfile` that specifies the base image and application setup.
2. Run `docker build -t <image_name> .` to build the image.
3. Push the image to a registry using `docker push <image_name>` (optional).
4. Run the container with `docker run <image_name>`.

# Docker Compose Overview

## Concepts

### Docker Compose Services

- Define individual containers and their configuration in a `docker-compose.yml` file.

### Docker Compose Volumes

- Difference between **bind mounts** and **volumes**.
  - Bind mounts are linked to a specific location on the host.
  - Volumes are Docker-managed storage that persist across container restarts.

### Docker Compose Networks

- Custom networks for inter-container communication.
- How to expose services externally using the `ports` directive.

### Docker Compose Environment

- Managing environment variables (`.env` files).

## Running & Managing Containers

### Running & Deploying a Docker Container

- `docker run -d -p 8080:80 <image_name>` – Start a container in detached mode.
- `docker start <container_id>` – Start a stopped container.

### Executing Inside a Running Container

- `docker exec -it <container_id> bash` – Open an interactive shell in a running container.
- `docker attach <container_id>` – Attach to a running container’s terminal.

### Stopping & Restarting Containers

- `docker stop <container_id>` – Gracefully stop a running container.
- `docker restart <container_id>` – Restart a container.

# Scaling Beyond Docker Compose

### Docker Swarm
- Basic orchestration built into Docker.
- `docker swarm init` – Initialize a Swarm cluster.

### Kubernetes (K8s)
- Advanced container orchestration for scaling large applications.
- Defines workloads using YAML manifests.
