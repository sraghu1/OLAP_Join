package datamining_proj;

import java.util.Comparator;

public class MyDataComp implements Comparator<SolutionList1> {

	@Override
	public int compare(SolutionList1 arg0, SolutionList1 arg1) {
		// TODO Auto-generated method stub
		if(arg0.getCount()>arg1.getCount())
		{
			return -1;
		}
		else if(arg0.getCount()<arg1.getCount())
		{
			return 1;
		}
		else
		{
			return 1;
		}
	}

}
