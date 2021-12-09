package br.com.finances.service.exception;

import lombok.Getter;

@Getter
public class ExceptionDetails {
    private String title;
    private int status;
    private String detail;
    private long timestamp;
    private String developerMessage;

    private ExceptionDetails() {

    }

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ExceptionDetails build() {
            ExceptionDetails exceptionDetails = new ExceptionDetails();
            exceptionDetails.status = this.status;
            exceptionDetails.developerMessage = this.developerMessage;
            exceptionDetails.title = this.title;
            exceptionDetails.detail = this.detail;
            exceptionDetails.timestamp = this.timestamp;
            return exceptionDetails;
        }
    }
}
