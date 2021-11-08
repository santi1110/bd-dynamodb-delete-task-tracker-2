`AttributeValue` accepts a `String`, so to pass in an `int`, you have to tell it you're using a `Number`! To do
this, use the method `withN()` and then pass in the value `2016` as a `String`:
`AttributeValue().withN("2016")`
