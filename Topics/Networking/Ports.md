# Ports

> Notes on Ports.

- [Ports](#ports)
- [Port](#port)
- [Netstat](#netstat)
- [Port Numbers](#port-numbers)
  - [System or Well-Known Ports](#system-or-well-known-ports)
    - [Examples](#examples)
  - [User or Registered Ports](#user-or-registered-ports)
    - [Examples](#examples-1)
  - [Dynamic or Private Ports](#dynamic-or-private-ports)
- [Client-Server Ports](#client-server-ports)
  - [Final Example](#final-example)
    - [0 – Local Machine as a Listening Server](#0--local-machine-as-a-listening-server)
    - [1 – Local Machine Handling a Client as a Server](#1--local-machine-handling-a-client-as-a-server)
    - [2 – Local Machine as a Client Connecting to a Server](#2--local-machine-as-a-client-connecting-to-a-server)
    - [3 – Local Machine in Another Client Session](#3--local-machine-in-another-client-session)

# Port

A **port** is _not_ a physical connection but a **logical endpoint** used by programs and services to exchange information. It determines which program or service on a system handles incoming data.

Ports are identified by numbers ranging from 0 to 65535 and are always associated with an IP address. Together, an **IP address** and a **port number** allow data to be sent to the correct destination.

For example, when visiting a website, your browser requests the page by using an IP address to locate the server. Depending on whether the connection is **HTTP (port 80)** or **HTTPS (port 443)**, the request is forwarded to the appropriate port.

# Netstat

**Netstat** (short for "Network Statistics") is a tool that displays current network connections and port activity.

Example output of `netstat -n`:

```
Proto  Local Address    Foreign Address         State
TCP    127.0.0.1:49902  XXX.XXX.XXX.XXX:80      ESTABLISHED
```

This output shows:
- The local machine's port **49902** is connected to **port 80** on **XXX.XXX.XXX.XXX**.
- Since port 80 is typically used for HTTP, we can assume this is an active HTTP connection.

# Port Numbers

Port numbers range from **0 to 65535** and are managed by the **Internet Assigned Numbers Authority (IANA)**. These port numbers are broken down into three range categories.

## System or Well-Known Ports

Ports **0 to 1023** are reserved for common, widely-used services.

### Examples
- **80** – HTTP (Web Traffic)
- **443** – HTTPS (Secure Web Traffic)
- **8080** – Alternative HTTP port
  - Often used when port 80 is unavailable.
  - Common in web development.
- **21** – FTP (File Transfer Protocol)
- **25** – SMTP (Simple Mail Transfer Protocol, for Email)

## User or Registered Ports

Ports **1024 to 49151** are available for software developers and companies to register for specific applications.

### Examples
- **5432** – PostgreSQL
- **8000** – Django
- **8888** – Jupyter Notebook
- **6379** – Redis

## Dynamic or Private Ports

Ports **49152 to 65535** are used temporarily by client devices during a session. Your computer assigns these dynamically, as seen in the [Netstat](#netstat) example.

# Client-Server Ports

- **Servers** use [System/Well-Known Ports](#system-or-well-known-ports) and [User/Registered Ports](#user-or-registered-ports).
- **Clients** use [Dynamic/Private Ports](#dynamic-or-private-ports) during a session.

> **Note:** Any computer can be configured to act as a server. Running `netstat -an` can show which services your system is hosting.

## Final Example

```
Proto  Local Address    Foreign Address         State
TCP    127.0.0.1:21     0.0.0.0:0               LISTENING
TCP    127.0.0.1:80     111.111.111.111:49902   ESTABLISHED
TCP    127.0.0.1:51031  222.222.222.222:80      ESTABLISHED
TCP    127.0.0.1:60718  333.333.333.333:80      ESTABLISHED
```

### 0 – Local Machine as a Listening Server
- The local machine (`127.0.0.1`) is **listening** for connections on port **21** (FTP service).

### 1 – Local Machine Handling a Client as a Server
- The local machine (`127.0.0.1`) has an **established** HTTP connection on port **80** with `111.111.111.111`, which is using port **49902** (a temporary client port) for the session.

### 2 – Local Machine as a Client Connecting to a Server
- The local machine (`127.0.0.1`) is using **port 51031** (a temporary client port) for the session to connect to `222.222.222.222`'s HTTP service (port 80).

### 3 – Local Machine in Another Client Session
- The local machine (`127.0.0.1`) is using **port 60718** (a temporary client port) for the session to connect to `333.333.333.333`'s HTTP service (port 80).