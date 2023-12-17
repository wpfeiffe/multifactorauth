/**
 * National Park Service
 * <p>This API is designed to provide authoritative National Park Service (NPS) data and content about parks and their facilities, events, news, alerts, and more. Explore the NPS API below and even try to make API calls. In order to try an API call, you'll need to click on the \"Authorize\" button below and add your API key. If you don't have an API key yet, visit our <a href=\"https://www.nps.gov/subjects/developer/get-started.htm\">Get Started page</a>.</p>
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.wspfeiffer.mfaserver.dto.nps.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * ActivityData
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2023-11-26T07:44:36.946-05:00")
public class ActivityData   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  public ActivityData id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier for an activity record
   * @return id
  **/
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ActivityData name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the activity
   * @return name
  **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivityData activityData = (ActivityData) o;
    return Objects.equals(this.id, activityData.id) &&
        Objects.equals(this.name, activityData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivityData {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

