package de.monitoring.errorhandling;

import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandlerConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerConfiguration.class);

    private static final String EXCEPTION_NAME = "monitoring.demo.requests.exceptions";

    @Autowired
    private MeterRegistry meterRegistry;

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return handle(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return handle(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleRemainingExceptions(Exception ex) throws Exception {
        logException(ex);
        incrementExceptionMetrics(ex);
        throw ex;
    }

    private ResponseEntity<String> handle(Throwable ex, HttpStatus status) {
        return handle(ex, status, ex.getMessage());
    }

    private ResponseEntity<String> handle(Throwable ex, HttpStatus status, String responseMessage) {
        logException(ex);
        logInfo(
                "Handling Exception with message='{}' with HttpStatus={} and message={}",
                ex.getMessage(), status.value(), responseMessage
        );
        incrementExceptionMetrics(ex);
        return new ResponseEntity<>(responseMessage, status);
    }

    protected void logInfo(String format, Object... arguments) {
        LOGGER.info(format, arguments);
    }

    protected void logException(Throwable ex) {
        LOGGER.trace(ex.getMessage(), ex);
    }

    protected void incrementExceptionMetrics(Throwable ex) {
        meterRegistry.counter(
                EXCEPTION_NAME,
                "exception", ex.getClass().getSimpleName(),
                "username", getUsername()
        ).increment();
    }

    private String getUsername() {
        return "unknown";
    }


}
