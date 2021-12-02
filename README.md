# QuotesRestAPI

This is an project consisting of a Quotes REST API

server at http://localhost:8000/

## Get a random quote from API
    /api/quotes/
    param : count (default = 1)


## Search a keyword
    /api/quotes/search?query={keyword}
    param : count (default <= 50);
            query (keyword you are searching for)

## Get quotes from specific author
    /api/quotes/author/{author}
    param : count (default <= 50)
            pathvariable (author name)

## Get quotes with specific tag
    /api/quotes/tag/{tag}
    param : count (default <= 50)
            tag

## Generate a token (free/paid)
    /user/issue
    param : email
            privilage


### Node  : Add a header parameter named x-api-key
### Note  : Maximum of 50 quotes will be sent