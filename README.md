# ChildFundCMS

visit: https://childfundcms.herokuapp.com/

Based on the tutorial here: 

https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku

NOTE: to get this working 
1.  Make sure you have a current java version on your local machine:
java -version  --> should be [java version "10.0.2" 2018-07-17] or greater
2.  follow this article to create a system.properties and add java.runtime.version=11
https://devcenter.heroku.com/articles/java-support

then follow steps in the tutorial to build and run. 

## Running Locally

```
mvn spring-boot:run
```

## JSON format

The form collected from Kobotoolbox gets sent to our system via a POST when the form is submitted. An example of the JSON body:

```
{
  "_id": 98796057,
  "_notes": [],
  "group_general/Community_ID": "123123",
  "_tags": [],
  "group_general/Country_Office": "Uganda",
  "group_childInfo/Child_date_of_birth": "2017-02-16",
  "group_general/Community_Name": "Kigali",
  "group_discussed": [
    {
      "group_discussed/Discussion_Subject": "Discussion Topic #1"
    },
    {
      "group_discussed/Discussion_Subject": "Discussion Topic #2"
    }
  ],
  "_xform_id_string": "afFiSH2iFqfS59HKeprcwU",
  "_validation_status": {},
  "meta/instanceID": "uuid:847ae7df-425f-419f-909d-2bb7b94ca515",
  "group_childInfo/Child_Age": "4",
  "end": "2021-06-03T10:29:44.921-03:00",
  "group_interview/Interview_Conducted_With": "child",
  "group_general/Local_Partner_Name": "Partner Name",
  "group_interview/Participated_Activities": "childrens_clubs child_protection",
  "group_health/Danger": "no",
  "start": "2021-06-03T10:26:45.712-03:00",
  "_geolocation": [
    null,
    null
  ],
  "group_ec03d69": [
    {
      "group_ec03d69/Agreed_Action": "Action #1"
    }
  ],
  "group_general/Village": "Village",
  "_status": "submitted_via_web",
  "__version__": "v5aLJ6GTGU2x5W5bb7CTsL",
  "group_childInfo/Visitor_Name": "Volunteer Name",
  "today": "2021-06-02",
  "deviceid": "ee.kobotoolbox.org:WSlwsrAh7nwtMMWn",
  "group_childInfo/Child_Sex": "male",
  "group_childInfo/Child_number": "123456789",
  "group_interview/Benefit_Activities": "activity_relevant_to_life_stage people_or_institutions",
  "_uuid": "847ae7df-425f-419f-909d-2bb7b94ca515",
  "group_general/Country_Office_ID": "54321",
  "group_education/School_Type": "public",
  "group_childInfo/Child_Life_Stage": "lifeStage1",
  "_submitted_by": null,
  "group_childInfo/Child_first_name": "Matt",
  "group_childInfo/Child_Cluster_Family_Group": "FamilyGroup",
  "group_interview/Date_of_immunization": "2020-11-11",
  "formhub/uuid": "6c3302f147cd4df28efb81f0627c2753",
  "group_interview/immunized": "yes",
  "group_interview/Nutrition_Counselling": "yes",
  "group_general/Local_Partner_ID": "12345",
  "group_childInfo/Child_other_name": "Creaser",
  "group_interview/Child_Present_For_Interview": "yes",
  "_attachments": [],
  "group_education/Child_In_School": "yes",
  "group_education/School_Grade": "pre_kindergarten",
  "_submission_time": "2021-06-03T13:29:55",
  "group_health/Healthy": "yes"
}
```

Note that unanswered questions are omitted from the JSON.

To test particular questions, open https://beeceptor.com/console/kobo-test and then submit the form from https://ee.kobotoolbox.org/x/EkaFH9Ts.
