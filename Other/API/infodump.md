# API

    Application Programming Interface.

# Table of Contents

- [API](#api)
- [Table of Contents](#table-of-contents)
- [Definitons](#definitons)
  - [Interface](#interface)
    - [Example: Buttons](#example-buttons)
  - [API](#api-1)
    - [Note](#note)
      - [Example: Strings](#example-strings)
      - [Example: Operating Systems](#example-operating-systems)
      - [Example: Web Browsers](#example-web-browsers)
- [Remote API](#remote-api)
  - [Example: Shazam](#example-shazam)
- [Web Review](#web-review)
  - [Client-Server](#client-server)
  - [URL/URI](#urluri)
  - [Scheme](#scheme)
  - [HTTP](#http)
    - [Protocol](#protocol)
      - [Request](#request)
        - [Example: HTTP Requests](#example-http-requests)
        - [Verb](#verb)
      - [Transfer](#transfer)
      - [Response](#response)
        - [Body](#body)
          - [HypterText](#hyptertext)
      - [Stateless](#stateless)
      - [Request Methods](#request-methods)
      - [Query String Parameters](#query-string-parameters)
        - [Arguments](#arguments)
          - [Example: Query String Parameters](#example-query-string-parameters)
      - [Header Fields](#header-fields)
        - [Caching](#caching)
        - [Authentication](#authentication)
      - [Status Codes](#status-codes)
- [REST](#rest)
  - [RESTful API](#restful-api)
  - [Constraints](#constraints)
    - [Client-Server Architecture](#client-server-architecture)
    - [Statelessness](#statelessness)
    - [Uniform Interface](#uniform-interface)
      - [Data](#data)
      - [Resources \& Collections](#resources--collections)
      - [CRUD](#crud)
    - [Cacheability](#cacheability)
    - [Layered System](#layered-system)
    - [Code on Demand](#code-on-demand)

# Definitons

An "Application Programming Interface", or "API", allows use of the application by a user through some interface that is easily understandable and abstracts the inner workings of the application.

## Interface

- Commonly used interfaces make their way into "GUI" which stands for "Graphical User Interface".
- Provide abstractions at many levels.
- Define ways for a user to interact or communicate with an object, whether than be physical or software.
- Interfaces abstract away the implementation.

### Example: Buttons

A programmer might program a "Play" button, which is also an example of a commonly used interface making its way into GUI.

- The programmer may write code to handle the actual event itself, however, the interaction or behavior of the "Play" button is provided by an API and is abstracted from the user.
  - That is, the programmer didn't _need_ to determine a way to do this or implement it themselves (although they could) because it has already been done and serviced to them through an API.
    - As such, "Buttons" are an example of an API.

## API

APIs exist for developers to use and extend in their own applications.

- A contract of sorts that defines how the API is meant to be used as well as what the user can expect in return from it.
- Makes life easier by allowing developers to accomplish desired operations and behaviors while abstracting away their exact implementations.
  - As a user of the application, we don't need to understand _how_ it works, but simply _how_ to use it.
- When designed well, they can allow a programmer to perform a lot of work with a few lines of code.
  - Although, of course, under the hood the actual implementation may be much more complex.
- Frameworks define an API that allow extension of what is provided for the user's own use cases.
  - Simply need to understand how to write an implementation to whatever the framework is expecting.
    - That is, using the API and honoring the "contract" enforced by it.

### Note

> Note: In the current technological climate, the term API is almost always used to refer to Web-Based API. However all kinds of APIs exist such as the examples below.

#### Example: Strings

- Different built-in functions within a programming language can be thought of as members of an API.
- Most languages provide some API for dealing with `String` objects such as a `toUpperCase()` function.
  - A programmer could write this themselves using some low-level bit operation, but the programming language abstracts this from a user by providing pre-packaged built-in API functions to call, in this case, a String API.
- These APIs exist because it is a common enough problem that it makes sense to solve it once and provide a simple interface for performing these operations.

#### Example: Operating Systems

- Another example to consider is Operating System APIs.
- These APIs allow for code to run regardless of the operating system running the code.
  - How exactly this is done is abstracted from the programmer, we simply know that when we run our code, it will work.

```python
"""Lists files and directories in the current working directory"""

import os

current_dir = os.getcwd()
for entry in os.listdir(current_dur):
    print(entry)
```

#### Example: Web Browsers

- Code can be written to work on any web browser which is possible as a result of APIs.
  - All web browsers are required to implement and support a certain set of APIs to ensure this.

# Remote API

Exist because oftentimes there is not enough space or computing power on local everyday machines to accomodate all the data that is available or needed. With Remote APIs, the expensive searching and processing is done externally via the cloud on a machine that can actually handle and compute the request.

## Example: Shazam

Uses a remote API to look up the track that is playing via some external source containing a large quantity of song data that obviously cannot be stored on an every single local machine.

- Does all the searching and processing (computing power) externally.

# Web Review

Review of how the web works before continuing REST discussion.

## Client-Server

Given a computer, it has an internet browser which is a web client that is used to connect to a server.

## URL/URI

This can be done by entering an address into the address bar, called a "URL" which stands for "Universal Resource Locator", also known as a "URI" which stands for "Universal Resource Identifier".

## Scheme

URLs have a scheme portion such as "HTTP".

## HTTP

"HTTP" stands for "Hyper Text Transfer Protocol".

### Protocol

- A protocol can be likened to a contract.
  - A bit lower level than an API but is similar in concept.
  - Can be thought of as defining the expectations of how to communicate.

#### Request

- The browser creates an HTTP Request with the URI and some specified HTTP Verb.

##### Example: HTTP Requests

- `GET URL/URI`
- `POST URL/URI`

##### Verb

- One example of an HTTP Verb is `GET` which is used to clarify that this request will _only_ recieve data.
  - That is, it won't be making any changes.

#### Transfer

- The server recieves the request that was transferred from the client, which is the "T" portion of "HTTP".
- The server does the work it needs to in order to satisfy said request.

#### Response

- Once the request is complete, the server generates the resulting webpage and returns a response to the client which is the browser in this example.
  - The browser uses the response to render the new page.

##### Body

- The most important part of the response is the body.
- For a webpage, the body contains "HTML" which stands for "HyperText Markup Language", hence the "HT" portion of "HTTP".

###### HypterText

- HyperText is text that can link to other texts.
- In HTML that can be done using anchor tags:
  - `<a>Anchor Tags<\a>`

#### Stateless

- HTTP as it was orignally designed, is a "Stateless" protocol.
- Every time a link is clicked, a new HTTP request is being made.
  - However, in between the requests, the protocol is complete.
  - Once the request recieves a response, it is done.
- If we want to maintain some "State", the client will need to manage that and send this information with every new request.

#### Request Methods

- There are more HTTP Verbs, also known as request methods, besides `GET`.
- The verb post `POST` is used to explain that some information is being submitted or "post"ed to the server.

#### Query String Parameters

- URLs sometimes have a `?` in them through which the user is able to pass some information, to/about the request by including additional information after it.

##### Arguments

- The information passed by the user are called "arguments".

###### Example: Query String Parameters

- `https://httpbin.org/get?arg1=true&arg2=false`
- `https://youtube.com/watch?v=arg`

#### Header Fields

- Another common way request/response information is passed around.
- Both requests and responses have headers.
- Used to help further communincate what is wanted as well as what is sent back.
  - Some of the popular request headers allow the user to specify information about the content that is expected in return.

##### Caching

- Retrieve a page "if and only if" it has changed since a certain time.
  - This technique is powerful because it enables "Caching".
- No need to retrieve information we already have in local cache.

##### Authentication

- Authentication information can be embedded into requests using a header.
  - Allows a client to remain logged in accross various requests.

#### Status Codes

- Responses contain headers as well, one of the most important ones being the status code.
- Allows user to determine what has occurred on the server side:
  - 1XX
    - Informational Response
  - 2XX
    - Success
  - 3XX
    - Redirection
  - 4XX
    - Client Errors
  - 5XX
    - Server Errors

# REST

**RE**presentation **S**tate **T**ransfer, or REST, is an architectural style/standard that allows users to interact with resources over the web. Became so popular that the term "REST" became ubiquitous with "API".

## RESTful API

When APIs embrace the style and constraints of REST, they are said to be "RESTful".

## Constraints

Guiding architectural constraints required for an API to be considered RESTful.

### Client-Server Architecture

- The job of an API is to connect two pieces of software without limiting their own functionalities.
- The client (makes requests) and the server (returns responses) stay separate and independent.

### Statelessness

- For an API to be stateless, it has to handle calls independently of each other.
- Each API call has to contain the data and commands necessary to complete the desired action.
- State must be managed manually by the user via the client.
  - That is for example, if an authentication key is necessary, this must be manually sent by the user with every API call which introduces a layer of security.
- Statelessness has the advantage that one bad or failed call does not derail subsequent calls.

### Uniform Interface

- Concept:
  - While the client and server can take on many forms, it is important that the API can still facilitate communication regardless.
- Result:
  - RESTful APIs impose a uniform interface that can easily accomodate all connected software.
    - In most cases, that interface is based on HTTP protocols because it is widely used on the internet.

#### Data

- Data is often stored and exchanged through JSON format files because of their versatility.
- Two commonly used formats are JSON and XML although these aren't the only options available:
  - JSON stands for "JavaScript Object Notation"
  - XML stands for "Extensible Markup Language"

#### Resources & Collections

- The term "Resource" refers to the "R" in "URL" and "URI".
- Requests are said to be made regarding some "resource" which is a (intentionally) fairly abstract term meant to represent any "entity" or "object" which are also (intentionally) fairly abstract terms since they can be used to describe anything that is built.
- Everything a user may want to build can be expressed in terms of "Resources" and "Collections".

#### CRUD

| HTTP Verbs | CRUD   |
| ---------: | :----- |
|        GET | Read   |
|       POST | Create |
|      PATCH | Update |
|        PUT | Update |
|     DELETE | Delete |

- Most of what a user may want their application to be able to do can be described by the accronym "CRUD" which stands for:
  - Create
  - Read
  - Update
  - Delete

### Cacheability

- It is not uncommon for a stateless API requests to have large overhead.
  - In some cases this is unavoidable, but for repeated requests that need the same data, caching said information can make a notable difference.
- The client has the option to locally store certain pieces of data for a predetermined period of time.
- Concept:
  - When a request is made for that data, instead of having the server send it again, the client uses the stored version.
- Result:
  - Instead of the client sending several costly requests in a short span of time, it only has to do it once.

### Layered System

- RESTful architecture dictates that its design is structures into layers with a clear hierarchy that operate together.
- Executing a command means that each layer carries out its role and then sends the data to the next.
- Connected layers communicate with each other, but not with every component of the program.
  - This improves the overall security of the API.
- If the scope of the API changes, layers can be added, modified, or taken out without compromising other components of the interface.

### Code on Demand

- This is an optional constraint because it can be a security risk.
- Concept:
  - Allow code of applets to be sent through the API and used for the application.
    - Code from an unknown or shady source can pose security threats.
- Result:
  - This constraint is best left for internal APIs where you have less to fear from hackers and people with bad intentions.
- Drawback:
  - Code may need to be in a particular programming language for the application, which isn't always the case.
- Upside:
  - Can help the client implement their own features on the go, with less work being necessary on the API or server.
    - In essence, it permits the whole system to be much more scalable and agile.
