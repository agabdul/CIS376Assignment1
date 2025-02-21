
# Tweet JSON Parser

In this project, through the use of REST API methods, we are able to take the contents of a JSON file containing several of your favorited tweet data and parse through it to access the information that you desire!




## SpringToolSuite Setup
This project was developed in SpringToolSuite and in order to test this program you will need to do so through the IDE itself in order to make use of the features SpringBoot has to offer. 

__**STEP 1**__

Visit https://spring.io/tools

Here you will see several versions of SpringBoot that you can install. If you havent already, install the "Spring Tools for Eclipse" for your operating system.

__**STEP 2**__

Once you have sucessfully installed SpringToolSuite you should now prepare the Tweet JSON Parser. In order to open the project, ensure that the file is extracted and in the top left hand corner of your STS window, you will click on "File"->"Import"->"General"->"Existing Projects into Workspace"->"Next"

From here a new window should open up allowing you to add details about your import. Make sure that the bubble next to "Select Root Directory" is ticked and Select the path to where you have your extracted "CIS376Assignment1" folder.

__**STEP 3**__

Now that you have successfully installed SpringToolSuite and you have imported the "CIS376Assignment1" folder you should see it in your Package Explorer on the left hand side of your screen. Double click it to expose its contents and open the "src/main/java" package followed by the "com.REST.service" package and the "Tweets.java" file. In this file is where all of the code behind the Tweet JSON Parser lies.


## Postman

The next thing that we will need to set up is Postman. Postman gives us an organized view of our REST APIs while they are running and allows you to make several HTTP requests like "GET","POST","PUT","DELETE".

__**STEP 1**__

To start with Postman you will first need to make an account and log in.

__**STEP 2**__

Once you have logged into your account you will need to create a workspace in order to interact with the REST APIs. Select the option to make a blank workspace and hit + to make a new HTTP Request tab.

__**STEP 3**__
In order to connect to a local host, you may be prompted to install a Postman Desktop Agent. Make sure to install and allow to run in the background



## Running the Program w/Postman

__Starting up the Program__

Back in SpringToolSuite we will start the program for the first time. By default, the code is equipt to scan through the sample JSON provided as part of the project instructions. 

__***IMPORTANT:***__ 
If you wish to change the JSON file that the program is reading from you must modify the contents of the string "jsonArray" on line29. Please __COPY AND PASTE__ the new JSON replacing the one that is already there and save.

To start the Spring Boot App, right click on the project folder in the package explorer then hit "Run as Spring Boot App". Give it a couple seconds to start up and head back to postman.

__There are FOUR different REST API Endpoints we can interact with:__
  - GET localhost:8080/tweets
  - GET localhost:8080/tweets/{tweetID}
  - GET localhost:8080/links
  - GET localhost:8080/users/{username} (Case Sensitive)

_/tweets:_ Returns a JSONArray storing all of the tweets with the day and time they were posted, the tweet ID, and text content that was posted.

    -Expected Results:

    [
    {
        "Create Time": "Wed Mar 13 23:01:36 +0000 2013",
        "id": 311975360667459600,
        "Tweet Text": "Was wondering why @billgates cc'd me on story abt @MSFTResearch cool viral search tool; discovered I'm featured in it http://t.co/g6oSeEIEUr"
    },
    {
        "Create Time": "Wed Mar 13 22:16:59 +0000 2013",
        "id": 311964132205269000,
        "Tweet Text": "The one page everyone in Hollywood is watching http://t.co/jaX0uQqk4W  This is the film industry's Pebble Watch moment."
    },
    {
        "Create Time": "Wed Mar 13 13:16:30 +0000 2013",
        "id": 311828115477372900,
        "Tweet Text": "I reflected on why the #sxsw induction means so much to me and it took &gt;140 chars: http://t.co/rJWz0jKrqf"
    },
    {
        "Create Time": "Tue Mar 12 13:29:12 +0000 2013",
        "id": 311468922962587650,
        "Tweet Text": "How to Create an Early Stage Pitch Deck\nhttp://t.co/TdYB5I6xBl\n(Great advice from @ryanspoon )"
    },
    {
        "Create Time": "Tue Mar 12 11:05:00 +0000 2013",
        "id": 311432631726264300,
        "Tweet Text": "1st gear Empathy, 2nd gear Prototype, 3rd gear Align w/ Reality http://t.co/QxDfp2GLcQ by @Jabaldaia http://t.co/CLcxKevjrY"
    }
    ]


_/tweets/{tweetID}:_ Given a tweet ID, returns a JSONObject storing the tweet information for that specific tweet ID such as the day and time it was posted, the poster's username, and the text content that was posted.

    -Expected Results (tweetID= 311432631726264300):

    {
    "Create Time": "Tue Mar 12 11:05:00 +0000 2013",
    "User Screen Name": "johnmaeda",
    "Tweet Text": "1st gear Empathy, 2nd gear Prototype, 3rd gear Align w/ Reality http://t.co/QxDfp2GLcQ by @Jabaldaia http://t.co/CLcxKevjrY"
    }


_/links:_: Returns a JSONArray storing JSONObjects storing the external links that were included in the tweet text bodies.

    -Expected Results:

    [
    {
        "From Tweet #1 Link #1: ": "http://t.co/g6oSeEIEUr"
    },
    {
        "From Tweet #2 Link #1: ": "http://t.co/jaX0uQqk4W"
    },
    {
        "From Tweet #3 Link #1: ": "http://t.co/rJWz0jKrqf"
    },
    {
        "From Tweet #4 Link #1: ": "http://t.co/TdYB5I6xBl"
    },
    {
        "From Tweet #5 Link #2: ": "http://t.co/CLcxKevjrY",
        "From Tweet #5 Link #1: ": "http://t.co/QxDfp2GLcQ"
    }
    ]

_/users/{username}:_ Prompted with a specific username, this endpoint returns information about the user such as their screen name, profile description, follower count, friend count, and location.

    -Expected Results (username = timoreilly)

    {
    "Description": "Founder and CEO, O'Reilly Media. Watching the alpha geeks, sharing their stories, helping the future unfold.",
    "Friend Count": 1012,
    "User Screen Name": "timoreilly",
    "Follower Count": 1679016,
    "Location": "Sebastopol, CA"
    }


__In Postman__
with your Spring Boot App running you can access these endpoints through the use of the HTTP methods listed above by entering them into Postman's URL bar and hitting Send