API contract requirements:

**Requests:
**
* A user will always be referenced by their unique display name, not by a database Id.
* A restaurant will always be referenced by its database Id.
* A dining review will always be referenced by its database Id.
* Any API scenarios that involve creating a new entity or updating an existing one will require the client to send the entity info as part of the request body.
* Restaurant search scenario: To support searching for a restaurant, use query params to represent the zip code and a specific allergy.
* Admin scenario: The APIs specific to the admin scenario should live under a specific “admin” path.

**Validation:
**
* APIs should validate inputs. This may include validating the existence of other entities that may be related to the API operation. For instance, for the dining review scenario, validate that the given restaurant exists.

**Responses:
**
* Any API scenarios that involve returning an entity will return them as a JSON response.
* Return an appropriate HTTP status code for any failures, including cases where the request fails validation.
* When returning an entity as a JSON response, if a value does not exist for a given property, do not send back a null value for that property. Instead, do not send back the property at all. For example, when returning a restaurant entity, if the restaurant does not have a peanut score, then do not include the peanut field as part of the JSON response.
* Restaurant scenario: When returning a restaurant entity with its scores, represent the individual scores to two decimal places, e.g. 4.75.
* Admin approval scenario: Upon approval of a dining review, re-compute the restaurant’s latest scores across all the approved dining reviews for that
