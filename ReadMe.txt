Model Classes:
The model class act like a schema in the program. These are the classes where the setters and getters are defined for respective models.
Apps.java
Jobs.java
Users.java
User_History.java
Are the models used here and these act like a data structures helping to form a structure for using them.

We have the 4 tsv files each corresponding to a model class as above. The data used is given from a real career website.

Algorithm:
1.	Read the input files Jobs, Users in memory. 
2.	Create threads to handle two jobs separately.
Solution 1:(Visualise top jobs grouped by state for all the countries)
1.	In the thread 1, Read Apps file
2.	For each record in Appss file, set each object for a custom datastructure object(JobId, state and count) and add them to a Hashset.
3.	Along with (2), simultaneously get state for each Userid from Users file and set to the above mentioned userdefined structure.
4.	As HashSet does not allow duplicates, whenever a new duplicate occur, Override the equals method such that the count for the record is incremented for the already existing record of the instance whenever both the jobID and state are equal. (GroupBy jobId and state).
5.	Cast the HashSet to a TreeSet with a custom defined Comparator.
6.	Display the first five records in the mentioned format.
Solution 2: (Visualise top jobs listed per country based on jobtitles)
1.	In the thread 2. Repeat similar steps for populating a Hashset object similar to solution1 but with schema {jobid, country, jobtitle, count}
2.	Get the country for the user instead of state.{Roll up to country}
3.	In a similar Hashset do a similar counter increment whenever TitleId and country are equal. {Slice by  given country}
4.	Cast hashset to treeset to sort them on basis of jobTitle ID and country
5.	For each jobId get the job description and display the top 5 of the hashset.
