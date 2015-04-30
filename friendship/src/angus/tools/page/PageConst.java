package angus.tools.page;
//这个类就是为了实现分页的功能
public class PageConst
{
	public static int PAGE_SIZE = 8;

	public static int FIRST = 0;
	
	private int rsCount;

	private int currentPage;
	
	private int pageCount;

	private int pageFirst;

	public PageConst()
	{
	}

	public PageConst(int rsCount, int currentPage)
	{
		setRsCount(rsCount);
		setPageCount();
		setCurrentPage(currentPage);
		setPageFirst();
	}

	public void setRsCount(int rsCount)
	{
		this.rsCount = rsCount;
	}

	public void setCurrentPage(int currentPage)
	{
		if (currentPage > pageCount)
		{
			this.currentPage = pageCount;
		}
		else if (rsCount == 0)
		{
			this.currentPage = 0;
		}
		else if (currentPage <= 0 && rsCount != 0)
		{
			this.currentPage = 1;
		}
		else
		{
			this.currentPage = currentPage;
		}
	}

	public void setPageCount()
	{
		if (rsCount % PAGE_SIZE == 0)
		{
			this.pageCount = rsCount / PAGE_SIZE;
		}
		else
		{
			this.pageCount = rsCount / PAGE_SIZE + 1;
		}
	}
	//计算错了
	public void setPageFirst()
	{
		if (currentPage == 1)
		{
			this.pageFirst = 0;
		}
		else if (currentPage > 1)
		{
			this.pageFirst = (currentPage - 1) * PAGE_SIZE;
		}
		else
		{
			this.pageFirst = 0;
		}
	}

	public int getRsCount()
	{
		return this.rsCount;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}
	//每页的第一条记录
	public int getPageFirst()
	{
		return this.pageFirst;
	}

	public int getPageCount()
	{
		return this.pageCount;
	}
}
