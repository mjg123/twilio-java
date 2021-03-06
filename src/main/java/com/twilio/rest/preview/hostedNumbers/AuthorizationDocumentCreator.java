/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.hostedNumbers;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.List;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class AuthorizationDocumentCreator extends Creator<AuthorizationDocument> {
    private final List<String> hostedNumberOrderSids;
    private final String addressSid;
    private final String email;
    private final String contactTitle;
    private final String contactPhoneNumber;
    private List<String> ccEmails;

    /**
     * Construct a new AuthorizationDocumentCreator.
     *
     * @param hostedNumberOrderSids A list of HostedNumberOrder sids.
     * @param addressSid Address sid.
     * @param email Email.
     * @param contactTitle Title of signee of this Authorization Document.
     * @param contactPhoneNumber Authorization Document's signee's phone number.
     */
    public AuthorizationDocumentCreator(final List<String> hostedNumberOrderSids,
                                        final String addressSid,
                                        final String email,
                                        final String contactTitle,
                                        final String contactPhoneNumber) {
        this.hostedNumberOrderSids = hostedNumberOrderSids;
        this.addressSid = addressSid;
        this.email = email;
        this.contactTitle = contactTitle;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    /**
     * Email recipients who will be informed when an Authorization Document has been
     * sent and signed..
     *
     * @param ccEmails A list of emails.
     * @return this
     */
    public AuthorizationDocumentCreator setCcEmails(final List<String> ccEmails) {
        this.ccEmails = ccEmails;
        return this;
    }

    /**
     * Email recipients who will be informed when an Authorization Document has been
     * sent and signed..
     *
     * @param ccEmails A list of emails.
     * @return this
     */
    public AuthorizationDocumentCreator setCcEmails(final String ccEmails) {
        return setCcEmails(Promoter.listOfOne(ccEmails));
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created AuthorizationDocument
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public AuthorizationDocument create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            "/HostedNumbers/AuthorizationDocuments"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("AuthorizationDocument creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return AuthorizationDocument.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (hostedNumberOrderSids != null) {
            for (String prop : hostedNumberOrderSids) {
                request.addPostParam("HostedNumberOrderSids", prop);
            }
        }

        if (addressSid != null) {
            request.addPostParam("AddressSid", addressSid);
        }

        if (email != null) {
            request.addPostParam("Email", email);
        }

        if (contactTitle != null) {
            request.addPostParam("ContactTitle", contactTitle);
        }

        if (contactPhoneNumber != null) {
            request.addPostParam("ContactPhoneNumber", contactPhoneNumber);
        }

        if (ccEmails != null) {
            for (String prop : ccEmails) {
                request.addPostParam("CcEmails", prop);
            }
        }
    }
}