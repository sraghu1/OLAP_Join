package datamining_proj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Multithreading_DM {



    public static void main(String[] args) {
        // TODO code application logic here
  //System.out.println(args.length);
  try
  {
  String country=args[0];
  String file_apps=args[1];
  String file_users=args[2];
  String file_jobs=args[3];
  String file_userhistory=args[4];
  BufferedReader br_apps=new BufferedReader(new FileReader(new File(file_apps)));
  BufferedReader br_users=new BufferedReader(new FileReader(new File(file_users)));
  File fin=new File(file_jobs);
  FileInputStream fis = new FileInputStream(fin);
  BufferedReader br_jobs=new BufferedReader(new InputStreamReader(fis),15000);
  BufferedReader br_userhistory=new BufferedReader(new FileReader(new File(file_userhistory)));
  String state;
  Jobs[] jobs=loadJobs(br_jobs);
  Users[] users=loadUsersdata(br_users);
  executeTasks(file_apps,users, jobs, country);
  br_apps=new BufferedReader(new FileReader(new File(file_apps)));
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
 }

	public static Users[] loadUsersdata(BufferedReader br_users) {
		// TODO Auto-generated method stub
		Users users[]=new Users[75000];
		int i=0;
		String sCurrentLine;

		try {
		br_users.readLine();
		while ((sCurrentLine = br_users.readLine()) != null) {
			String line[]=sCurrentLine.split("\t");
			users[i]=new Users();
			users[i].setUserId(Integer.parseInt(line[0]));
			users[i].setCountry(line[3]);
			users[i].setState(line[2]);
		i++;
		}
		br_users.close();
		//System.out.println("loaded users");
	return users;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return users;	
	}
    	
	

	public static Apps[] loadAppsdata(BufferedReader br_apps) {
		// TODO Auto-generated method stub
		Apps apps[]=new Apps[303833];
		int i=0;
		String sCurrentLine;

		try {
			br_apps.readLine();
		while ((sCurrentLine = br_apps.readLine()) != null) {
			String line[]=sCurrentLine.split("\t");
			//System.out.println(i);
			apps[i]=new Apps();
			apps[i].setUserId(Integer.parseInt(line[0]));
			apps[i].setApplicationDate(line[1]);
			apps[i].setJobId(Integer.parseInt(line[2]));
		i++;
		}
		br_apps.close();
		//System.out.println("Loaded Apps");
	return apps;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return apps;	
	}
 public static String getUserState(Users[] user, int userid)
 {
	for(int i=0;i<user.length;i++)
	{
	 if(user[i].getUserId()==userid)
	 {
		return user[i].getState();
	}
	
 }
	return " ";

}
 public static String getUserCountry(Users[] user, int userid)
 {
	for(int i=0;i<user.length;i++)
	{
	 if(user[i].getUserId()==userid)
	 {
		return user[i].getCountry();
	}
	
 }
	return " ";

}
 public static Jobs[] loadJobs(BufferedReader br_jobs)
 {
Jobs[] jobs=new Jobs[300000];	 
int i=0;

try {
br_jobs.readLine();
for(String sCurrentLine; (sCurrentLine= br_jobs.readLine()) != null;) {
	//System.out.println(i);
	String line[]=sCurrentLine.split("\t");
	jobs[i]=new Jobs();
	jobs[i].setJob_Id(Integer.parseInt(line[0]));
	jobs[i].setJobTitle(line[1]);
	i++;
}
//System.out.println("loaded users");
return jobs;
 
 }
catch(Exception e)
{
	e.printStackTrace();
}
return jobs;
 }
 
 public static TreeSet<SolutionList1> execsol1(BufferedReader br_apps,Users[] users)
 {
	 try
	 {
		 Set<SolutionList1> solutionlist1=new HashSet();
	 
	  //System.out.println("Problem 1");
	  int j=0;
		String sCurrentLine;
		String state;
		br_apps.readLine();
		while ((sCurrentLine = br_apps.readLine()) != null) {
			String line[]=sCurrentLine.split("\t");
			//System.out.println(i);
			//apps[i]=new Apps();
			//apps[i].setUserId(Integer.parseInt(line[0]));
			//apps[i].setApplicationDate(line[1]);
			//apps[i].setJobId(Integer.parseInt(line[2]));
			SolutionList1 solutionlist=new SolutionList1();
			solutionlist.setJobid(Integer.parseInt(line[2]));
			state=getUserState(users,Integer.parseInt(line[0]));
			solutionlist.setState(state);
			solutionlist1.add(solutionlist);
			j++;
		}
	  //System.out.print("Loaded sol set");
	  int i=0;
	  /*for(SolutionList1 sol:solutionlist1)
	  {
		  System.out.println(++i+"\t"+sol.getState()+"\t"+sol.getJobid()+"\t"+sol.getCount());
		  //int count=Collections.frequency(solutionlist1, solutionlist1.);
		  
		  //solutionlist1.get(i).setCount(count);
	  }*/
	  TreeSet<SolutionList1> solution1=new TreeSet<SolutionList1>(new MyDataComp());
	  solution1.addAll(solutionlist1);
	  Iterator it=solution1.iterator();
	  int k=0;
	  //System.out.println("StateID\tJobID\tNo of Apps");
	  /*while(it.hasNext()&&k<5)
	  {
		SolutionList1 sol1=(SolutionList1) it.next();  
	  System.out.println("Solution1"+sol1.getState()+"\t"+sol1.getJobid()+"\t"+sol1.getCount());
	  k++;
	  }*/
	  /*for(int i=0;i<solutionlist1.size();i++)
	  {
		  System.out.println(solutionlist1.get(i).getState()+"\t"+solutionlist1.get(i).getJobid()+"\t"+solutionlist1.get(i).getCount());
	  }*/
	  //System.out.println("end");
	 return solution1;
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	return null;
 }
 
	public static void executeTasks(final String file_apps, final Users[] users,final Jobs[] jobs, final String country)
            throws InterruptedException, ExecutionException {
 
 
 
        // Prepare to execute and store the Futures
        int threadNum = 2;
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        List<FutureTask> taskList = new ArrayList<FutureTask>();
        try {
			final BufferedReader br_apps=new BufferedReader(new FileReader(new File(file_apps)));
		// Start thread for the first half of the numbers
        FutureTask futureTask_1 = new FutureTask(new Callable() {
            @Override
            public TreeSet call() {
              TreeSet solu1=  Multithreading_DM.execsol1(br_apps,users);
			Iterator iter=solu1.iterator();
			int k=0;
			System.out.println("Problem 1:");
			  System.out.println("StateID\tJobID\tNo of Apps");
			  while(iter.hasNext()&&k<5)
			  {
				SolutionList1 sol1=(SolutionList1) iter.next();  
			  System.out.println(""+sol1.getState()+"\t"+sol1.getJobid()+"\t"+sol1.getCount());
			  k++;
			  }  
			return null;	 
            }
        });
        taskList.add(futureTask_1);
        executor.execute(futureTask_1);
 
        
        // Start thread for the second half of the numbers
        FutureTask futureTask_2 = new FutureTask(new Callable() {
            @Override
            public TreeSet call() throws FileNotFoundException {
            	final BufferedReader br_apps2=new BufferedReader(new FileReader(new File(file_apps)));
        		 
            	TreeSet solu2=Multithreading_DM.execsol2(br_apps2,users,jobs, country);
            	Iterator it1=solu2.iterator();
            	int m=0;
            	System.out.println("Problem 2");
        		System.out.println("Title ID \t Number of Apps");
        		  while(it1.hasNext()&&m<5)
        		  {
        			
        			  SolutionList2 sol2=(SolutionList2) it1.next();  
        			  System.out.println(sol2.getJobdesc2()+"\t"+sol2.getCount2()+"\t");
        		  m++;
        		  }
        		
            	return null;	 
            }
        });
        taskList.add(futureTask_2);
        executor.execute(futureTask_2);
        /*for(FutureTask fut:taskList)
        {
        	fut.get();
        }*/
        executor.shutdown();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //return amount;
    }

	protected static TreeSet<SolutionList2> execsol2(BufferedReader br_apps, Users[] users, Jobs[] jobs, String country1) {
		// TODO Auto-generated method stub
		try
		 {
			 Set<SolutionList2> solutionlist2=new HashSet();
		 
			 int j=0;
			String sCurrentLine;
			String country;
			br_apps.readLine();
				while ((sCurrentLine = br_apps.readLine()) != null) {
				String line[]=sCurrentLine.split("\t");
				SolutionList2 solutionlist=new SolutionList2();
				solutionlist.setJobId2(Integer.parseInt(line[2]));
				country=getUserCountry(users,Integer.parseInt(line[0]));
				solutionlist.setCountry2(country);
				if(country.equals(country1))
				{
					solutionlist2.add(solutionlist);
				}
				j++;
			}
		  int i=0;
		  //Collections.sort(solutionlist2, new MyDataComp1());
		  TreeSet<SolutionList2> solution2=new TreeSet<SolutionList2>(new MyDataComp1());
		  solution2.addAll(solutionlist2);
		  Iterator it=solution2.iterator();
		  int k=0;
		  
		  while(it.hasNext()&&k<5)
		  {
			
			  SolutionList2 sol2=(SolutionList2) it.next();  
		  //System.out.println("Solution2"+sol2.getJobId2()+"\t"+sol2.getCountry2()+"\t"+sol2.getCount2());
		  String jobsdesc=getJobDesc(sol2.getJobId2(),jobs);
		  sol2.setJobdesc2(jobsdesc);
		  k++;
		  }
		  //System.out.println("tes1t");
		  Iterator it1=solution2.iterator();
		int m=0;	 
		/*System.out.println("Problem 2");
		System.out.println("Title ID \t Number of Apps");
		  while(it1.hasNext()&&m<5)
		  {
			
			  SolutionList2 sol2=(SolutionList2) it1.next();  
			  System.out.println(sol2.getJobdesc2()+"\t"+sol2.getCount2()+"\t");
		  m++;
		  }
		*/ return solution2;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private static String getJobDesc(int jobId2, Jobs[] jobs) {
		// TODO Auto-generated method stub
		for(int i=0;i<jobs.length;i++)
		{
			if(jobs[i].getJob_Id()==jobId2)
			{
				return jobs[i].getJobTitle();
			}
		}
		return null;
	}
	
}