package ru.gosuslugi.dom.signature.demo.exceptions;

/**
 * Исключение - ошибка при проверке подписи.
 */
public class SignatureVerificationException extends Exception {
    public SignatureVerificationException(String message) {
        super(message);
    }

    public SignatureVerificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
