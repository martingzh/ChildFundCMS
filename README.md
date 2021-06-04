# ChildFundCMS

visit: https://childfundcms.herokuapp.com/

Based on the tutorial here: 

https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku

NOTE: to get this working 
1.  Make sure you have a current java version on your local machine:
java -version  --> should be [java version "10.0.2" 2018-07-17] or greater
2.  follow this article to create a system.properties and add java.runtime.version=11
https://devcenter.heroku.com/articles/java-support
3.  Adjust the the JDBC url you use to run locally, replace the system env by running 
 ```
 export DATABASE_URL=postgres://twvcxtnjmotzym:d62b0f301908da0f8f4797643a35403b63d9d42d6820a8aaec7c7c57ba9f3cc2@ec2-54-211-176-156.compute-1.amazonaws.com:5432/d63otge472kq68 
  ```

then follow steps in the tutorial to build and run. 

## Running Locally

```
mvn spring-boot:run
```

## Helpful Links

- [Spring Boot](https://spring.io/projects/spring-boot#overview) For web framework
- [Thymeleaf](https://www.thymeleaf.org/documentation.html) For HTML Templating
- [BootStrap](https://getbootstrap.com/docs/5.0) For client-side UI

## JSON format

The form collected from Kobotoolbox gets sent to our system via a POST when the form is submitted. An example of the JSON body:

```
{
  "_id": 99009124,
  "_notes": [],
  "group_childInfo/Child_Photo": "indy_bitmoji-14_0_59.jpeg",
  "group_general/Community_ID": "123567",
  "_tags": [],
  "group_general/Country_Office": "Uganda",
  "group_interview/Child_Present_For_Interview": "yes",
  "group_general/Community_Name": "Kigali",
  "_xform_id_string": "afFiSH2iFqfS59HKeprcwU",
  "meta/instanceID": "uuid:4b3622c9-e8f5-4776-8766-c80453b073ab",
  "group_childInfo/Child_Age": "4",
  "end": "2021-06-04T14:02:34.060-03:00",
  "group_interview/Interview_Conducted_With": "child",
  "group_general/Local_Partner_Name": "Partner Name",
  "group_childInfo/Child_number": "555544444",
  "group_health/Danger": "no",
  "start": "2021-06-04T13:59:18.882-03:00",
  "_geolocation": [
    null,
    null
  ],
  "_validation_status": {},
  "group_general/Village": "Village Name",
  "group_health/Health_Issue": "Chest congestion",
  "__version__": "vEUH3uxr3kuvQW3vS2xYuD",
  "group_childInfo/Visitor_Name": "Matt Creaser",
  "today": "2021-06-03",
  "deviceid": "ee.kobotoolbox.org:WSlwsrAh7nwtMMWn",
  "group_childInfo/Child_Sex": "male",
  "group_interview/Participated_Activities": "parenting_workshops childrens_clubs youth_clubs school_governance",
  "group_interview/Benefit_Activities": "activity_positive_change actvivity_physical_environment activity_service_access",
  "_uuid": "4b3622c9-e8f5-4776-8766-c80453b073ab",
  "group_general/Country_Office_ID": "123543",
  "group_education/School_Type": "private",
  "group_childInfo/Child_Life_Stage": "lifeStage2",
  "_submitted_by": null,
  "group_childInfo/Child_first_name": "Indiana",
  "group_childInfo/Child_Cluster_Family_Group": "Family Group",
  "group_health/Health_Issue_Remediation": "Recommended antibiotic delivery",
  "_status": "submitted_via_web",
  "formhub/uuid": "6c3302f147cd4df28efb81f0627c2753",
  "_submission_time": "2021-06-04T17:02:44",
  "group_general/Local_Partner_ID": "43251",
  "group_childInfo/Child_other_name": "Jones",
  "group_childInfo/Child_date_of_birth": "2011-07-20",
  "_attachments": [
    {
      "mimetype": "image/jpeg",
      "download_small_url": "https://kc.kobotoolbox.org/media/small?media_file=victoryee%2Fattachments%2F6c3302f147cd4df28efb81f0627c2753%2F4b3622c9-e8f5-4776-8766-c80453b073ab%2Findy_bitmoji-14_0_59.jpeg",
      "download_large_url": "https://kc.kobotoolbox.org/media/large?media_file=victoryee%2Fattachments%2F6c3302f147cd4df28efb81f0627c2753%2F4b3622c9-e8f5-4776-8766-c80453b073ab%2Findy_bitmoji-14_0_59.jpeg",
      "download_url": "https://kc.kobotoolbox.org/media/original?media_file=victoryee%2Fattachments%2F6c3302f147cd4df28efb81f0627c2753%2F4b3622c9-e8f5-4776-8766-c80453b073ab%2Findy_bitmoji-14_0_59.jpeg",
      "filename": "victoryee/attachments/6c3302f147cd4df28efb81f0627c2753/4b3622c9-e8f5-4776-8766-c80453b073ab/indy_bitmoji-14_0_59.jpeg",
      "instance": 99009124,
      "download_medium_url": "https://kc.kobotoolbox.org/media/medium?media_file=victoryee%2Fattachments%2F6c3302f147cd4df28efb81f0627c2753%2F4b3622c9-e8f5-4776-8766-c80453b073ab%2Findy_bitmoji-14_0_59.jpeg",
      "id": 36318182,
      "xform": 655694
    }
  ],
  "group_education/Child_In_School": "yes",
  "group_education/School_Grade": "6",
  "group_health/Healthy": "no"
}
```

Note that unanswered questions are omitted from the JSON.

To test particular questions, open https://beeceptor.com/console/kobo-test and then submit the form from https://ee.kobotoolbox.org/x/EkaFH9Ts.
