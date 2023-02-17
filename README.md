# sentry_logging_lib

Sentry lib will send every exceptions and errors to email and sentry dashboard
Can also send message to sentry web service

### To create account in Rollbar:
    go here - https://sentry.io
    create a sample project and enter the service name and select Eastern as the timezone
    after clicking "create", select "Java" as the primary SDK
    it will provide you dns which is needed send logs to sentry 

### usage:

Add the following library dependency in your `build.sbt` file. This will import all the knoldus logging lib in your project.

to send logs we have to use methods below:
```
    sentryLogger.info("info level message")
    sentryLogger.error("error level message")
    sentryLogger.warn("warning level message")
    sentryLogger.debug("debug level message")
    
    s.sentryError("Error message")
```

Also we can set common attributes fingerprint, organization and requestId using methods below. Can use it with any data:
```
    sentryLogger.fingerprint("fingerprint")
    sentryLogger.organization("organization")
    sentryLogger.requestId("requestId")
```