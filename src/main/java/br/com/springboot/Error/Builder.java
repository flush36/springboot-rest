package br.com.springboot.Error;

public class Builder {


    private String title;

    private int status;

    private String detail;

    private Long timestamp;

    private String developermessage;

    private Builder() {
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getDevelopermessage() {
        return developermessage;
    }

    public static final class ResourceNotFoundDetailsBuilder {
        private String title;
        private int status;
        private String detail;
        private Long timestamp;
        private String developermessage;

        private ResourceNotFoundDetailsBuilder() {
        }

        public static ResourceNotFoundDetailsBuilder newBuilder() {
            return new ResourceNotFoundDetailsBuilder();
        }

        public ResourceNotFoundDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ResourceNotFoundDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ResourceNotFoundDetailsBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public ResourceNotFoundDetailsBuilder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ResourceNotFoundDetailsBuilder developermessage(String developermessage) {
            this.developermessage = developermessage;
            return this;
        }

        public Builder build() {
            Builder resourceNotFoundDetails = new Builder();
            resourceNotFoundDetails.title = this.title;
            resourceNotFoundDetails.detail = this.detail;
            resourceNotFoundDetails.developermessage = this.developermessage;
            resourceNotFoundDetails.timestamp = this.timestamp;
            resourceNotFoundDetails.status = this.status;
            return resourceNotFoundDetails;
        }
    }
}
