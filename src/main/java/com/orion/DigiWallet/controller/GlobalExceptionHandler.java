package com.orion.DigiWallet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
}

/*
==========================================================
WHY DO WE NEED A GLOBAL EXCEPTION HANDLER?
==========================================================

In a Spring Boot application, exceptions can occur at
any layer:
- Controller layer
- Service layer
- Repository layer

By default:
----------------------------------------------------------
If an exception (e.g. RuntimeException) is thrown and NOT
handled explicitly, Spring will:
- Wrap it inside a ServletException
- Abort request processing
- Return an unclear or framework-level error

This causes:
----------------------------------------------------------
 Controllers to become cluttered with try-catch blocks
 Inconsistent HTTP status codes
 Poor API error responses
 Tests to fail unpredictably
 Frontend to receive unclear error messages

==========================================================
WHAT IS @ControllerAdvice?
==========================================================

@ControllerAdvice is a Spring feature that allows us to:
 Handle exceptions in ONE CENTRAL PLACE
 Keep controller code clean and focused
 Convert Java exceptions into proper HTTP responses
 Enforce consistent error handling across the application

Think of it as:
----------------------------------------------------------
"A global safety net for all REST APIs"

==========================================================
WHY IS THIS INDUSTRY STANDARD?
==========================================================

In real-world enterprise applications:
----------------------------------------------------------
- Controllers should ONLY handle request/response logic
- Business rules live in the service layer
- Exception handling is centralized
- APIs must return predictable HTTP status codes

This pattern is followed by:
----------------------------------------------------------
✔ Banking systems
✔ Payment gateways
✔ E-commerce platforms
✔ Microservices architectures

==========================================================
HOW DOES THIS HELP TESTING?
==========================================================

Without @ControllerAdvice:
----------------------------------------------------------
- RuntimeException causes ServletException
- MockMvc tests fail before asserting HTTP status

With @ControllerAdvice:
----------------------------------------------------------
 Exceptions are translated into HTTP responses
 Tests can validate status codes cleanly
 API behavior becomes deterministic

==========================================================
DESIGN PRINCIPLE FOLLOWED
==========================================================

"Separation of Concerns"

Each layer has ONE responsibility:
----------------------------------------------------------
Controller  -> Handle HTTP requests
Service     -> Handle business logic
Repository  -> Handle database access
Advice      -> Handle exceptions

==========================================================
IMPORTANT NOTE FOR STUDENTS
==========================================================

Never write try-catch blocks inside controllers
for business exceptions.

ALWAYS:
----------------------------------------------------------
 Throw exceptions from service layer
 Handle them using @ControllerAdvice
 Return meaningful HTTP responses

This is a professional-grade approach.
==========================================================
*/