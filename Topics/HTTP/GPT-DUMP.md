# HTTP

> Mostly unreviewed truncated infodump from GPT for me to reference later.

- [HTTP](#http)
- [Key HTTP RFCs to Focus On](#key-http-rfcs-to-focus-on)
    - [RFC 9110 – HTTP Semantics](#rfc-9110--http-semantics)
    - [RFC 9111 – HTTP Caching](#rfc-9111--http-caching)
    - [RFC 9112 – HTTP/1.1](#rfc-9112--http11)
    - [RFC 9113 – HTTP/2](#rfc-9113--http2)
    - [RFC 9114 – HTTP/3](#rfc-9114--http3)
- [Other HTTP RFCs](#other-http-rfcs)
  - [Header Compression Mechanisms](#header-compression-mechanisms)
    - [RFC 7541 – HPACK: Header Compression for HTTP/2](#rfc-7541--hpack-header-compression-for-http2)
    - [RFC 9204 – QPACK: Header Compression for HTTP/3](#rfc-9204--qpack-header-compression-for-http3)
  - [Security Enhancements](#security-enhancements)
    - [RFC 6797 – HTTP Strict Transport Security (HSTS)](#rfc-6797--http-strict-transport-security-hsts)
    - [RFC 7469 – Public Key Pinning Extension for HTTP (HPKP)](#rfc-7469--public-key-pinning-extension-for-http-hpkp)
  - [State Management](#state-management)
    - [RFC 6265 – HTTP State Management Mechanism](#rfc-6265--http-state-management-mechanism)
  - [Protocol Negotiation](#protocol-negotiation)
    - [RFC 7301 – Application-Layer Protocol Negotiation (ALPN)](#rfc-7301--application-layer-protocol-negotiation-alpn)
  - [WebSockets](#websockets)
    - [RFC 6455 – The WebSocket Protocol](#rfc-6455--the-websocket-protocol)
  - [Conditional Requests and Range Requests](#conditional-requests-and-range-requests)
    - [RFC 7232 – HTTP/1.1: Conditional Requests](#rfc-7232--http11-conditional-requests)
    - [RFC 7233 – HTTP/1.1: Range Requests](#rfc-7233--http11-range-requests)
  - [Authentication](#authentication)
    - [RFC 7235 – HTTP/1.1: Authentication](#rfc-7235--http11-authentication)
- [Ref](#ref)


# Key HTTP RFCs to Focus On

### RFC 9110 – HTTP Semantics

- This RFC defines the core concepts of HTTP that remain consistent across all versions (methods like GET/POST, status codes, headers, etc.).
- It's the backbone of HTTP, so understanding this first gives you a solid foundation.

### RFC 9111 – HTTP Caching

- This RFC focuses on caching mechanisms in HTTP, a critical part of web performance.
- Understanding caching before diving into individual versions helps you see how content delivery can be optimized.

### RFC 9112 – HTTP/1.1

- After grasping the semantics and caching, this RFC details the structure, syntax, and operations of HTTP/1.1.
- It introduces persistent connections and chunked transfers.

### RFC 9113 – HTTP/2

- This RFC introduces significant improvements like multiplexing, stream prioritization, and header compression.
- You'll see how HTTP evolved from its simpler 1.1 version.

### RFC 9114 – HTTP/3

- Finally, this RFC covers the most modern HTTP version built on QUIC, providing faster and more reliable connections.
- Reading it last helps you appreciate the challenges HTTP/3 aims to solve based on its predecessors.

# Other HTTP RFCs

In addition to the core HTTP RFCs you've already considered, several other RFCs provide valuable insights into specific aspects of HTTP and its related technologies. Here's a curated list to enhance your understanding

## Header Compression Mechanisms

### RFC 7541 – HPACK: Header Compression for HTTP/2

- Details the HPACK compression format used in HTTP/2 to reduce header size, improving performance.

### RFC 9204 – QPACK: Header Compression for HTTP/3

- Describes QPACK, the header compression scheme tailored for HTTP/3, addressing challenges posed by its underlying transport protocol, QUIC.

## Security Enhancements

### RFC 6797 – HTTP Strict Transport Security (HSTS)

- Introduces a mechanism enabling websites to declare themselves accessible only via secure connections, mitigating certain types of attacks.

### RFC 7469 – Public Key Pinning Extension for HTTP (HPKP)

- Defines a method for HTTPS websites to resist impersonation by specifying which public keys are valid for a domain.

## State Management

### RFC 6265 – HTTP State Management Mechanism

- Standardizes the use of cookies for state management between clients and servers, essential for session handling and personalization.

## Protocol Negotiation

### RFC 7301 – Application-Layer Protocol Negotiation (ALPN)

- Specifies a TLS extension for negotiating the application protocol during the TLS handshake, crucial for protocols like HTTP/2 and HTTP/3.

## WebSockets

### RFC 6455 – The WebSocket Protocol

- Defines a protocol for full-duplex communication channels over a single TCP connection, enabling real-time data transfer between clients and servers.

## Conditional Requests and Range Requests

### RFC 7232 – HTTP/1.1: Conditional Requests

- Explains mechanisms like ETags and Last-Modified headers, allowing clients to make requests based on the state of a resource.

### RFC 7233 – HTTP/1.1: Range Requests

- Details how clients can request specific parts of a resource, facilitating resumable downloads and efficient media streaming.

## Authentication

### RFC 7235 – HTTP/1.1: Authentication

- Covers the framework for HTTP authentication, including challenges and responses, laying the groundwork for schemes like Basic and Digest authentication.

# Ref

[IETF's Guide on Reading RFCs](https://www.ietf.org/blog/how-read-rfc/?utm_source=chatgpt.com)