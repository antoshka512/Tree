
public interface ETree 
{
	void clear();
	void init(int[] ini);
	void print();
	
	void add(int val);
	int size();
	int nodes();
	int leaves();
	int height();
	int width();
	
	void reverse();
	
	void del(int val);
	
}
