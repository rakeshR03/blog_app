# BLOGGING APP

## Problem Statement
Make a web application for blogging which has built in capabilities to handle various users.
<hr />


## Requirements
  1. CRUD capabilities for USERS 
  2. CRUD capabilities for BLOGS which would be scoped under a USER. i.e. only the user which creates a blog would be able to modify/delete it 
  3. All USERS should be able to view BLOGS which have been posted 
  4. A USER should be able to write a BLOG and post it for everyone to see 
  5. A USER should be able to follow another USER so that their BLOGS have a higher priority on the former USER's feed 
  6. USERS should be able to COMMENT under a BLOG. These comments would be public 
  7. USERS should be able to LIKE / UNLIKE a BLOG 
<hr />

## Basic Flow

### Subject to changes basis of how you want the overall UX to be
 <ul>
  <li>An initial signup/signin form to create a user profile on the application
  <li>A main feed where a user can see cards for various blogs. Blogs from users which the current user has followed would have a higher priority in the feed
  <li>A page which opens on clicking a blog card which contains the complete contents of the blog
  <li>An area to add comments and read other comments about the current blog
  <li>An editor where user can create blogs to be posted
  <li>An editor where user can edit the already posted blogs
  <li>Capability to view another user's profile and follow/unfollow them
 </ul>
<hr />
  
## Expectations from Submission

### Points which will be focussed on during evaluation
<ul>
  <li>The code should be working and demonstrable</li>
  <li>Code should be written in a readable fashion using best practices</li>
  <li>Code should be optimised on various fronts and hardcoding logic should be avoided</li>
  <li>Kindly add a proper readme to your project for easy navigation and installation</li>
  <li>The overall UI should be easy to navigate and have good UX</li>
</ul>
<hr />
  
## Good to haves (Optional Requirements)

### Try to work on these features once all the required features are complete
  1.  Having the capability to add blogs to drafts before posting them
  2.  Having the capability to schedule when a blog would get posted
  3.  Sending notifications to all users who follow a current user when the current user posts a new blog or makes changes to an existing one
  4.  Capability to sort feed via time of posting, topics etc.
  5.  Making UI responsive. 
  6.  Ability to club various blogs together under a bucket (topic) -> create a sequence of blogs
  
## Technical Details

### Entities

#### User
```json
{
  "id": 12,
  "username": "johndoe001",
  "email": "john@mail.com",
  "bio": "I am a software developer",
  "avatar": "https://avatars.dicebear.com/v2/johndoe001.png",
  "createdAt": "2020-01-01T00:00:00.000Z"
}
```
NOTE: password has to be hashed and stored too

#### Article
```json
{
  "id": 124,
  "heading": "My first blog post",
  "slug": "my-first-blog-post",
  "subheading": "This is my first blog post",
  "tags": ["blog", "first"],
  "content": "<p>This is my first blog post</p>",
  "authorId": 12,
  "createdAt": "2020-01-01T00:00:00.000Z"
}
```

#### Comment
```json
{
  "id": 17,
  "title": "My first comment",
  "body": "This is my first comment",
  "articleId": 124,
  "authorId": 42,
  "createdAt": "2020-01-01T00:00:00.000Z"
}
```
#### Join Tables

##### Follows
```json
{
  "id": 133,
  "followerId": 12,
  "followeeId": 42,
  "createdAt": "2020-01-01T00:00:00.000Z"
}
```
##### Likes
```json
{
  "id": 524,
  "likerId": 12,
  "articleId": 124,
  "createdAt": "2020-01-01T00:00:00.000Z"
}
```
### Schema Diagram

![image](https://user-images.githubusercontent.com/1327050/168328390-12badd31-49f9-4a00-a3be-b94f7298e4fc.png)

### API Endpoints

##### users

##### POST /users
create a new user (signup)

##### POST /users/login
login to an existing user

##### GET /users 📄
list all users

available query parameters :
<ul>
<li>?sort=date or ?sort=followers</li>
<li>?username=something filter by username (i.e. username contains something)</li>
<li>?follower=johndoe🔐 users whom johndoe follows</li>
<li>?following=johndoe🔐 find all johndoe followers</li>
</ul>

##### GET /users/{userid} 🔐

get user profile by user id

##### GET /users/@{username} 🔐

get user profile by username

##### PUT /users/@{username}/follow 🔐

follow a user

##### DELETE /users/@{username}/follow 🔐👤
unfollow a user

##### articles

##### POST /articles 🔐
create a new article

##### GET /articles/{article-slug}
get article by slug

##### PATCH /articles/{article-slug} 🔐👤
update article by slug

##### DELETE /articles/{article-slug} 🔐👤
delete article by slug

##### PUT /articles/{article-slug}/like 🔐
like article by slug

##### DELETE /articles/{article-slug}/like 🔐👤
unlike article by slug

##### GET /articles 📄
get all articles

available query parameters:
<ul>
<li>?following=true 🔐 (default: false) get articles of users that you are following</li>
<li>?sort=date (default) or ?sort=likes : sort by date or likes</li>
<li>?tags=startups,tech : filter articles by tags</li>
<li>?author=username : filter articles by author</li>
<li>?title=something : search articles by title (i.e. title includes something)</li>
</ul>

-> Response

##### comments

##### POST /articles/{article-slug}/comments 🔐
create a new comment on a given article

##### GET /articles/{article-slug}/comments 📄
get all comments on a given article

##### DELETE /articles/{article-slug}/comments/{comment-id} 🔐👤
delete a comment on a given article
