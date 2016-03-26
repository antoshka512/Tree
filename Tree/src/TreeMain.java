
public class TreeMain 
{
	public static void main(String[] ee)
	{
		int[] ini = {50,25,11,5,20,30,70,100,80,60};
		BsTree tr = new BsTree();
		tr.init(ini);
		tr.print();	
		System.out.println();
		System.out.print("size: " + tr.size() + ", ");
		System.out.print("nodes: " + tr.nodes() + ", ");
		System.out.print("leaves: " + tr.leaves() + ", ");
		System.out.print("height: " + tr.height() + ", ");
		System.out.print("width: " + tr.width() + ", ");
		
		tr.reverse();
		System.out.println();
		tr.print();
		
	}
}
