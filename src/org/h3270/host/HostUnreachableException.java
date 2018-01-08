
package org.h3270.host;


public class HostUnreachableException extends S3270Exception {

    private static final long serialVersionUID = 3815053284627149828L;

    private String host;
    private String reason;

    public HostUnreachableException(final String host, final String reason) {
        super("Host " + host + " cannot be reached: " + reason);
        this.host = host;
        this.reason = reason;
    }

    /**
     * Returns the name of the host that could not be reached.
     */
    public String getHost() {
        return host;
    }

    /**
     * Returns the reason why the host could not be reached, as reported by s3270.
     */
    public String getReason() {
        return reason;
    }

}
