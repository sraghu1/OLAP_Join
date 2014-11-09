package datamining_proj;

import java.util.Comparator;

public class MyDataComp1 implements Comparator<SolutionList2> {

	@Override
	public int compare(SolutionList2 arg0, SolutionList2 arg1) {
		// TODO Auto-generated method stub
		if(arg0.getCount2()>arg1.getCount2())
		{
			return -1;
		}
		else if(arg0.getCount2()<arg1.getCount2())
		{
			return 1;
		}
		else
		{
			return 1;
		}
}

}
