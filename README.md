# holiday-requests-app
Application for the management of leave requests

## Dockerfile
Describes how a image is to be build. You base of an image, copy, build and start applications.

## Docker Compose
the docker compose file will orchestrate multiple images. E.g. if you want to start a database module, and multiple other modules you would have to do this manually for each.

With docker compose, you can glue them all together.

Or, to do a multi stage you can take a jdk/maven image, build your file, then put in a jre image to run it.

Docker compose will read either images, or Dockerfiles for the build.

Commands:
docker-compose -d --remove-orphans --build

- -d will run detached, so you can close the terminal
- --remove-orphans will remove images left over by previous builds
- --build, will also build the images, otherwise don't wonder if you don't see changes when you redeploy


