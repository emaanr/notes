# Docker

> Notes on Docker.

# Table of Contents

- [Docker](#docker)
- [Table of Contents](#table-of-contents)
- [Background](#background)
  - [Containerization vs Virtualization](#containerization-vs-virtualization)
    - [Containerization](#containerization)
      - [Linux](#linux)
    - [Virtualization](#virtualization)
    - [Computing Environment Stack](#computing-environment-stack)
    - [Conclusion](#conclusion)
    - [Key Points](#key-points)
    - [Compare \& Contrast](#compare--contrast)
- [Glossary](#glossary)
    - [Docker Engine](#docker-engine)
      - [Docker CLI (Client)](#docker-cli-client)
        - [`docker`](#docker-1)
      - [Docker Daemon](#docker-daemon)
        - [`dockerd`](#dockerd)
      - [Docker APIs](#docker-apis)
      - [Container Runtime](#container-runtime)
        - [`containerd`](#containerd)
        - [`runc`](#runc)
    - [Docker Desktop](#docker-desktop)
      - [Docker Toolbox](#docker-toolbox)
    - [Docker Context](#docker-context)
    - [Dockerfile](#dockerfile)
    - [Docker Compose](#docker-compose)
    - [Docker Image](#docker-image)
      - [Layers](#layers)
      - [Image Registries](#image-registries)
        - [Docker Hub](#docker-hub)
    - [Docker Container](#docker-container)
      - [Init System / PID 1](#init-system--pid-1)
    - [Docker Volume](#docker-volume)
    - [Docker Networking](#docker-networking)
- [Docker Build (Images)](#docker-build-images)
  - [`Dockerfile`](#dockerfile-1)
    - [Some Common Instructions](#some-common-instructions)
      - [`FROM`](#from)
      - [`ARG`](#arg)
      - [`LABEL`](#label)
      - [`ENV`](#env)
      - [`WORKDIR`](#workdir)
      - [`RUN`](#run)
      - [`EXPOSE`](#expose)
      - [`VOLUME`](#volume)
      - [`CMD ["<executable>", "<arg1>", "<arg2>", ...]`](#cmd-executable-arg1-arg2-)
      - [`ENTRYPOINT ["<executable>", "<arg1>", "<arg2>", ...]`](#entrypoint-executable-arg1-arg2-)
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
  - [`docker-compose.test.yml`](#docker-composetestyml)
- [Docker Volumes](#docker-volumes)
    - [Named Volumes](#named-volumes)
    - [Anonymous Volumes](#anonymous-volumes)
    - [Bind Mounts](#bind-mounts)
- [Docker Networking](#docker-networking-1)
    - [Bridge Network](#bridge-network)
    - [Host Network](#host-network)
    - [Overlay Network](#overlay-network)
    - [Other](#other)
- [Scaling \& Orchestration](#scaling--orchestration)
  - [Docker](#docker-2)
    - [Scaling](#scaling)
      - [Before Version `3.x`](#before-version-3x)
      - [After Version `3.x`](#after-version-3x)
    - [Multi-Container Applications](#multi-container-applications)
  - [Docker Swarm](#docker-swarm)
  - [Kubernetes (K8s)](#kubernetes-k8s)
    - [Helm](#helm)
- [Commands](#commands)
    - [`docker`](#docker-3)
      - [`--help`](#--help)
      - [`--version`](#--version)
    - [`docker build`](#docker-build)
      - [`-t`/`--tag`](#-t--tag)
      - [`-f`/`--file`](#-f--file)
      - [`--no-cache`](#--no-cache)
      - [`--build-arg`](#--build-arg)
    - [`docker run`](#docker-run)
      - [`-d`/`--detach`](#-d--detach)
      - [`-p`/`--publish`](#-p--publish)
      - [`--name`](#--name)
      - [`-v`/`--volume`](#-v--volume)
      - [`-rm`](#-rm)
      - [`-e`/`--env`](#-e--env)
      - [`--entrypoint`](#--entrypoint)
      - [`--network`](#--network)
    - [`docker compose`](#docker-compose-1)
      - [`docker compose up`](#docker-compose-up)
        - [`-d`/`--detatch`](#-d--detatch)
        - [`--build`](#--build)
        - [`--force-recreate`](#--force-recreate)
        - [`--remove-orphans`](#--remove-orphans)
      - [`docker compose down`](#docker-compose-down)
      - [`docker compose logs`](#docker-compose-logs)
      - [`docker compose exec <service> <command>`](#docker-compose-exec-service-command)
      - [`docker compose restart <service>`](#docker-compose-restart-service)
    - [`docker exec`](#docker-exec)
    - [`docker logs`](#docker-logs)
    - [`docker ps`](#docker-ps)
      - [`-a`/`--all`](#-a--all)
      - [`-q`/`--quiet`](#-q--quiet)
    - [`docker network`](#docker-network)
    - [`docker volume`](#docker-volume-1)
      - [`docker volume create`](#docker-volume-create)
      - [`docker volume ls`](#docker-volume-ls)
      - [`docker volume inspect`](#docker-volume-inspect)
      - [`docker volume rm`](#docker-volume-rm)
    - [`docker prune`](#docker-prune)
      - [`docker container prune`](#docker-container-prune)
      - [`docker image prune`](#docker-image-prune)
      - [`docker volume prune`](#docker-volume-prune)
      - [`docker network prune`](#docker-network-prune)
      - [`docker system prune`](#docker-system-prune)
        - [`-a`](#-a)
        - [`--volumes`](#--volumes)
- [Resources](#resources)

# Background

It's a good idea to understand the foundational knowledge behind Docker and its inception.

## Containerization vs Virtualization

Containerization can be thought of as a type of Virtualization technology.

### Containerization

Containers are the product of containerization, which is sometimes seen as a successor to virtual machines. However, both containers and virtual machines are virtualization technologies.

Containers use OS-level virtualization, meaning they share the host operating system's kernel while isolating applications from one another:

- User space is a concept common to all operating system kernels, referring to the area of memory where user programs run, separate from the kernel itself. This separation ensures that applications can operate independently from the kernel and from each other, even though they share the same OS kernel.

#### Linux

In Linux, user space is managed through namespaces and cgroups, which containers borrow and use for isolation and resource management. Docker, which was originally designed specifically for Linux, leverages these features to enable containerization:

- Namespaces provide isolation for various system resources within the user space, such as:
  - PID namespace isolates process IDs, so each container can have its own set of process IDs.
  - Network namespace isolates networking resources, allowing containers to have independent network configurations.
  - Mount namespace isolates file systems, giving each container its own view of the filesystem.
- Cgroups (control groups) are used to manage and limit resource usage for containers. They allow the system to allocate CPU, memory, and I/O resources to ensure that no single container consumes excessive resources, thus promoting fairness and stability across all containers running on the same system.

These two features—namespaces for isolation and cgroups for resource management—work together to provide containers with the ability to run applications in isolated environments while still being lightweight and efficient.

### Virtualization

Virtual machines, on the other hand, use hardware-level virtualization, meaning they run a full guest operating system with its own kernel, typically between the hardware and the VMs, through a hypervisor. There are two types of hypervisors:

- Type 1 (bare-metal) hypervisors run directly on the hardware and manage the VMs.
- Type 2 (hosted) hypervisors run on top of a host operating system and manage the VMs as applications within that OS.

### Computing Environment Stack

```
┌──────────────────────┐
│ Application Layer    │
├──────────────────────┤
│ OS / Kernel Layer    │
├──────────────────────┤
│ Hardware (CPU, RAM)  │
└──────────────────────┘
```

Think of the computing environment as a 3-layer stack:

- VMs virtualize both the OS Layer and Application Layer, using a hypervisor (like VirtualBox, VMware, Hyper-V).
  - Each VM includes its own OS and kernel.
- Containers virtualize only the Application Layer, sharing the host OS/kernel.
  - That's what makes them faster, smaller, and more portable

### Conclusion

Hardware advancements have increased computing capabilities, which is a key driver behind virtualization technologies. Both containers and virtual machines aim to isolate and run multiple applications or environments on the same physical hardware to maximize compute efficiency, reduce costs, and save space.

Containers are lightweight and fast, using minimal resources while offering portability. In contrast, virtual machines are more heavyweight because they require a full operating system in each VM, with its own kernel and isolated resources. Both technologies offer distinct advantages and are often used together in modern architectures to provide flexibility, performance, and isolation where needed.

### Key Points

- Virtual Machines (VMs):
  - Use a hypervisor to emulate entire operating systems.
  - Each VM runs a full OS with its own kernel on top of virtualized hardware.
  - Heavy, slower to start, and resource-intensive.
- Containers:
  - Use the host OS's kernel and isolate applications in separate user spaces.
  - Originally Linux-only, relying on Linux kernel features like namespaces and cgroups.
  - Lightweight, fast, and efficient.

### Compare & Contrast

|                      | Virtual Machines (VMs)                | Containers                                    |
| -------------------- | ------------------------------------- | --------------------------------------------- |
| What they virtualize | Entire OS + hardware                  | Only the application environment (user space) |
| Isolation level      | OS-level + hardware-level             | Process-level                                 |
| Performance          | Heavier, slower to boot               | Lightweight, fast                             |
| Resource usage       | Requires more memory and CPU          | Efficient, smaller footprint                  |
| Portability          | Good, but large                       | Excellent, small and consistent               |
| Use case             | Strong isolation (e.g., multi-tenant) | Microservices, DevOps, CI/CD pipelines        |

# Glossary

### Docker Engine

- An open source containerization technology for building and containerizing your applications. Docker Engine acts as a client-server application comprised of:
  - A server with the long-running background process called `dockerd` (the Docker Daemon).
  - A REST API which specifies interfaces that programs can use to talk to and instruct the Docker Daemon.
  - A command-line interface (CLI) client called `docker`, used to issue commands to the daemon through the API.

#### Docker CLI (Client)

- The command-line interface invoked with `docker` that users interact with to send commands to the Docker Daemon via the Docker API under the hood. Some examples include: [`docker build`](#docker-build), [`docker run`](#docker-run), [`docker ps`](#docker-ps), etc. Can also be used by scripts, automation tools, and GUIs that intergrate with Docker.

##### `docker`

- Named after the project itself and is the user-facing command-line tool that acts as the client in Docker's client-server model.

#### Docker Daemon

- The long-running background process that manages Docker objects like containers, images, networks, and volumes. Listens for Docker API requests and processes them. Typically started as a system service on Linux or as part of Docker Desktop on Windows/macOS.

> What is a _**daemon**_? A daemon is a background process that runs continuously and autonomously on a computer system, typically without direct user interaction. Daemons often handle system-level tasks or services, such as responding to requests or managing resources, and they are designed to keep running in the background to support various functions or applications. In the context of Docker, the Docker Daemon (`dockerd`) is the core component that listens for requests from clients, such as the Docker CLI, and manages Docker objects (containers, images, networks, volumes) by executing the necessary actions as requested.

##### `dockerd`

- Short for _Docker Daemon_, following a common Linux convention of appending `d` to daemon processes.

#### Docker APIs

- RESTful APIs that define how the Docker CLI (and other tools) can communicate with the Docker Daemon. Enable sdevelopers to manage Docker through code (e.g., scripting, automation, third-party apps). Used under the hood by `docker`, Docker Compose, and even GUIs (e.g. Portainer).

#### Container Runtime

- The component responsible for creating and running containers by interacting directly with the operating system kernel. It handles setting up the container's isolated environment and launching the containerized process.

##### `containerd`

- A high-level container runtime thathandles all aspects of container lifecycle management.
- Short for _container daemon_.

##### `runc`

- A low-level runtime that `containerd` invokes to actually create and run containers. It applies Linux kernel features such as:
  - Namespaces (for isolation of processes, networks, and filesystems)
  - Cgroups (for resource control)
  - `chroot`/`pivot_root` (for filesystem remapping)
  - Security modules like `seccomp`, `AppArmor`, or `SELinux`
  - Short for _run container_.

### Docker Desktop

- An installable application for Windows and macOS that enables Linux containers to run on non-Linux systems. Docker Desktop uses a hypervisor layer to run a lightweight Linux distribution, providing the necessary Linux kernel for Linux container execution.
- Includes the Docker Engine, Docker CLI (Client), Docker Compose, Kubernetes, and a few others that can be further explored on the official Docker Documentation [here](https://docs.docker.com/desktop/).

#### Docker Toolbox

- A deprecated toolset that allowed users to run Docker on older versions of Windows and macOS that did not support Docker Desktop. It used Oracle VirtualBox to create a virtual machine running Docker Engine on a lightweight Linux system. As of now, Docker Toolbox is no longer actively maintained and has been replaced by Docker Desktop for modern systems.

### Docker Context

- Docker Contexts let you define and switch between multiple Docker environments (called contexts)—for example, your local machine, a remote server, or a cloud-based Docker host. Each context stores connection info and credentials, so you can run Docker commands against different environments without having to reconfigure every time.

### Dockerfile

- A text file called `Dockerfile` that contains a series of instructions for Docker to build an image. It defines the environment and behavior of the container, including the base image, dependencies, and commands to execute when the container starts.

### Docker Compose

- A tool for defining and running multi-container Docker applications. It uses a YAML file called `docker-compose.yml` to configure application services, networks, and volumes, making it easier to manage complex Docker environments that consist of multiple containers.

### Docker Image

- A read-only template used to create Docker containers. Images include everything needed to run an application—code, libraries, dependencies, and configuration files—encapsulated in a portable package. Images are built from a `Dockerfile`.

#### Layers

- Each instruction in a Dockerfile generates a new layer in the resulting Docker image. These layers are cached to optimize future builds by reusing unchanged layers. The layers are stacked in a specific order to form the final image. When a change is made to a layer, only that layer and any subsequent layers that depend on it are rebuilt. Layers above it remain unaffected unless explicitly modified or if their content depends on the change in the modified layer.

#### Image Registries

- A system for storing and sharing Docker images. Registries allow users to upload, download, and manage images. They can be public or private.

##### Docker Hub

- The default public registry provided by Docker, where users can find, share, and distribute container images. It includes popular official images for databases, web servers, and programming environments, as well as the option for users to create private repositories. This is the primary source for pulling base images for various applications.

### Docker Container

- A runtime instance of a Docker image. A container is an isolated environment where the application runs. It uses the host system's kernel but is separated from other containers and the host via namespaces and cgroups.

#### Init System / PID 1

- The first process in a container, often responsible for managing other processes in the container. It's a key component of the container's lifecycle, initializing the environment and running the main process. The init system acts as a "parent" process (PID 1), which can manage child processes, clean up resources, and handle signals.

### Docker Volume

- A persistent storage mechanism for Docker containers. Volumes allow containers to store and share data between them, even after the container stops or is removed. Unlike container filesystems, which are ephemeral, volumes exist outside the container's lifecycle.

### Docker Networking

- Docker Networking defines how containers communicate:
  - With each other, whether on the same host or across different hosts.
  - With external networks, such as the internet or a company intranet.
- Docker provides built-in network drivers (like [`bridge`](#bridge-network), [`host`](#host-network), [`overlay`](#overlay-network), [etc.](#other)) that create virtual networks, enabling controlled and isolated communication between containers and between containers and external systems.

# Docker Build (Images)

## `Dockerfile`

### Some Common Instructions

#### `FROM`

#### `ARG`

#### `LABEL`

#### `ENV`

#### `WORKDIR`

#### `RUN`

#### `EXPOSE`

#### `VOLUME`

#### `CMD ["<executable>", "<arg1>", "<arg2>", ...]`

#### `ENTRYPOINT ["<executable>", "<arg1>", "<arg2>", ...]`

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

## `docker-compose.test.yml`

# Docker Volumes

### Named Volumes

### Anonymous Volumes

### Bind Mounts

# Docker Networking

### Bridge Network

### Host Network

### Overlay Network

### Other

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

### `docker`

#### `--help`

#### `--version`

### `docker build`

#### `-t`/`--tag`

#### `-f`/`--file`

#### `--no-cache`

#### `--build-arg`

### `docker run`

#### `-d`/`--detach`

#### `-p`/`--publish`

#### `--name`

#### `-v`/`--volume`

#### `-rm`

#### `-e`/`--env`

#### `--entrypoint`

#### `--network`

### `docker compose`

#### `docker compose up`

##### `-d`/`--detatch`

##### `--build`

##### `--force-recreate`

##### `--remove-orphans`

#### `docker compose down`

#### `docker compose logs`

#### `docker compose exec <service> <command>`

#### `docker compose restart <service>`

### `docker exec`

### `docker logs`

### `docker ps`

#### `-a`/`--all`

#### `-q`/`--quiet`

### `docker network`

### `docker volume`

#### `docker volume create`

#### `docker volume ls`

#### `docker volume inspect`

#### `docker volume rm`

### `docker prune`

#### `docker container prune`

#### `docker image prune`

#### `docker volume prune`

#### `docker network prune`

#### `docker system prune`

##### `-a`

##### `--volumes`

# Resources

[CLI Reference](https://docs.docker.com/reference/cli/docker/)
