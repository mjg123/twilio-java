/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.studio.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Flow extends Resource {
    private static final long serialVersionUID = 111627712697750L;

    public enum Status {
        DRAFT("draft"),
        PUBLISHED("published");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    /**
     * Create a FlowReader to execute read.
     * 
     * @return FlowReader capable of executing the read
     */
    public static FlowReader reader() {
        return new FlowReader();
    }

    /**
     * Create a FlowFetcher to execute fetch.
     * 
     * @param pathSid A string that uniquely identifies this Flow.
     * @return FlowFetcher capable of executing the fetch
     */
    public static FlowFetcher fetcher(final String pathSid) {
        return new FlowFetcher(pathSid);
    }

    /**
     * Create a FlowDeleter to execute delete.
     * 
     * @param pathSid A string that uniquely identifies this Flow.
     * @return FlowDeleter capable of executing the delete
     */
    public static FlowDeleter deleter(final String pathSid) {
        return new FlowDeleter(pathSid);
    }

    /**
     * Converts a JSON String into a Flow object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Flow object represented by the provided JSON
     */
    public static Flow fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Flow.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Flow object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Flow object represented by the provided JSON
     */
    public static Flow fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Flow.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String friendlyName;
    private final Flow.Status status;
    private final Integer version;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Flow(@JsonProperty("sid")
                 final String sid, 
                 @JsonProperty("account_sid")
                 final String accountSid, 
                 @JsonProperty("friendly_name")
                 final String friendlyName, 
                 @JsonProperty("status")
                 final Flow.Status status, 
                 @JsonProperty("version")
                 final Integer version, 
                 @JsonProperty("date_created")
                 final String dateCreated, 
                 @JsonProperty("date_updated")
                 final String dateUpdated, 
                 @JsonProperty("url")
                 final URI url, 
                 @JsonProperty("links")
                 final Map<String, String> links) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.status = status;
        this.version = version;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The A string that uniquely identifies this Flow..
     * 
     * @return A string that uniquely identifies this Flow.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The Account Sid..
     * 
     * @return Account Sid.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The A human readable description of this resource..
     * 
     * @return A human readable description of this resource.
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The Status of this Flow.
     * 
     * @return The Status of this Flow
     */
    public final Flow.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The The latest version number of this Flow's definition..
     * 
     * @return The latest version number of this Flow's definition.
     */
    public final Integer getVersion() {
        return this.version;
    }

    /**
     * Returns The The date this Flow was created.
     * 
     * @return The date this Flow was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date this Flow was updated.
     * 
     * @return The date this Flow was updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The URL of this resource..
     * 
     * @return The URL of this resource.
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The Nested resource URLs..
     * 
     * @return Nested resource URLs.
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Flow other = (Flow) o;

        return Objects.equals(sid, other.sid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(status, other.status) && 
               Objects.equals(version, other.version) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(url, other.url) && 
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            friendlyName,
                            status,
                            version,
                            dateCreated,
                            dateUpdated,
                            url,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("friendlyName", friendlyName)
                          .add("status", status)
                          .add("version", version)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .add("links", links)
                          .toString();
    }
}