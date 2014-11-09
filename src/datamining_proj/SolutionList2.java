package datamining_proj;

public class SolutionList2 {
int jobId2;
String country2;
String jobdesc2;
int count2=1;
public int getJobId2() {
	return jobId2;
}
public void setJobId2(int jobId) {
	this.jobId2 = jobId;
}
public String getCountry2() {
	return country2;
}
public void setCountry2(String country) {
	this.country2 = country;
}
public String getJobdesc2() {
	return jobdesc2;
}
public void setJobdesc2(String jobdesc) {
	this.jobdesc2 = jobdesc;
}
public int getCount2() {
	return count2;
}
public void setCount2(int count) {
	this.count2 = count;
}

@Override
public boolean equals(Object o) {
	SolutionList2 sollist2=(SolutionList2)o;
	if((this.jobId2==sollist2.getJobId2())&&(this.country2.equals(sollist2.country2)))
	{
		//System.out.println(this.jobid+"  "+sollist1.getJobid()+"true");
		sollist2.count2++;
		return true;
		
	}
	else
	{
	//System.out.println("false");
		return false;
	}
}
@Override
public int hashCode() {
int hash = 31;
return hash+this.jobId2;
}
}
