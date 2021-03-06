/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.events.v1;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class SubscriptionUpdater extends Updater<Subscription> {
    private final String pathSid;
    private String description;
    private String sinkSid;

    /**
     * Construct a new SubscriptionUpdater.
     *
     * @param pathSid The sid
     */
    public SubscriptionUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * A human readable description for the Subscription..
     *
     * @param description Subscription description.
     * @return this
     */
    public SubscriptionUpdater setDescription(final String description) {
        this.description = description;
        return this;
    }

    /**
     * The SID of the sink that events selected by this subscription should be sent
     * to. Sink must be active for the subscription to be created..
     *
     * @param sinkSid Sink SID.
     * @return this
     */
    public SubscriptionUpdater setSinkSid(final String sinkSid) {
        this.sinkSid = sinkSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated Subscription
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Subscription update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.EVENTS.toString(),
            "/v1/Subscriptions/" + this.pathSid + ""
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Subscription update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Subscription.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (description != null) {
            request.addPostParam("Description", description);
        }

        if (sinkSid != null) {
            request.addPostParam("SinkSid", sinkSid);
        }
    }
}