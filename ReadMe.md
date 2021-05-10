Assessment

Please use an existing user / loaded in LoadDatabase controller.

*Warning* - sample data structure is not exactly the same as requested. Explanation here below.

Sample data :

{"user":"it@skay.ch",
"begin":"2019-07-01T09:47:46.000+0000",
"end":"2019-07-01T10:47:46.000+0000",
"data":	{
"heartRate":80.0
,
"someOtherMeasure":70.0
,
"anotherMeasure":50.0
}

}

NOTE - data key/value change

The original required data structure was a 'List of objects' with key / value but without unique key integrity.

[{
"heartRate":80
},{
"someOtherMeasure":70
},{
"anotherMeasure":50
}]

However, my understanding was the followings :

A session retrieves a collection of values.
1 key of 1 session has only 1 value (?)

As I cant ask about that understanding issue, 
I took the decision to propose a change to a slighly different interface with a hashMap.
My understanding is that is more sounds aligned with the description.

The resulting implementation describes my understanding of the situation : a Hashmap of key/value stream linked to a Session.



{
"heartRate":80.0
,
"someOtherMeasure":70.0
,
"anotherMeasure":50.0
}
