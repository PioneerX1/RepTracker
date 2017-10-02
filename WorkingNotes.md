Mon, 10/2

- Setup project
- Write Out README & Specs
- Play around with Postman and API calls to confirm data retrieval capabilities
- Write out a Fragment (for Main Activity) that returns a list of Congress Members to display
  (can retrieve all in either Senate or House, or retrieve by State in Senate or House)


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
    - Rep