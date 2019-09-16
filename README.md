# Project

## Team members:
- Anh Tuan Nguyen ID: 18142335
- Mohit Sriram Tirumala ID: 16292490
- Sai Haneesh Tanneru ID: 16290739

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
