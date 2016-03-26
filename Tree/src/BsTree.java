import java.util.ArrayList;

public class BsTree implements ETree
{
	class Node
	{
		int val;
		Node left;
		Node right;
		public Node(int val)
		{
			this.val = val;
		}
	}

	Node root = null;

	public void clear() 
	{
		root = null;
	}
	
	public void init(int[] ini)
	{
		for (int i : ini)
		{
			add(i);
		}
	}
	
	public void add(int val)
	{
		if(root == null)
		{
			root = new Node(val);
		}
		else
		{
			addNode(root, val);
		}
	}
	
	private void addNode(Node p, int val)
	{
		if(val < p.val)
		{
			if(p.left == null)
			{
				p.left = new Node(val);
			}
			else
			{
				addNode(p.left, val);
			}
		}
		else
		{
			if(p.right == null)
			{
				p.right = new Node(val);
			}
			else
			{
				addNode(p.right, val);
			}
		}
	}

	public void print()
	{
		printNode(root);
	}
	private void printNode(Node p)
	{
		if(p == null)
			return;

		printNode(p.left);                 // L
		System.out.print(p.val + ", ");   // V
		printNode(p.right);              // R
	}

	@Override
	public int size() 
	{
		int i=0;
		
		i=sizeNode(root);
		
		return i;
	}
	
	private int sizeNode(Node p)
	{
		int i=0;
		
		if (p == null)
			return i;
				
		i+=sizeNode(p.left);
		i+=sizeNode(p.right);
		i++;
		
		return i;
	}

	@Override
	public int nodes()
	{
		int i=0;
		
		i = nodesNode(root);
		
		return i;
	}
	
	private int nodesNode(Node p)
	{
		int i=0;
		
		if (p  == null)
			return i;
		
		if (p.right != null || p.left != null)
			i++;
		
		i+=nodesNode(p.left);
		i+=nodesNode(p.right);
		
		return i;
	}

	@Override
	public int leaves()
	{
		int i = 0;
		
		i=leavesNode(root);
		
		return i;
	}
	
	private int leavesNode(Node p)
	{
		int i=0;
		
		if (p  == null)
			return i;
		
		if (p.right == null && p.left == null)
			i++;
		
		i+=leavesNode(p.left);
		i+=leavesNode(p.right);
		
		return i;
	}

	@Override
	public int height() 
	{
		int i=0;
		
		i = heightNode(root);
		
		return i;
	}

	private int heightNode(Node p)
	{
		int i = 0;
		
		if (p  == null)
			return i;
		
		i++;
		int k=heightNode(p.left);
		int n=heightNode(p.right);
		
		if(k < n)
			i+=n;
		else
			i+=k;
		
		return i;
	}
	
	@Override
	public int width()
	{
		int m=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int level = 0;
		
		widthNode(root, list, level);
		
		m = list.get(0);
		
		for (int i = 1; i < list.size(); i++)
		{
			if (m < list.get(i))
				m = list.get(i);
		}	
		return m;
	}
	
	private void widthNode(Node p, ArrayList <Integer> list, int lev)
	{
		if (p  == null)
			return;
		
		if(list.size()<=lev)
			list.add(1);
		else
			list.set(lev, list.get(lev)+1);
		
		lev++;
		
		widthNode(p.left, list, lev);
		widthNode(p.right, list, lev);
		
		lev--;
		
		return;
	}

	@Override
	public void reverse() 
	{
		reverseNode(root);
	}
	
	private void reverseNode(Node p)
	{
		if (p  == null)
			return;
		
		reverseNode(p.left);
		reverseNode(p.right);
		
		Node k = p.left;
		p.left = p.right;
		p.right = k;
	}

	@Override
	public void del(int val)
	{
		// TODO Auto-generated method stub

	}
}
