# Docker

> Notes on Docker.

# Table of Contents

- [Docker](#docker)
- [Table of Contents](#table-of-contents)
- [Background](#background)
- [Glossary](#glossary)
    - [Docker Engine](#docker-engine)
      - [Docker Daemon](#docker-daemon)
    - [Docker Image](#docker-image)
      - [Image Registries](#image-registries)
    - [Docker Container](#docker-container)
    - [Docker Volume](#docker-volume)
    - [Docker Networking](#docker-networking)
- [Docker Build (Images)](#docker-build-images)
  - [`Dockerfile`](#dockerfile)
    - [Some Common Instructions](#some-common-instructions)
      - [`FROM`](#from)
      - [`LABEL`](#label)
      - [`ENV`](#env)
      - [`WORKDIR`](#workdir)
      - [`RUN`](#run)
      - [`EXPOSE`](#expose)
      - [`VOLUME`](#volume)
      - [`CMD ["<executable>", "<arg1>", "<arg2>", ...]`](#cmd-executable-arg1-arg2-)
    - [Anatomy \& Analysis](#anatomy--analysis)
- [Docker Compose (Containers)](#docker-compose-containers)
  - [`docker-compose.yml`](#docker-composeyml)
    - [Some Common Top-Level Keys](#some-common-top-level-keys)
      - [`version`](#version)
      - [`services`](#services)
        - [Some Common Keys](#some-common-keys)
      - [`networks`](#networks)
        - [Some Common Keys](#some-common-keys-1)
      - [`volumes`](#volumes)
        - [Some Common Keys](#some-common-keys-2)
      - [`configs`](#configs)
        - [Some Common Keys](#some-common-keys-3)
      - [`secrets`](#secrets)
        - [Some Common Keys](#some-common-keys-4)
    - [Anatomy \& Analysis](#anatomy--analysis-1)
  - [`docker-compose.override.yml`](#docker-composeoverrideyml)
- [Docker Volumes](#docker-volumes)
    - [Named Volumes](#named-volumes)
    - [Anonymous Volumes](#anonymous-volumes)
    - [Bind Mounts](#bind-mounts)
- [Docker Networking](#docker-networking-1)
    - [Bridge Network](#bridge-network)
    - [Host Network](#host-network)
    - [Overlay Network](#overlay-network)
- [Scaling \& Orchestration](#scaling--orchestration)
  - [Docker](#docker-1)
    - [Scaling](#scaling)
      - [Before Version `3.x`](#before-version-3x)
      - [After Version `3.x`](#after-version-3x)
    - [Multi-Container Applications](#multi-container-applications)
  - [Docker Swarm](#docker-swarm)
  - [Kubernetes (K8s)](#kubernetes-k8s)
    - [Helm](#helm)
- [Commands](#commands)
    - [`docker build`](#docker-build)
    - [`docker compose`](#docker-compose)
      - [`docker compose up`](#docker-compose-up)
      - [`docker compose down`](#docker-compose-down)
    - [`docker exec`](#docker-exec)
    - [`docker logs`](#docker-logs)
    - [`docker ps`](#docker-ps)
    - [`docker network`](#docker-network)
    - [`docker volume`](#docker-volume-1)
      - [`docker volume create`](#docker-volume-create)
      - [`docker volume ls`](#docker-volume-ls)
      - [`docker volume inspect`](#docker-volume-inspect)
      - [`docker volume rm`](#docker-volume-rm)
    - [`docker prune`](#docker-prune)

# Background

- Docker vs Container vs Virtual Machine

# Glossary

### Docker Engine

#### Docker Daemon

### Docker Image

#### Image Registries

### Docker Container

### Docker Volume

### Docker Networking

# Docker Build (Images)

## `Dockerfile`

### Some Common Instructions

#### `FROM`

#### `LABEL`

#### `ENV`

#### `WORKDIR`

#### `RUN`

#### `EXPOSE`

#### `VOLUME`

#### `CMD ["<executable>", "<arg1>", "<arg2>", ...]`

### Anatomy & Analysis

# Docker Compose (Containers)

Needs to include:

- Running & Deploying container
- Executing inside running container
- Stopping & Restarting containers

## `docker-compose.yml`

### Some Common Top-Level Keys

#### `version`

#### `services`

##### Some Common Keys

- `image`
- `build`
- `ports`
- `volumes`
- `environment`
- `command`
- `depends_on`
- `networks`
- `restart`
- `env_file`
- `logging`

#### `networks`

##### Some Common Keys

- `name`
- `driver`
- `driver-opts`
- `external`

#### `volumes`

##### Some Common Keys

- `name`
- `driver`
- `driver_opts`
- `external`

#### `configs`

##### Some Common Keys

- `file`
- `source`
- `target`

#### `secrets`

##### Some Common Keys

- `file`
- `source`
- `target`

### Anatomy & Analysis

## `docker-compose.override.yml`

# Docker Volumes

### Named Volumes

### Anonymous Volumes

### Bind Mounts

# Docker Networking

### Bridge Network

### Host Network

### Overlay Network

# Scaling & Orchestration

## Docker

### Scaling

#### Before Version `3.x`

#### After Version `3.x`

### Multi-Container Applications

## Docker Swarm

## Kubernetes (K8s)

### Helm

# Commands

### `docker build`

### `docker compose`

#### `docker compose up`

#### `docker compose down`

### `docker exec`

### `docker logs`

### `docker ps`

### `docker network`

### `docker volume`

#### `docker volume create`

#### `docker volume ls`

#### `docker volume inspect`

#### `docker volume rm`

### `docker prune`
