package datamining_proj;

import java.util.ArrayList;

public class SolutionList1 {
int jobid;
String state;
int count=1;
public int getJobid() {
	return jobid;
}
public void setJobid(int jobid) {
	this.jobid = jobid;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
@Override
public boolean equals(Object o) {
	SolutionList1 sollist1=(SolutionList1)o;
	if((this.jobid==sollist1.getJobid())&&(this.state.equals(sollist1.state)))
	{
		//System.out.println(this.jobid+"  "+sollist1.getJobid()+"true");
		sollist1.count++;
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
return hash+this.jobid;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
}

