
package org.h3270.host;

public class UnknownHostException extends S3270Exception {

    private static final long serialVersionUID = -4523691701264020588L;

    private String host;

    public UnknownHostException(final String host) {
        super(host + " is unknown");
        this.host = host;
    }

    /**
     * Returns the name of the host that could not be resolved.
     */
    public String getHost() {
        return host;
    }

}
