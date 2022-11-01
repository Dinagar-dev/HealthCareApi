# HealthCareApi

This Api has the following services: 
* User Registration & user login,
* Patient Registration,
* Appointment Scheduling

URL:localhost:6600/{endpoint}

port can be changed by changing "server.port" value in application.properties file

| Method |         Endpoint          | Request             | Response                                   |
|--------|:-------------------------:|---------------------|--------------------------------------------|
| Post   |       /registration       | user details        | success/ failure message                   |
| Post   |          /signin          | user credentials    | id and jwt token                           |
| Get    |    /view/profile/{id}     | user id             | user details                               |
| Put    |    /edit/profile/{id}     | user id             | success/failure message                    |
| Post   |     /register/patient     | patient details     | success/failure message                    |
| Get    |      /patients/list       | -                   | list of patient details                    |
| Get    |    /patients/view/{id}    | patient id          | patient details                            |
| Get    |   /patients/view/{name}   | patient name        | patient details                            |
| Get    |         /disease          | -                   | list of disease                            |
| Post   |   /appointment/register   | appointment details | success/failure message                    |
| Get    |  /appointment/list/{pId}  | patient id          | list of appointments scheduled by patient  |
| Get    |     /appointment/list     | -                   | list of all the appointments present in DB |
| Delete | /appointment/delete/{aId} | appointment id      | success/failure message                    |

Security Configurations:
* Jwt based authentication is used with help of OAuth2 api


as of now only successive cases are being handled, negative cases will be handled in future


