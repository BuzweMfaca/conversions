### Running the application

Create the image of the application by executing the following command:

```bash
  mvn clean install
```

Create docker image:

```bash
  docker build -t ayo/conversion .  
```

Run docker:

```bash
  docker run -p 8080:8080 ayo/conversion 
```
