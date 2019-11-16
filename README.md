# Project

## Team members:
- Anh Tuan Nguyen | ID: 18142335 | Email: lndhf@mail.umkc.edu
- Mohit Sriram Tirumala | ID: 16292490 | Email: mtkdd@mail.umkc.edu
- Sai Haneesh Tanneru | ID: 16290739 | Email: htz6p@mail.umkc.edu

## Phase 1

### Requirements

1. Collect Tweets using Twitter’s Streaming APIs
2. Extract all the hashtags
3. Run WordCount on the extracted hashtags

### Implementation

#### Create a Twitter developer account and gather the keys

- consumerKey
- consumerSecret
- accessToken
- accessTokenSecret

#### Collect Tweets

Run CollectData.scala to collect tweets. Tweets will be in json format.

#### Extract HashTags

Run EmamineTweets.scala to extract hashtags and put it into the output file (hashtags.txt).

#### Count the hashtags

Run SparkWorkCount.scala to count the hashtags.

## Phase 2

### Requirements

Execute 14 queries on the collected tweets dataset.

### Queries

1.	Query to get the top 10 sources.
2.	Query to get the most popular Hashtags.
3.	Query to get the most mentioned accounts.
4.	Query to get number of Twitter users created in years.
5.	Query to get number of Twitter users created in months.
6.	Query to get the 10 most used languages.
7.	Query to get the top users with the most friends.
8.	Query to get the top users with the most followers. 
9.	Query to get number of tweets and users collected.
10.	Query to get some tweets which contain the keyword.
11.	Query to get the top countries where tweets came from.
12.	Query to get the verified status of users.
13.	Query to get the protected status of users.
14.	Query to get the top users by Tweets.

### Setup

1. Install and run Apache Zeppelin: https://zeppelin.apache.org/docs/0.8.2/quickstart/install.html
2. Download Tweets.json from Zeppelin Note folder.
3. Import Tweets.json to Zeppelin Notebook.
4. Change the input path and run the note.

