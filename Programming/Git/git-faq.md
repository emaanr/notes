# Git

      How to do different things with Git.

# Table of Contents

- [Git](#git)
- [Table of Contents](#table-of-contents)
- [Repositories](#repositories)
  - [Create New Repo via CLI](#create-new-repo-via-cli)
    - [`git init`](#git-init)
    - [`git add .`](#git-add-)
    - [`git commit -m "MESSAGE"`](#git-commit--m-message)
    - [`git branch -M main`](#git-branch--m-main)
    - [`git remote add origin https://github.com/USERNAME/REPO-NAME.git`](#git-remote-add-origin-httpsgithubcomusernamerepo-namegit)
    - [`git push -u origin main`](#git-push--u-origin-main)
  - [Repository Topic](#repository-topic)
    - [`Command 1`](#command-1)
    - [`Command 2`](#command-2)
- [Commits](#commits)
  - [Commit Topic 1](#commit-topic-1)
    - [`Command 1`](#command-1-1)
    - [`Command 2`](#command-2-1)
  - [Commit Topic 2](#commit-topic-2)
    - [`Command 1`](#command-1-2)
    - [`Command 2`](#command-2-2)
- [Branches](#branches)
  - [Branch Topic 1](#branch-topic-1)
    - [`Command 1`](#command-1-3)
    - [`Command 2`](#command-2-3)
  - [Branch Topic 2](#branch-topic-2)
    - [`Command 1`](#command-1-4)
    - [`Command 2`](#command-2-4)
- [Merges](#merges)
  - [Merge Topic 1](#merge-topic-1)
    - [`Command 1`](#command-1-5)
    - [`Command 2`](#command-2-5)
  - [Merge Topic 2](#merge-topic-2)
    - [`Command 1`](#command-1-6)
    - [`Command 2`](#command-2-6)
- [Sources](#sources)
- [Resources](#resources)


# Repositories

    Repository-related inquiries and commands.

- [Create New Repo via CLI](#create-new-repo-via-cli)
- [Repository Topic](#repository-topic)

## Create New Repo via CLI

    How to take any folder, turn it into a git repository, and push to GitHub repo of the same name using Command Line Interface (CLI).

Make sure there is a newly initialized and empty repository with the same name as the folder you wish to push.

1. `git init`
2. `git commit -m "MESSAGE"`
3. `git branch -M main`
4. `git remote add origin https://github.com/USERNAME/REPO-NAME.git`
5. `git push -u origin main`

### `git init`

   - Initialize repository, this creates a `.git` folder in the project's root folder (whose name should be the same as the repo you are trying to push to).

### `git add .`

   - Add all files to be staged for commit.

### `git commit -m "MESSAGE"`

   - Commit staged files with commit message, MESSAGE.

### `git branch -M main`

   - This branch renames the default branch name `master` to `main` via the use of the `-M` flag.
   - I prefer to use `main` over `master`, otherwise this step could be skipped entirely.

### `git remote add origin https://github.com/USERNAME/REPO-NAME.git`

   - To tell the local git repository on your computer which remote repository to send changes to.

### `git push -u origin main`

   - The `-u` flag adds a tracking reference to the upstream server you are pushing to.
   - This means that every next push/pull done from within our local repository will know to send/retrieve information to/from the `main` branch.
   - Recall that if you didn't do `Step 4` then you would instead invoke `git push -u origin master` at this point.

## Repository Topic

    Topic description.

Pre-requisite info.

1.  `Command 1`
2.  `Command 2`

### `Command 1`

- Description

### `Command 2`

- Description

# Commits

    Commit-related inquiries and commands.

- [Commit Topic 1](#commit-topic-1)
- [Commit Topic 2](#commit-topic-2)

## Commit Topic 1

    Topic description.

Pre-requisite info.

1.  `Command 1`
2.  `Command 2`

### `Command 1`

- Description

### `Command 2`

- Description

## Commit Topic 2

    Topic description.

Pre-requisite info.

1.  `Command 1`
2.  `Command 2`

### `Command 1`

- Description

### `Command 2`

- Description

# Branches

    Branch-related inquiries and commands.

- [Branch Topic 1](#branch-topic-1)
- [Branch Topic 2](#branch-topic-2)

## Branch Topic 1

    Topic description.

Pre-requisite info.

1.  `Command 1`
2.  `Command 2`

### `Command 1`

- Description

### `Command 2`

- Description

## Branch Topic 2

    Topic description.

Pre-requisite info.

1.  `Command 1`
2.  `Command 2`

### `Command 1`

- Description

### `Command 2`

- Description

# Merges

    Merge-related inquiries and commands.

- [Merge Topic 1](#merge-topic-1)
- [Merge Topic 2](#merge-topic-2)

## Merge Topic 1

    Topic description.

Pre-requisite info.

1.  `Command 1`
2.  `Command 2`

### `Command 1`

- Description

### `Command 2`

- Description

## Merge Topic 2

    Topic description.

Pre-requisite info.

1.  `Command 1`
2.  `Command 2`

### `Command 1`

- Description

### `Command 2`

- Description

# Sources

- [[1]]() Source 1
- [[2]]() Source 2

# Resources

- [[1]]() Source 1
- [[2]]() Source 2