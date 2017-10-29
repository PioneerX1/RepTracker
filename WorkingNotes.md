Sat, 10/28

TO-DO:
- implement alternative resource for landscape orientation
- style this up much better (use House and Senate drawable logos instead of buttons, ditch the Votes recycler view, etc.)

Firebase bug FIXED!! Added .child in FirebaseRepViewHolder's onClick method to focus on just that user's reps.

---
Mon, 10/9

Firebase Bug: Look at Restaurants Constants file, might need a reference to the user or Rep node?

---
Fri, 10/6

Next Steps:
- Continue building the Login functionality with Firebase. Create Account, Display Name, and Log Out complete, next step "Logging In"
- Link up Saved Reps with individual User Accounts
- Animation for when API loads (similar to Create Account animation) **This might need to go into ProPublicaService (not SearchCongressActivity)

---
Thurs, 10/5

Next Steps: Firebase initial setup complete, link it up to save and retrieve data

---
Wed, 10/4 (cont'd)
NEXT STEPS:

    - Pursue SavedReps Activity (break code from SearchCongressActivity into RepListFragment??)
- Look into Bill numbers stopping, looks like "no value for nomination" (similar JSON error as with reps)
  ** This may be limited to only the 20 most recent votes (Eric Hardigan was 10/4)
- Figure out why I am pulling less data from API per object (15 items vs 100)
  ** might be an extra parameter like "limit=500" needed
    SOLUTION: The 16th representative in House doesn't even have a field for missed_votes_pct


---
Wed, 10/4

NEXT STEPS:

- Adjust Rep model to hold phone, email, website, # missed votes, next election, missed votes %, votes with party %, total votes (no bills sponsored stats tho)
  **This can actually come from the API list Call, Yeah!!

- Create API call to populate RepDetail portion for voting stats

- NEED VOTE_LIST_ITEM XML LAYOUT
- NEED GET VOTES method called within RepDetailFragment to call the FindVotes() method within ProPublicaService


---
Tues, 10/3

NEXT STEPS:
- Link up Rep ArrayList from API call to RecyclerView Adapter to display on screen
- Break out a RepListFragment from SearchCongressActivity  XXX

- RepDetailActivity & Fragment (will need new API call from all the votes by rep)

- API info on votes needed:
 - member_id (to call the API)
 - results -> votes -> question (concat this with "description" so it is something "on passage of make america secure appropriations act")
 - results -> votes -> description
 - results -> votes -> position (yes, no, absent?)
 - results -> votes -> date (when they voted)
 - results -> votes -> bill -> bill_id (so people can google this if needed for more research)


** If possible might be good to do 2 API calls for RepDetail
1. Get Specific Member bio (stats like contact info, # bills sponsored, # bills co-sponsored, title, party, % votes with party, # missed votes)
2. Get Voting History on Specific bills

---
Mon, 10/2

- Setup project
- Write Out README & Specs
- Play around with Postman and API calls to confirm data retrieval capabilities
- Write out a Fragment (for Main Activity) that returns a list of Congress Members to display
  (can retrieve all in either Senate or House, or retrieve by State in Senate or House)

POSSIBLE INITIAL WORKFLOW:
- Main (search Congress or View Saved Reps List - 2 buttons)
- SearchCongressActivity spits up a huge ArrayList after 2 API calls for House and Senate (same ArrayList though)
- A filter field allows user to narrow down list by name or state

INITIAL WORKFLOW (prior to Saved Rep List):
- Main (search by Senate or House)
- House Search (List All Reps and Button to Search by State)
- House State Search
- Senate Search (List All Reps and Button to Search by State)
- Senate State Search


- Potential APIs:
 - ProPublica - https://www.propublica.org/datastore/api
    KEY: xzqwp0Af8w6THZ9mlEzTkNqIcd4R6Ryrkr8jl9Xy  (in Postman: put this in Header as "X-API-Key", not in Params!)
 - Google - https://developers.google.com/civic-information/
 - GovTrack - https://www.govtrack.us/developers/api

----
RepTracker
    —

    User Stories:

    User must be able to see a list of current reps by state OR
    User must be able to search for a rep by name or state.
    User must be able to select a current rep, and see a list of their votes for each bill.
    User must be able to flag (or save) a rep so they can have quick access to their voting record.
    Each vote on the list should open a detail page with expanded info on summary of bill, date, further details and how rep voted.
    Detail page for each rep??


    Android Files Needed:

    Activities:
    - Login
    - Create Account
    - Main (Search for reps)
    - Saved Reps List
    - Bill Detail
    - Rep Detail (shows list of votes)

    Fragments:
    - Rep List Fragment (used in both Find Rep and Saved Reps when listed)
    - Bill Detail Fragment
    - Rep Detail Fragment (used in both Find Rep and Saved Reps once tapped)

    Services:
    - Vote API

    Adapters:
    - Rep List Adapter
    - Rep Pager Adapter
    - Firebase Rep View Holder?
    - Firebase Rep List Adapter?


    Models:
    - Vote
    - Bill ?
    - Rep (name, congressId, state, chamber)
