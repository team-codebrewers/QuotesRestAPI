# QuotesRestAPI

This is an project consisting of a Quotes REST API

server at http://localhost:8000/

## Get a random quote from API
    /api/quotes
    param : count (default = 1)


## Search a keyword
    /api/quotes/search?query={keyword}
    param : count (default <= 10);
            query (keyword you are searching for)

## Get quotes from specific author
    /api/quotes/author/{author}
    param : count (default <= 10)
            pathvariable (author name)

## Get quotes with specific tag/tags
    /api/quotes/tags?tag={value1},{value2},{value3}
    param : count (default <= 10)
            tag or list of tags.


Note  : Maximum of 30 quotes will be sent