package com.REST.service;

import org.json.JSONObject;
import org.json.JSONArray;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class Tweets {
	
	//	String jsonString = "{https://foyzulhassan.github.io/files/favs.json}";
	
	
	//IN ORDER TO CHANGE JSON FILE COPY AND PASTE THE CONTENTS INTO THE STRING BELOW
	String jsonString = "[{\"created_at\":\"Wed Mar 13 23:01:36 +0000 2013\",\"id\":311975360667459600,\"id_str\":\"311975360667459585\",\"text\":\"Was wondering why @billgates cc'd me on story abt @MSFTResearch cool viral search tool; discovered I'm featured in it http://t.co/g6oSeEIEUr\",\"source\":\"\\u003Ca href=\\\"http://www.tweetdeck.com\\\" rel=\\\"nofollow\\\"\\u003ETweetDeck\\u003C/a\\u003E\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":2384071,\"id_str\":\"2384071\",\"name\":\"Tim O'Reilly\",\"screen_name\":\"timoreilly\",\"location\":\"Sebastopol, CA\",\"description\":\"Founder and CEO, O'Reilly Media. Watching the alpha geeks, sharing their stories, helping the future unfold.\",\"url\":\"http://radar.oreilly.com\",\"entities\":{\"url\":{\"urls\":[{\"url\":\"http://radar.oreilly.com\",\"expanded_url\":null,\"indices\":[0,24]}]},\"description\":{\"urls\":[]}},\"protected\":false,\"followers_count\":1679016,\"friends_count\":1012,\"listed_count\":24464,\"created_at\":\"Tue Mar 27 01:14:05 +0000 2007\",\"favourites_count\":98,\"utc_offset\":-28800,\"time_zone\":\"Pacific Time (US & Canada)\",\"geo_enabled\":true,\"verified\":true,\"statuses_count\":24435,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"9AE4E8\",\"profile_background_image_url\":\"http://a0.twimg.com/profile_background_images/3587880/notes.gif\",\"profile_background_image_url_https\":\"https://si0.twimg.com/profile_background_images/3587880/notes.gif\",\"profile_background_tile\":false,\"profile_image_url\":\"http://a0.twimg.com/profile_images/2823681988/f4f6f2bed8ab4d5a48dea4b9ea85d5f1_normal.jpeg\",\"profile_image_url_https\":\"https://si0.twimg.com/profile_images/2823681988/f4f6f2bed8ab4d5a48dea4b9ea85d5f1_normal.jpeg\",\"profile_link_color\":\"0000FF\",\"profile_sidebar_border_color\":\"87BC44\",\"profile_sidebar_fill_color\":\"E0FF92\",\"profile_text_color\":\"000000\",\"profile_use_background_image\":true,\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":false,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"retweet_count\":19,\"entities\":{\"hashtags\":[],\"urls\":[{\"url\":\"http://t.co/g6oSeEIEUr\",\"expanded_url\":\"http://bit.ly/13TNLbS\",\"display_url\":\"bit.ly/13TNLbS\",\"indices\":[118,140]}],\"user_mentions\":[{\"screen_name\":\"BillGates\",\"name\":\"Bill Gates\",\"id\":50393960,\"id_str\":\"50393960\",\"indices\":[18,28]},{\"screen_name\":\"MSFTResearch\",\"name\":\"Microsoft Research\",\"id\":21457289,\"id_str\":\"21457289\",\"indices\":[50,63]}]},\"favorited\":true,\"retweeted\":false,\"possibly_sensitive\":false,\"lang\":\"en\"},{\"created_at\":\"Wed Mar 13 22:16:59 +0000 2013\",\"id\":311964132205269000,\"id_str\":\"311964132205268992\",\"text\":\"The one page everyone in Hollywood is watching http://t.co/jaX0uQqk4W  This is the film industry's Pebble Watch moment.\",\"source\":\"web\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":2408481,\"id_str\":\"2408481\",\"name\":\"Mark Ury\",\"screen_name\":\"MarkUry\",\"location\":\"\",\"description\":\"I occasionally gesticulate.\\r\\nCEO & cofounder of Storybird.\",\"url\":\"http://markury.com\",\"entities\":{\"url\":{\"urls\":[{\"url\":\"http://markury.com\",\"expanded_url\":null,\"indices\":[0,18]}]},\"description\":{\"urls\":[]}},\"protected\":false,\"followers_count\":419,\"friends_count\":166,\"listed_count\":25,\"created_at\":\"Tue Mar 27 05:22:18 +0000 2007\",\"favourites_count\":3,\"utc_offset\":-18000,\"time_zone\":\"Eastern Time (US & Canada)\",\"geo_enabled\":false,\"verified\":false,\"statuses_count\":2096,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"DBE9ED\",\"profile_background_image_url\":\"http://a0.twimg.com/profile_background_images/623983121/t94uekpvj4f6mmb0y07p.jpeg\",\"profile_background_image_url_https\":\"https://si0.twimg.com/profile_background_images/623983121/t94uekpvj4f6mmb0y07p.jpeg\",\"profile_background_tile\":true,\"profile_image_url\":\"http://a0.twimg.com/profile_images/2485615581/54akwy4hphvt1z78370i_normal.png\",\"profile_image_url_https\":\"https://si0.twimg.com/profile_images/2485615581/54akwy4hphvt1z78370i_normal.png\",\"profile_banner_url\":\"https://si0.twimg.com/profile_banners/2408481/1361249325\",\"profile_link_color\":\"31B4BD\",\"profile_sidebar_border_color\":\"87BC44\",\"profile_sidebar_fill_color\":\"A6D7E7\",\"profile_text_color\":\"000000\",\"profile_use_background_image\":true,\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":false,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"retweet_count\":1,\"entities\":{\"hashtags\":[],\"urls\":[{\"url\":\"http://t.co/jaX0uQqk4W\",\"expanded_url\":\"http://kck.st/Yac69y\",\"display_url\":\"kck.st/Yac69y\",\"indices\":[47,69]}],\"user_mentions\":[]},\"favorited\":true,\"retweeted\":false,\"possibly_sensitive\":false,\"lang\":\"en\"},{\"created_at\":\"Wed Mar 13 13:16:30 +0000 2013\",\"id\":311828115477372900,\"id_str\":\"311828115477372928\",\"text\":\"I reflected on why the #sxsw induction means so much to me and it took &gt;140 chars: http://t.co/rJWz0jKrqf\",\"source\":\"\\u003Ca href=\\\"http://bufferapp.com\\\" rel=\\\"nofollow\\\"\\u003EBuffer\\u003C/a\\u003E\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":633,\"id_str\":\"633\",\"name\":\"danah boyd\",\"screen_name\":\"zephoria\",\"location\":\"New York, NY\",\"description\":\"social media scholar, youth researcher & advocate | Microsoft Research, NYU Media Culture & Communication, Harvard Berkman Center | zephoria@zephoria.org\",\"url\":\"http://www.zephoria.org/thoughts/\",\"entities\":{\"url\":{\"urls\":[{\"url\":\"http://www.zephoria.org/thoughts/\",\"expanded_url\":null,\"indices\":[0,33]}]},\"description\":{\"urls\":[]}},\"protected\":false,\"followers_count\":82249,\"friends_count\":982,\"listed_count\":6612,\"created_at\":\"Thu Jul 13 21:27:23 +0000 2006\",\"favourites_count\":50,\"utc_offset\":-18000,\"time_zone\":\"Eastern Time (US & Canada)\",\"geo_enabled\":false,\"verified\":true,\"statuses_count\":3648,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"1A1B1F\",\"profile_background_image_url\":\"http://a0.twimg.com/images/themes/theme9/bg.gif\",\"profile_background_image_url_https\":\"https://si0.twimg.com/images/themes/theme9/bg.gif\",\"profile_background_tile\":false,\"profile_image_url\":\"http://a0.twimg.com/profile_images/2613209217/7in0v6wan5bq1rjbhdoz_normal.jpeg\",\"profile_image_url_https\":\"https://si0.twimg.com/profile_images/2613209217/7in0v6wan5bq1rjbhdoz_normal.jpeg\",\"profile_link_color\":\"2FC2EF\",\"profile_sidebar_border_color\":\"181A1E\",\"profile_sidebar_fill_color\":\"252429\",\"profile_text_color\":\"666666\",\"profile_use_background_image\":true,\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":false,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"retweet_count\":12,\"entities\":{\"hashtags\":[{\"text\":\"sxsw\",\"indices\":[23,28]}],\"urls\":[{\"url\":\"http://t.co/rJWz0jKrqf\",\"expanded_url\":\"http://bit.ly/Y9oqqB\",\"display_url\":\"bit.ly/Y9oqqB\",\"indices\":[86,108]}],\"user_mentions\":[]},\"favorited\":true,\"retweeted\":false,\"possibly_sensitive\":false,\"lang\":\"en\"},{\"created_at\":\"Tue Mar 12 13:29:12 +0000 2013\",\"id\":311468922962587650,\"id_str\":\"311468922962587651\",\"text\":\"How to Create an Early Stage Pitch Deck\\nhttp://t.co/TdYB5I6xBl\\n(Great advice from @ryanspoon )\",\"source\":\"web\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":14078377,\"id_str\":\"14078377\",\"name\":\"SarahPrevette\",\"screen_name\":\"SarahPrevette\",\"location\":\"Enroute to the next stop\",\"description\":\"Most recently: Founder of Sprouter & BetaKit (acquired by Postmedia Network Inc.)\",\"url\":\"http://t.co/VdQdyIiG\",\"entities\":{\"url\":{\"urls\":[{\"url\":\"http://t.co/VdQdyIiG\",\"expanded_url\":\"http://www.sarahprevette.com\",\"display_url\":\"sarahprevette.com\",\"indices\":[0,20]}]},\"description\":{\"urls\":[]}},\"protected\":false,\"followers_count\":20247,\"friends_count\":119,\"listed_count\":1008,\"created_at\":\"Tue Mar 04 15:53:18 +0000 2008\",\"favourites_count\":12094,\"utc_offset\":-21600,\"time_zone\":\"Central Time (US & Canada)\",\"geo_enabled\":false,\"verified\":false,\"statuses_count\":7137,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"B2DFDA\",\"profile_background_image_url\":\"http://a0.twimg.com/images/themes/theme13/bg.gif\",\"profile_background_image_url_https\":\"https://si0.twimg.com/images/themes/theme13/bg.gif\",\"profile_background_tile\":false,\"profile_image_url\":\"http://a0.twimg.com/profile_images/1782524908/Prevette_Headshot_normal.jpg\",\"profile_image_url_https\":\"https://si0.twimg.com/profile_images/1782524908/Prevette_Headshot_normal.jpg\",\"profile_link_color\":\"93A644\",\"profile_sidebar_border_color\":\"EEEEEE\",\"profile_sidebar_fill_color\":\"FFFFFF\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":false,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"retweet_count\":3,\"entities\":{\"hashtags\":[],\"urls\":[{\"url\":\"http://t.co/TdYB5I6xBl\",\"expanded_url\":\"http://slidesha.re/ApqfPK\",\"display_url\":\"slidesha.re/ApqfPK\",\"indices\":[40,62]}],\"user_mentions\":[{\"screen_name\":\"ryanspoon\",\"name\":\"Ryan Spoon\",\"id\":5568612,\"id_str\":\"5568612\",\"indices\":[82,92]}]},\"favorited\":true,\"retweeted\":false,\"possibly_sensitive\":false,\"lang\":\"en\"},{\"created_at\":\"Tue Mar 12 11:05:00 +0000 2013\",\"id\":311432631726264300,\"id_str\":\"311432631726264320\",\"text\":\"1st gear Empathy, 2nd gear Prototype, 3rd gear Align w/ Reality http://t.co/QxDfp2GLcQ by @Jabaldaia http://t.co/CLcxKevjrY\",\"source\":\"\\u003Ca href=\\\"http://twitter.com/download/iphone\\\" rel=\\\"nofollow\\\"\\u003ETwitter for iPhone\\u003C/a\\u003E\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":15414807,\"id_str\":\"15414807\",\"name\":\"johnmaeda\",\"screen_name\":\"johnmaeda\",\"location\":\"Providence, RI\",\"description\":\"President, Rhode Island School of Design, RISD, College, Museum, USA, 1877, Laws of Simplicity, MIT, Design, Art, Business, Technology, Life\",\"url\":\"http://our.risd.edu\",\"entities\":{\"url\":{\"urls\":[{\"url\":\"http://our.risd.edu\",\"expanded_url\":null,\"indices\":[0,19]}]},\"description\":{\"urls\":[]}},\"protected\":false,\"followers_count\":333651,\"friends_count\":6752,\"listed_count\":6467,\"created_at\":\"Sun Jul 13 13:51:22 +0000 2008\",\"favourites_count\":2159,\"utc_offset\":-18000,\"time_zone\":\"Eastern Time (US & Canada)\",\"geo_enabled\":true,\"verified\":true,\"statuses_count\":3932,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"C0DEED\",\"profile_background_image_url\":\"http://a0.twimg.com/profile_background_images/704764772/1270a41ac6f3114c56aeec892ac3ed26.jpeg\",\"profile_background_image_url_https\":\"https://si0.twimg.com/profile_background_images/704764772/1270a41ac6f3114c56aeec892ac3ed26.jpeg\",\"profile_background_tile\":false,\"profile_image_url\":\"http://a0.twimg.com/profile_images/1088325884/maedaicon2lg_normal.png\",\"profile_image_url_https\":\"https://si0.twimg.com/profile_images/1088325884/maedaicon2lg_normal.png\",\"profile_link_color\":\"0084B4\",\"profile_sidebar_border_color\":\"FFFFFF\",\"profile_sidebar_fill_color\":\"DDEEF6\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":false,\"notifications\":null},\"geo\":{\"type\":\"Point\",\"coordinates\":[41.83086926,-71.40499659]},\"coordinates\":{\"type\":\"Point\",\"coordinates\":[-71.40499659,41.83086926]},\"place\":{\"id\":\"7b93be1d864cedbb\",\"url\":\"https://api.twitter.com/1.1/geo/id/7b93be1d864cedbb.json\",\"place_type\":\"city\",\"name\":\"Providence\",\"full_name\":\"Providence, RI\",\"country_code\":\"US\",\"country\":\"United States\",\"polylines\":[],\"bounding_box\":{\"type\":\"Polygon\",\"coordinates\":[[[-71.472667,41.772414],[-71.369694,41.772414],[-71.369694,41.861571],[-71.472667,41.861571]]]},\"attributes\":{}},\"contributors\":null,\"retweet_count\":26,\"entities\":{\"hashtags\":[],\"urls\":[{\"url\":\"http://t.co/QxDfp2GLcQ\",\"expanded_url\":\"http://risd.cc/10H8XRE\",\"display_url\":\"risd.cc/10H8XRE\",\"indices\":[64,86]}],\"user_mentions\":[{\"screen_name\":\"Jabaldaia\",\"name\":\"Jose Baldaia\",\"id\":19794129,\"id_str\":\"19794129\",\"indices\":[90,100]}],\"media\":[{\"id\":311432631730458600,\"id_str\":\"311432631730458625\",\"indices\":[101,123],\"media_url\":\"http://pbs.twimg.com/media/BFJuVBnCUAEjWy_.jpg\",\"media_url_https\":\"https://pbs.twimg.com/media/BFJuVBnCUAEjWy_.jpg\",\"url\":\"http://t.co/CLcxKevjrY\",\"display_url\":\"pic.twitter.com/CLcxKevjrY\",\"expanded_url\":\"http://twitter.com/johnmaeda/status/311432631726264320/photo/1\",\"type\":\"photo\",\"sizes\":{\"medium\":{\"w\":600,\"h\":450,\"resize\":\"fit\"},\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"small\":{\"w\":340,\"h\":255,\"resize\":\"fit\"},\"large\":{\"w\":960,\"h\":720,\"resize\":\"fit\"}}}]},\"favorited\":true,\"retweeted\":false,\"possibly_sensitive\":false,\"lang\":\"en\"}]";
	
	JSONArray jsonArray = new JSONArray(jsonString);

	
	//STORES INFORMATION THAT IS EXTRACTED FROM TWEET JSON FILE
	private String createTime;
	private long id;
	private String tweetText;
	
	private String userScreenName;
	
	private String location;
	private String description;
	private int followerCount;
	private int friendCount;
	
	//DISPLAYS ALL TWEETS WITH THEIR TIME POSTED, TWEET ID, AND TEXT CONTENT
	@GetMapping(value="/tweets",produces=MediaType.APPLICATION_JSON_VALUE)
	public String getAllTweets() {
		JSONArray tweetsList = new JSONArray(); 	//Create an JSONArray of JSONObjects that will store date, id, and text
		
		for(int i =0; i<jsonArray.length();i++) { 	//Iterate through Tweet JSONFILE
			
			JSONObject tweet = new JSONObject();	//Store each tweet from JSONArray as a JSONObject called "tweet" 
			
			createTime = jsonArray.getJSONObject(i).getString("created_at");
			tweet.put("Create Time",createTime);	//Parse and store date/time
			
			id=jsonArray.getJSONObject(i).getLong("id");
			tweet.put("id",id);						//Parse and store tweet id
			
			tweetText=jsonArray.getJSONObject(i).getString("text");
			tweet.put("Tweet Text",tweetText);		//Parse and store tweet text
			
			tweetsList.put(i,tweet);				//load tweet JSONObject into new "tweetsList" JSONArray
		}
		
		return tweetsList.toString();				//Print tweetsList
	}
	
	//DISPLAYS ALL EXTERNAL LINKS WITHIN TEXT CONTENT FOR EACH TWEET
	@GetMapping(value="/links",produces=MediaType.APPLICATION_JSON_VALUE)
	public String getExternalLinks() {
		JSONArray linkList = new JSONArray();		//Create an JSONArray of JSONObjects that will store links in tweet text content
		
		for(int i =0; i<jsonArray.length();++i) {	//Iterate through Tweet JSONFILE
			
			JSONObject tweet = new JSONObject();
			tweet = jsonArray.getJSONObject(i);		//Isolate each tweet
			JSONObject tweetLinks = new JSONObject();	//Create a new JSONObject to store the links from tweets
;			
			String text = tweet.getString("text");			//Parse text from each tweet
			String regex = "http://t.co/[a-zA-z0-9]{10}";	//Regular Expression representing substrings that start with "http;//t.co/" followed by any 10 values A-Z and 0-9 Upper and Lowercases
			
			Pattern urlPattern = Pattern.compile(regex);
			Matcher matcher = urlPattern.matcher(text);		//Regex Search Setup
			
			int count = 1;
			while (matcher.find()) {
		        System.out.println(matcher.group());
		        tweetLinks.put("From Tweet #"+(i+1)+" Link #"+count+": ", matcher.group());		//Organize Links extracted from Tweet Text
		        count++;
		      }
			linkList.put(tweetLinks);		//Compile all tweetLinks JSONObjects in a JSONArray
		}
		
		return linkList.toString();			//Print linkList
	}
	
	
	//DISPLAYS TWEET WITH ITS TIME POSTED, POSTER'S SCREEN NAME, AND TEXT CONTENT CORRESPONDING TO 'id' INPUT
	@GetMapping(value="/tweets/{id}",produces=MediaType.APPLICATION_JSON_VALUE)		//Enter the user ID you wish to retrieve in the URI after tweets/
	public String getTweetDetails(@PathVariable long id) {
		for(int i =0; i<jsonArray.length();i++) {
			JSONObject tweet = new JSONObject();
			if(jsonArray.getJSONObject(i).getLong("id") == id) {					//Iterate through all tweets in JSON file and compare their tweet IDs with the user input
				createTime = jsonArray.getJSONObject(i).getString("created_at");
				tweet.put("Create Time",createTime);								//Parse and Store date/time
				
				userScreenName = jsonArray.getJSONObject(i).getJSONObject("user").getString("screen_name");
				tweet.put("User Screen Name", userScreenName);						//Parse and store Poster's Username
				
				tweetText=jsonArray.getJSONObject(i).getString("text");
				tweet.put("Tweet Text",tweetText);									//Parse and store text associated with the tweet
				
				return tweet.toString();		//print Json tweet info of tweet with specified id
			}
			
		}
		return "Tweet with id:"+id+" not found!";	//if user id search fails prompt error message
	}
	
	//DISPLAYS USERNAME, LOCATION, DESCRIPTION, FOLLOWER COUNT, AND FRIEND COUNT OF TWITTER USER WITH SPECIFIED USER SCREEN NAME
	@GetMapping(value="/users/{userScreenName}",produces=MediaType.APPLICATION_JSON_VALUE)
	public String getUserDetails(@PathVariable String userScreenName) {
		for(int i =0; i<jsonArray.length();i++) {
			JSONObject user = new JSONObject();		//Store user data in its own JSON Object
			if(jsonArray.getJSONObject(i).getJSONObject("user").getString("screen_name").equals(userScreenName)) {		//Iterate through all tweet's Poster's user screen names and if they match Parse its data
				
				userScreenName = jsonArray.getJSONObject(i).getJSONObject("user").getString("screen_name");
				user.put("User Screen Name", userScreenName);		//Parse and store username
				
				location = jsonArray.getJSONObject(i).getJSONObject("user").getString("location");
				user.put("Location",location);						//Parse and store user location
				
				description = jsonArray.getJSONObject(i).getJSONObject("user").getString("description");
				user.put("Description", description);				//Parse and store user description
				
				followerCount=jsonArray.getJSONObject(i).getJSONObject("user").getInt("followers_count");
				user.put("Follower Count",followerCount);			//Parse and store follower count
				
				friendCount=jsonArray.getJSONObject(i).getJSONObject("user").getInt("friends_count");
				user.put("Friend Count",friendCount);				//Parse and store Friend count
				
				
				System.out.println(user.toString());
				String userString = user.toString();
				return userString;		//Print out all user data
			}
			
		}
		System.out.println("User with Username:"+userScreenName+" not found!");		//If username searcb fails prompt error message
		return "User with Username:"+userScreenName+" not found!";
	}
	
}

