# GoToBusProject
GoTo Bus is a company for operating bus trips in Egypt, They have several trips per day all over Egypt.
They have one station in every Governorate so they need to reduce labor and human error by
digitalizing the way they operate. So they decided to request from your team to start developing a
BackEnd system that provides several Web Services that satisfies their business needs.
## System Functionalities
- System should provide user management subsystem for New User Registration and Login
- User can have two different roles Client and Administrator roles
- System provides a Station entity which describes the name of the station and its map
coordinates
- System provides a trip entity which describes the from and to stations, datetime of the trip and
number of seats
- Trip Entity Management is done by the Admin role only
- Users and Non-Users can search for trips using from and to stations and from and to dates
showing the trip details including number of seats available
- Logged in Users can book a trip if available seats exists
- User should get a notification asynchronously when the booking is done successfully
- Entities of the system: User, Station, Trip, Notification

## System Architecture
![This is an image](https://rha.ole.redhat.com/rha/static/static_file_cache/ad183-7.0/chapter_01/web-service-architecture.png)

## APIs Reference

### 1. Create User
**URL:** /api/user<br>
**Method:** POST<br>
**Parameters:** None<br>
**Request Body:**
```json
{
  "username":"mohamed",
  "password":"test123",
  "full_name":"Mohamed Ahmedl",
  "role": "client"
}
```
**Response:**<br>
- Status: 200 OK


### 2. Login
**URL:** /api/login<br>
**Method:** POST<br>
**Parameters:** None<br>
**Request Body:**
```json
{
  "username":"mohamed",
  "password":"test123"
}
```
**Response:**<br>
- Status: 200 OK (If correct)
- Status: 400 (If not correct)

### 3. Create Station
**URL:** /api/station<br>
**Method:** POST<br>
**Parameters:** None<br>
**Request Body:**
```json
{
  "name":"Aswan",
  "longitude":"23.5184815151",
  "latitude":"21.51548481515"
}
```
**Response:**<br>
- Status: 200 OK (If correct)
- Status: 500 (If exception happened)

### 4. Get Station
**URL:** /api/station/{id}<br>
**Method:** GET<br>
**Parameters:** Station ID<br>
**Request Body:** NONE<br>
**Response:**<br>
- Status: 200 OK (If correct)
- Status: 500 (If exception happened)
- Body:
```json
{
  "name":"Aswan",
  "longitude":"23.5184815151",
  "latitude":"21.51548481515"
}
```

### 5. Create Trip
**URL:** /api/trip<br>
**Method:** POST<br>
**Parameters:** NONE<br>
**Request Body:**
```json
{
  "from_station":"Cairo",
  "to_station": "Aswan",
  "available_seats": 50,
  "departure_time": "25/05/2022 15:00:00",
  "arrival_time": "25/05/2022 20:00:00"
}
```
**Response:**<br>
- Status: 200 OK (If correct)
- Status: 500 (If exception happened)

### 6. Search Trips
**URL:** /api/searchtrips<br>
**Method:** POST<br>
**Parameters:** NONE<br>
**Request Body:**
```json
{
  "from_date": "25/05/2022",
  "to_date": "28/05/2022",
  "from_station":"<STATION_ID_OF_CAIRO>",
  "to_station": "<STATION_ID_OF_ASWAN>"
}
```
**Response:**<br>
- Status: 200 OK (If correct)
- Status: 500 (If exception happened)
- Body:
```json
[
  {
    "trip_id": "1",
    "from_station": "Cairo",
    "to_station": "Aswan",
    "departure_time": "26/05/2022 15:00:00",
    "arrival_time": "27/05/2022 01:30:00",
    "available_seats": 36
  },
  {
    "trip_id": "2",
    "from_station": "Cairo",
    "to_station": "Aswan",
    "departure_time": "26/05/2022 15:00:00",
    "arrival_time": "27/05/2022 01:30:00",
    "available_seats": 25
  },
  {
    "trip_id": "1",
    "from_station": "Cairo",
    "to_station": "Aswan",
    "departure_time": "26/05/2022 15:00:00",
    "arrival_time": "27/05/2022 01:30:00",
    "available_seats": 35
  }
]
```

### 7. Book a trip
**URL:** /api/booktrip<br>
**Method:** POST<br>
**Parameters:** NONE<br>
**Request Body:**
```json
{
  "trip_id": 2,
  "user_id": 5
}
```
**Response:**<br>
- Status: 200 OK (If correct)
- Status: 500 (If exception happened)

### 8. View User’s Trips
**URL:** /api/viewtrips/{user_id}<br>
**Method:** GET<br>
**Parameters:** User ID<br>
**Request Body:** NONE<br>
**Response:**<br>
- Status: 200 OK (If correct)
- Status: 500 (If exception happened)
- Body:
```json
[
  {
    "trip_id": "1",
    "from_station": "Cairo",
    "to_station": "Aswan",
    "departure_time": "26/05/2022 15:00:00",
    "arrival_time": "27/05/2022 01:30:00",
    "available_seats": 36
  }
]
```

### 9. Show user notifications
**URL:** /api/viewtrips/{user_id}<br>
**Method:** GET<br>
**Parameters:** User ID<br>
**Request Body:** NONE<br>
**Response:**<br>
- Status: 200 OK (If correct)
- Status: 500 (If exception happened)
- Body:
 ```json
[
  {
    "message": "You have booked trip from Cairo to Aswan successfully",
    "notification_datetime": "23/05/2022 12:00:00"
  },
  {
    "message": "Sorry, Trip Cairo to Luxor have no available seats",
    "notification_datetime": "23/05/2022 12:05:00"
  }
]
```
